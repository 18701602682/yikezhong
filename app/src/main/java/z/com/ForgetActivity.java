package z.com;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView forget_back;
    private TextView for_already_regist;
    private Button but_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

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
        forget_back = findViewById(R.id.forget_back);
        forget_back.setOnClickListener(this);
        for_already_regist = findViewById(R.id.for_already_regist);
        for_already_regist.setOnClickListener(this);
        but_next = findViewById(R.id.but_next);
        but_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.forget_back:
                finish();
                break;
            case R.id.for_already_regist:
                //已经有了账号   进入登录界面
                Intent intent=new Intent(ForgetActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.but_next:
                //忘记密码  进行下一步的修改
                Intent intent1=new Intent(ForgetActivity.this,Forget_TwoActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
