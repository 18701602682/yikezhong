package z.com.presenter;

import z.com.base.BaseBean;
import z.com.base.BasePresenter;
import z.com.bean.UserBean;
import z.com.model.User_model;
import z.com.view.User_view;

/**
 * Created by lenovo on 2017/11/30.
 */

public class User_presenter extends BasePresenter<User_view> implements User_model.User1 {

    private User_model user_model;

    public User_presenter(User_view mView) {
        super(mView);

        user_model=new User_model();
        user_model.setUser1(this);
    }

    public void getuser(String uid)
    {
        user_model.getuser(uid);
    }

    @Override
    public void getUserSuccess(UserBean bean) {
        mView.Success(bean);
    }

    @Override
    public void getUserFailure(UserBean bean) {
        mView.data_faile(bean);
    }
}
