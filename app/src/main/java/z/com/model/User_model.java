package z.com.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import z.com.base.BaseBean;
import z.com.bean.UserBean;
import z.com.utils.NetWorkUtils;

/**
 * Created by lenovo on 2017/11/29.
 * 获取用户信息的m层
 */

public class User_model implements Model_user {

    /**
     * 获取用户信息
     * @param uid
     */
    @Override
    public void getuser(String uid)
    {
        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .user(uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean)
                    {
                        String code = userBean.code;
                        if("0".equals(code))
                        {
                            user1.getUserSuccess(userBean);
                            System.out.println("===用户信息获取成功=="+userBean.msg+"=="+userBean.getData().getNickname()+"=="+userBean.getData().getIcon());
                        }
                        else if("1".equals(code))
                        {
                            user1.getUserFailure(userBean);
                            System.out.println("===失败啊=="+userBean.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("===失败=="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 修改昵称
     * @param uid
     * @param nickname
     */
    @Override
    public void xg_nickname(String uid, final String nickname)
    {
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("nickname",nickname);

        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .updateNickName(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean)
                    {
                        String code = baseBean.code;
                        if("0".equals(code))
                        {
                            nickname1.getNicknameSuccess(baseBean);
                            System.out.println("===修改昵称成功=="+baseBean.msg);
                        }
                        else if("1".equals(code))
                        {
                            nickname1.getNicknameFailure(baseBean);
                            System.out.println("===修改昵称失败啊=="+baseBean.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("===修改昵称失败=="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 上传头像
     * @param uid
     * @param file
     */
    @Override
    public void sc_picture(String uid, File file)
    {
        MultipartBody.Builder mb=new MultipartBody.Builder().setType(MultipartBody.FORM);
        mb.addFormDataPart("uid",uid);
        mb.addFormDataPart("file",file.getName(), RequestBody.create(MediaType.parse("image*//*"),file));

        List<MultipartBody.Part> parts=mb.build().parts();
        System.out.println("===上传头像=="+uid+"==file=="+file);

        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .upload(parts)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean)
                    {
                        String code = baseBean.code;
                        if("0".equals(code))
                        {
                            head1.getHeadSuccess(baseBean);
                            System.out.println("===上传头像成功=="+baseBean.msg);
                        }
                        else if("1".equals(code))
                        {
                            head1.getHeadFailure(baseBean);
                            System.out.println("===上传头像失败啊=="+baseBean.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("===上传头像失败=="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取用户信息接口
    public User1 user1;

    public void setUser1(User1 user1) {
        this.user1 = user1;
    }

    public interface User1
    {
        void getUserSuccess(UserBean bean);
        void getUserFailure(UserBean bean);
    }

    //修改昵称接口
    public Nickname1 nickname1;

    public void setNickname1(Nickname1 nickname1) {
        this.nickname1 = nickname1;
    }

    public interface Nickname1
    {
        void getNicknameSuccess(BaseBean bean);
        void getNicknameFailure(BaseBean bean);
    }

    //上传头像接口
    public Head1 head1;

    public void setHead1(Head1 head1) {
        this.head1 = head1;
    }

    public interface Head1
    {
        void getHeadSuccess(BaseBean bean);
        void getHeadFailure(BaseBean bean);
    }
}
