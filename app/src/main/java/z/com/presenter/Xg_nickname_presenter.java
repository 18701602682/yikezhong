package z.com.presenter;

import java.io.File;

import z.com.base.BaseBean;
import z.com.base.BasePresenter;
import z.com.model.Duanzi_model;
import z.com.model.User_model;
import z.com.view.F_duanzi_view;
import z.com.view.xg_nickname_view;

/**
 * Created by lenovo on 2017/11/29.
 * 修改昵称
 */

public class Xg_nickname_presenter extends BasePresenter<xg_nickname_view> implements User_model.Nickname1, User_model.Head1 {

    private User_model user_model;

    public Xg_nickname_presenter(xg_nickname_view mView) {
        super(mView);

        user_model=new User_model();
        user_model.setNickname1(this);

        user_model.setHead1(this);
    }

    //修改昵称
    public void xg_nickname(String uid, String nickname)
    {
        user_model.xg_nickname(uid,nickname);
    }

    //上传头像
    public void sc_picture(String uid, File file)
    {
        user_model.sc_picture(uid,file);
    }

    /**
     * 修改昵称
     * @param bean
     */
    @Override
    public void getNicknameSuccess(BaseBean bean) {
        mView.Success(bean);
    }

    @Override
    public void getNicknameFailure(BaseBean bean) {
        mView.data_faile(bean);
    }

    /**
     * 上传头像
     * @param bean
     */
    @Override
    public void getHeadSuccess(BaseBean bean) {
        mView.Success(bean);
    }

    @Override
    public void getHeadFailure(BaseBean bean) {
        mView.data_faile(bean);
    }
}
