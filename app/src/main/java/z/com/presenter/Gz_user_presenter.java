package z.com.presenter;

import z.com.base.BaseBean;
import z.com.base.BasePresenter;
import z.com.model.Guanzhu_model;
import z.com.view.Gz_user_view;

/**
 * Created by lenovo on 2017/12/1.
 */

public class Gz_user_presenter extends BasePresenter<Gz_user_view> implements Guanzhu_model.guanzhuUser {

    private Guanzhu_model guanzhu_model;

    public Gz_user_presenter(Gz_user_view mView) {
        super(mView);

        guanzhu_model=new Guanzhu_model();
        guanzhu_model.setGuanzhuUser(this);
    }

    public void gz_user(String uid, String followId)
    {
        guanzhu_model.gz_user(uid,followId);
    }

    @Override
    public void getUserSuccess(BaseBean bean) {
        mView.Success(bean);
    }

    @Override
    public void getUserFailure(BaseBean bean) {
        mView.data_faile(bean);
    }
}
