package z.com.model;

import android.support.annotation.MainThread;

import org.reactivestreams.Subscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.greenrobot.event.Subscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import z.com.base.BaseBean;
import z.com.bean.LoginBean;
import z.com.bean.ZhuCeBean;
import z.com.utils.NetWorkUtils;

/**
 * Created by lenovo on 2017/11/28.
 */

public class Login_zhu_model implements Model_ {

    /**
     * 登录
     * @param mobile
     * @param password
     */
    @Override
    public void login(String mobile, String password)
    {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);

        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean)
                    {
                        String code = loginBean.code;
                        if("0".equals(code))
                        {
                            login1.getLoginSuccess(loginBean);
                            System.out.println("===登录成功=="+loginBean.msg);
                        }
                        else if("1".equals(code))
                        {
                            login1.getLoginFailure(loginBean);
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
     * 注册
     * @param mobile
     * @param password
     */
    @Override
    public void zhuce(String mobile, String password)
    {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);

        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .zhuce(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuCeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhuCeBean zhuCeBean)
                    {
                        String code = zhuCeBean.getCode();
                        if("0".equals(code))
                        {
                            zhuce1.getZhuceSuccess(zhuCeBean);
                        }
                        else if("1".equals(code))
                        {
                            zhuce1.getZhuceFailure(zhuCeBean);
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

    //登录暴露的接口
    private Login1 login1;

    public void setLogin1(Login1 login1) {
        this.login1 = login1;
    }

    public interface Login1
    {
        void getLoginSuccess(LoginBean login);
        void getLoginFailure(LoginBean login);
    }

    //注册暴露的接口
    private Zhuce1 zhuce1;

    public void setZhuce1(Zhuce1 zhuce1) {
        this.zhuce1 = zhuce1;
    }

    public interface Zhuce1
    {
        void getZhuceSuccess(ZhuCeBean bean);
        void getZhuceFailure(ZhuCeBean bean);
    }
}
