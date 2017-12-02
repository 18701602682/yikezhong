package z.com;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import z.com.base.BaseActivity;
import z.com.bean.ZhuCeBean;
import z.com.presenter.Zhuce_presenter;
import z.com.view.zhuce_view;

/**
 * 注册
 */
public class RegistActivity extends BaseActivity<Zhuce_presenter> implements View.OnClickListener, zhuce_view {

    private TextView hava_regist;
    private ImageView iv_back;
    private EditText et_zhuce_name;
    private EditText et_zhuce_pwd;
    private Button zhuce_button;
    private TextView tv_zhuce_youke_login;

    @Override
    public Zhuce_presenter initPresenter() {
        return new Zhuce_presenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    public void creat()
    {
        initView();
    }

    public void initView() {
        iv_back = findViewById(R.id.iv_back);
        hava_regist = findViewById(R.id.hava_regist);
        et_zhuce_name = findViewById(R.id.et_zhuce_name);
        et_zhuce_pwd = findViewById(R.id.et_zhuce_pwd);
        zhuce_button = findViewById(R.id.zhuce_button);
        tv_zhuce_youke_login = findViewById(R.id.tv_zhuce_youke_login);

        iv_back.setOnClickListener(this);
        hava_regist.setOnClickListener(this);
        zhuce_button.setOnClickListener(this);
        tv_zhuce_youke_login.setOnClickListener(this);
    }

    @Override
    public boolean bool() {
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.iv_back:
                finish();
                break;
            case R.id.hava_regist:
                //已经有了账号   进入登录界面
                startActivity(LoginActivity.class);
                finish();
                break;
            case R.id.zhuce_button:
                String mobile = et_zhuce_name.getText().toString();
                String password = et_zhuce_pwd.getText().toString();
                presenter.zhuce(mobile,password);
                break;
            case R.id.tv_zhuce_youke_login:
                //游客登录，进入主页
                startActivity(MainActivity.class);
                finish();
                break;
        }
    }

    @Override
    public void Success(ZhuCeBean result)
    {
        ShowToast(result.getMsg());
        System.out.println("==="+result.getMsg());
        startActivity(LoginActivity.class);
        finish();
    }

    @Override
    public void data_faile(ZhuCeBean msg) {
        ShowToast(msg.getMsg());
    }

    @Override
    public void faile(ZhuCeBean msg) {
        ShowToast(msg.getMsg());
    }
}
