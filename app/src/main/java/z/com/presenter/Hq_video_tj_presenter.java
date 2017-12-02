package z.com.presenter;

import z.com.base.BaseBean;
import z.com.base.BasePresenter;
import z.com.bean.VideoBean;
import z.com.model.Video_model;
import z.com.view.hq_shipin_view;

/**
 * Created by lenovo on 2017/12/1.
 */

public class Hq_video_tj_presenter extends BasePresenter<hq_shipin_view> implements Video_model.ShipinTuijian {

    private Video_model video_model;

    public Hq_video_tj_presenter(hq_shipin_view mView) {
        super(mView);

        video_model=new Video_model();
        video_model.setShipinTuijian(this);
    }

    public void hq_tuijian_video(String uid, String type, String page)
    {
        video_model.hq_tuijian_video(uid,type,page);
    }


    @Override
    public void getShipinTuijianSuccess(VideoBean bean) {
        mView.Success(bean);
    }

    @Override
    public void getShipinTuijianFailure(VideoBean bean) {
        mView.data_faile(bean);
    }
}
