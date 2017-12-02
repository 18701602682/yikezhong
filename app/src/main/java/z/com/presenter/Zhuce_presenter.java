package z.com.presenter;

import z.com.base.BasePresenter;
import z.com.bean.ZhuCeBean;
import z.com.model.Login_zhu_model;
import z.com.view.zhuce_view;

/**
 * Created by lenovo on 2017/11/29.
 */

public class Zhuce_presenter extends BasePresenter<zhuce_view> implements Login_zhu_model.Zhuce1 {

    private Login_zhu_model login_zhu_model;

    public Zhuce_presenter(zhuce_view mView) {
        super(mView);
        login_zhu_model=new Login_zhu_model();
        login_zhu_model.setZhuce1(this);
    }

    public void zhuce(String mobile,String pwd)
    {
        login_zhu_model.zhuce(mobile,pwd);
    }

    @Override
    public void getZhuceSuccess(ZhuCeBean bean) {
        mView.Success(bean);
    }

    @Override
    public void getZhuceFailure(ZhuCeBean bean) {
        mView.data_faile(bean);
    }
}
