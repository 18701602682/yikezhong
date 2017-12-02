package z.com.presenter;

import z.com.base.BasePresenter;
import z.com.bean.GetjokeBean;
import z.com.model.Duanzi_model;
import z.com.view.H_duanzi_view;

/**
 * Created by lenovo on 2017/11/29.
 * 获取段子
 */

public class H_duanzi_presenter extends BasePresenter<H_duanzi_view> implements Duanzi_model.getDuanzi {

    private Duanzi_model duanzi_model;

    public H_duanzi_presenter(H_duanzi_view mView) {
        super(mView);

        duanzi_model=new Duanzi_model();
        duanzi_model.setGetduanzi(this);
    }

    public void huoqu_duanzi(String page)
    {
        duanzi_model.huoqu_duanzi(page);
    }

    @Override
    public void getDuanziSuccess(GetjokeBean bean) {
        mView.Success(bean);
    }

    @Override
    public void getDuanziFailure(GetjokeBean bean) {
        mView.data_faile(bean);
    }
}
