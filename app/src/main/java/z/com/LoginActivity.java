package z.com;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import z.com.base.BaseActivity;
import z.com.bean.LoginBean;
import z.com.presenter.Login_Presenter;
import z.com.view.login_view;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity<Login_Presenter> implements View.OnClickListener, login_view {

    private ImageView iv_back;
    private TextView tv_regist;
    private TextView forget_pwd;
    private TextView login_in;
    private EditText et_name;
    private EditText et_pwd;
    private Button login_button1;

    @Override
        public Login_Presenter initPresenter() {
            return new Login_Presenter(this);
        }

        @Override
        public int getLayoutId() {
            return R.layout.activity_login;
        }

    @Override
    public void creat()
    {
        initView();
    }

    public void initView()
    {
        iv_back = findViewById(R.id.iv_back);//返回
        tv_regist = findViewById(R.id.tv_regist);//注册
        forget_pwd = findViewById(R.id.forget_pwd);//忘记密码
        login_in = findViewById(R.id.login_in);//游客登录
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        login_button1 = findViewById(R.id.login_button1);

        iv_back.setOnClickListener(this);
        tv_regist.setOnClickListener(this);
        forget_pwd.setOnClickListener(this);
        login_in.setOnClickListener(this);
        login_button1.setOnClickListener(this);
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
                //关闭此页面
                finish();
                break;
            case R.id.tv_regist:
                //进入注册界面
                Intent intent=new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.forget_pwd:
                //忘记密码进入修改界面
                Intent intent1=new Intent(LoginActivity.this,ForgetActivity.class);
                startActivity(intent1);
                break;
            case R.id.login_in:
                //游客登录  直接进入主页
                startActivity(MainActivity.class);
                finish();
                break;
            case R.id.login_button1:
                String mobile = et_name.getText().toString();
                String password = et_pwd.getText().toString();
                presenter.login(mobile,password);//调用m层登录的方法1
        }
    }

    @Override
    public void Success(LoginBean result)
    {
        ShowToast(result.msg);
        SharedPreferences sp_token=getSharedPreferences("sp_token",MODE_PRIVATE);
        sp_token.edit().putString("token",result.getData().getToken()).commit();

        SharedPreferences sp_uid=getSharedPreferences("sp_uid",MODE_PRIVATE);
        sp_uid.edit().putString("uid",result.getData().getUid()+"").commit();
        System.out.println("===uid=="+sp_uid.getString("uid",""));

        startActivity(MainActivity.class);
    }

    @Override
    public void data_faile(LoginBean msg)
    {
        ShowToast(msg.msg);
    }

    @Override
    public void faile(LoginBean msg)
    {
        ShowToast(msg.msg);
    }
}
