package z.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SheZhiActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);

        initView();
    }

    private void initView()
    {
        TextView tv_shezhi_back=findViewById(R.id.tv_shezhi_back);

        tv_shezhi_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv_shezhi_back:
                Intent intent=new Intent(SheZhiActivity.this,MainActivity.class);
                startActivity(intent);
                System.out.println("===设置");
                break;
        }
    }
}
