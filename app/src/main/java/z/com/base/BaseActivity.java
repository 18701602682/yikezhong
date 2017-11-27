package z.com.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 2017/11/23.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity{

    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        presenter=initPresenter();
    }

    public abstract P initPresenter();
    public abstract int getLayoutId();
    public abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatach();//解绑
    }
}
