package z.com;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_regist;
    private TextView forget_pwd;
    private TextView login_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(Build.VERSION.SDK_INT>=
                Build.VERSION_CODES.KITKAT) {

            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        initView();
    }

    private void initView() {
        iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_regist = findViewById(R.id.tv_regist);
        tv_regist.setOnClickListener(this);
        forget_pwd = findViewById(R.id.forget_pwd);
        forget_pwd.setOnClickListener(this);
        login_in = findViewById(R.id.login_in);
        login_in.setOnClickListener(this);
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
                Intent intent2=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent2);
                break;
        }

    }
}
