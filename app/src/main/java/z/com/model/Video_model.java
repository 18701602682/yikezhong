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
import z.com.bean.VideoBean;
import z.com.utils.NetWorkUtils;

/**
 * Created by lenovo on 2017/12/1.
 */

public class Video_model implements Model_video {

    /**
     * 获取推荐视频
     * @param uid
     * @param type
     * @param page
     */
    @Override
    public void hq_tuijian_video(String uid, String type, String page)
    {
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("type",type);
        map.put("page",page);
        System.out.println("===获取视频==uid"+uid+"==type=="+type+"==page"+page);

        new NetWorkUtils.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCalladapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .getApiService()
                .getVideos(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(VideoBean videoBean)
                    {
                        String code = videoBean.code;
                        if("0".equals(code))
                        {
                            shipinTuijian.getShipinTuijianSuccess(videoBean);
                            System.out.println("===推荐视频获取成功=="+videoBean.msg);
                        }
                        else if("1".equals(code))
                        {
                            shipinTuijian.getShipinTuijianFailure(videoBean);
                            System.out.println("===推荐视频获取失败啊=="+videoBean.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("===推荐视频获取失败=="+e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public ShipinTuijian shipinTuijian;

    public void setShipinTuijian(ShipinTuijian shipinTuijian) {
        this.shipinTuijian = shipinTuijian;
    }

    public interface ShipinTuijian
    {
        void getShipinTuijianSuccess(VideoBean bean);
        void getShipinTuijianFailure(VideoBean bean);
    }
}
