package z.com;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * 引导页
 */
public class LoadActivity extends AppCompatActivity {

    private int time=3;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time--;
            if(time>0)
            {
                Toast.makeText(LoadActivity.this, ""+time, Toast.LENGTH_SHORT).show();
            }else if(time==0){
                Intent intent=new Intent(LoadActivity.this,LoginStyleActivity.class);
                startActivity(intent);
            }
            handler.sendEmptyMessage(100);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        handler.sendEmptyMessageDelayed(100,1000);

    }
}
