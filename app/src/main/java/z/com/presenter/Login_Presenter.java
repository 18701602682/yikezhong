package z.com.presenter;

import z.com.base.BasePresenter;
import z.com.bean.LoginBean;
import z.com.model.Login_zhu_model;
import z.com.view.login_view;

/**
 * Created by lenovo on 2017/11/28.
 */

public class Login_Presenter extends BasePresenter<login_view> implements Login_zhu_model.Login1 {

    private Login_zhu_model login_model;

    public Login_Presenter(login_view mView) {
        super(mView);
        login_model=new Login_zhu_model();
        login_model.setLogin1(this);
    }

    public void login(String mobile,String pwd)
    {
        login_model.login(mobile,pwd);
    }


    @Override
    public void getLoginSuccess(LoginBean login) {
        mView.Success(login);
    }

    @Override
    public void getLoginFailure(LoginBean login) {
        mView.data_faile(login);
    }
}
