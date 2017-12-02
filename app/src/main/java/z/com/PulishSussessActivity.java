package z.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import z.com.frag.Frag2;

public class PulishSussessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulish_sussess);

        initView();
    }

    private void initView()
    {
        TextView cg_tv_back=findViewById(R.id.cg_tv_back);
        Button cg_bt_look=findViewById(R.id.cg_bt_look);

        cg_bt_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(PulishSussessActivity.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
