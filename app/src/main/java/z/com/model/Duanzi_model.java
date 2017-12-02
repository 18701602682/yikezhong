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
import retrofit2.http.Body;
import z.com.base.BaseBean;
import z.com.bean.GetjokeBean;
import z.com.bean.ZhuCeBean;
import z.com.utils.NetWorkUtils;

/**
 * Created by lenovo on 2017/11/29.
 * 获取/发布段子m层
 */

public class Duanzi_model implements Model_dz {
    /**
     * 发表段子
     * @param uid
     * @param content
     */
    @Override
    public void fabiao_duanzi(String uid, String content,List<String> jokeFiles)
    {
        MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("uid",uid);
        builder.addFormDataPart("content",content);

        for (int i = 0; i < jokeFiles.size(); i++) {
            File file=new File(jokeFiles.get(i));
            RequestBody requestBody=RequestBody.create(MediaType.parse("multipart/form-data"),file);
            builder.addFormDataPart("jokeFiles",file.getName(),requestBody);
        }
        List<MultipartBody.Part> parts=builder.build().parts();

        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .publishJoke(parts)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
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
                            fabuduanzi.fabuDuanziSuccess(baseBean);
                            System.out.println("===发表段子成功=="+baseBean.msg);
                        }
                        else if("1".equals(code))
                        {
                            fabuduanzi.fabuDuanziFailure(baseBean);
                            System.out.println("=====失败啊=="+baseBean.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("=====失败=="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 获取段子
     * @param page
     */
    @Override
    public void huoqu_duanzi(String page)
    {
        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .getJokes(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetjokeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetjokeBean getjokeBean)
                    {
                        String code = getjokeBean.code;
                        if("0".equals(code))
                        {
                            getduanzi.getDuanziSuccess(getjokeBean);
                        }
                        else if("1".equals(code))
                        {
                            getduanzi.getDuanziFailure(getjokeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 获取段子接口
     */
    public getDuanzi getduanzi;

    public void setGetduanzi(getDuanzi getduanzi) {
        this.getduanzi = getduanzi;
    }

    public interface getDuanzi
    {
        void getDuanziSuccess(GetjokeBean bean);
        void getDuanziFailure(GetjokeBean bean);
    }

    /**
     * 发布段子接口
     */
    public fabuDuanzi fabuduanzi;

    public void setFabuduanzi(fabuDuanzi fabuduanzi) {
        this.fabuduanzi = fabuduanzi;
    }

    public interface fabuDuanzi
    {
        void fabuDuanziSuccess(BaseBean bean);
        void fabuDuanziFailure(BaseBean bean);
    }
}
