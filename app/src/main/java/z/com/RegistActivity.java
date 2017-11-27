package z.com;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView hava_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

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
        hava_regist = findViewById(R.id.hava_regist);
        hava_regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.hava_regist:
                //已经有了账号   进入登录界面
                Intent intent=new Intent(RegistActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }

    }
}
