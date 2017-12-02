package z.com.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import z.com.base.BaseBean;
import z.com.utils.NetWorkUtils;

/**
 * Created by lenovo on 2017/12/1.
 */

public class Guanzhu_model implements Model_gz_dz {
    /**
     * 关注用户
     * @param uid
     * @param followId
     */
    @Override
    public void gz_user(String uid, String followId)
    {
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("followId",followId);
        System.out.println("===model==uid=="+uid+"==followId=="+followId);

        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .follow(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                            guanzhuUser.getUserSuccess(baseBean);
                            System.out.println("===用户关注成功=="+baseBean.msg);
                        }
                        else if("1".equals(code))
                        {
                            guanzhuUser.getUserFailure(baseBean);
                            System.out.println("===用户关注失败啊=="+baseBean.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("===用户关注失败=="+e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 作品点赞
     * @param uid
     * @param wid
     */
    @Override
    public void dz_works(String uid, String wid) {

    }

    //关注用户
    public guanzhuUser guanzhuUser;

    public void setGuanzhuUser(Guanzhu_model.guanzhuUser guanzhuUser) {
        this.guanzhuUser = guanzhuUser;
    }

    public interface guanzhuUser
    {
        void getUserSuccess(BaseBean bean);
        void getUserFailure(BaseBean bean);
    }
}
