package z.com.presenter;

import java.util.List;

import z.com.base.BaseBean;
import z.com.base.BasePresenter;
import z.com.model.Duanzi_model;
import z.com.view.F_duanzi_view;

/**
 * Created by lenovo on 2017/11/29.
 * 发表段子
 */

public class F_duanzi_presenter extends BasePresenter<F_duanzi_view> implements Duanzi_model.fabuDuanzi {

    private Duanzi_model duanzi_model;

    public F_duanzi_presenter(F_duanzi_view mView) {
        super(mView);

        duanzi_model=new Duanzi_model();
        duanzi_model.setFabuduanzi(this);
    }

    public void fabiao_duanzi(String uid, String content,List<String> jokeFiles)
    {
        duanzi_model.fabiao_duanzi(uid,content,jokeFiles);
    }

    @Override
    public void fabuDuanziSuccess(BaseBean bean) {
        mView.Success(bean);
    }

    @Override
    public void fabuDuanziFailure(BaseBean bean) {
        mView.data_faile(bean);
    }
}
