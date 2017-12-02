package z.com.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import z.com.utils.ImmersionUtil;

/**
 * Created by lenovo on 2017/11/23.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity{

    public P presenter;
    public Toast toast;

    public abstract P initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        presenter=initPresenter();
        creat();
        setFull(bool());
    }

    public abstract int getLayoutId();
    public abstract void creat();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null)
        {
            presenter.deatach();//解绑
        }
    }

    //吐司
    public void ShowToast(String msg)
    {
        if(toast==null)
        {
            toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 无参跳转
     * @param c
     */
    public void startActivity(Class<?> c)
    {
        Intent intent=new Intent(this,c);
        startActivity(intent);
    }

    /**
     * 有参跳转
     * @param c
     * @param bundle
     */
    public void startActivity(Class<?> c,Bundle bundle)
    {
        Intent intent=new Intent(this,c);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 沉浸式
     * @param hasFocus
     */
    public void setFull(boolean hasFocus){
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    //返回true有沉浸式，false无沉浸式
    public abstract boolean bool();
}
