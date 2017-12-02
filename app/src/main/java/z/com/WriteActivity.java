package z.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView back;
    private ImageView iv_cz_shipin;
    private ImageView iv_cz_duanzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        initView();
    }

    private void initView() {
        back = findViewById(R.id.back);
        iv_cz_shipin = findViewById(R.id.iv_cz_shipin);
        iv_cz_duanzi = findViewById(R.id.iv_cz_duanzi);

        back.setOnClickListener(this);
        iv_cz_shipin.setOnClickListener(this);
        iv_cz_duanzi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.back:
                finish();
                break;
            case R.id.iv_cz_shipin:
                break;
            case R.id.iv_cz_duanzi:
                Intent intent=new Intent(WriteActivity.this,DuanZiActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
