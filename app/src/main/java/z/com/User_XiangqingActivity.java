package z.com;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import z.com.base.BaseActivity;
import z.com.base.BaseBean;
import z.com.presenter.Gz_user_presenter;
import z.com.view.Gz_user_view;

public class User_XiangqingActivity extends BaseActivity<Gz_user_presenter> implements Gz_user_view, View.OnClickListener {

    private TextView tv_user_name;
    private ImageView iv_user_head;
    private String icon;
    private String nickname;

    @Override
    public Gz_user_presenter initPresenter() {
        return new Gz_user_presenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_xiangqing;
    }

    @Override
    public void creat() {
        initView();
    }

    @Override
    public boolean bool() {
        return false;
    }

    private void initView()
    {
        ImageView iv_user_back=findViewById(R.id.iv_user_back);
        ImageView iv_user_fenxaing=findViewById(R.id.iv_user_fenxaing);
        ImageView iv_user_pinglun=findViewById(R.id.iv_user_pinglun);
        iv_user_head = findViewById(R.id.iv_user_head);
        ImageView iv_user_dianzan=findViewById(R.id.iv_user_dianzan);
        tv_user_name = findViewById(R.id.tv_user_name);
        TextView tv_user_fensi=findViewById(R.id.tv_user_fensi);
        TextView tv_user_guanzhu=findViewById(R.id.tv_user_guanzhu);
        TextView tv_user_zuopin_mun=findViewById(R.id.tv_user_zuopin_mun);
        Button bt_user_guanzhu=findViewById(R.id.bt_user_guanzhu);
        XRecyclerView xrlv_user=findViewById(R.id.xrlv_user);

        iv_user_back.setOnClickListener(this);
        bt_user_guanzhu.setOnClickListener(this);
        tv_user_name.setText(nickname);
        //iv_user_head.setImageURI(Uri.parse(icon));
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.iv_user_back:
                finish();
                break;
            case R.id.iv_user_fenxaing:
                break;
            case R.id.iv_user_pinglun:
                break;
            case R.id.iv_user_dianzan:
                break;
            case R.id.bt_user_guanzhu:
                Intent in= getIntent();
                String followId = in.getStringExtra("followId");
                icon = in.getStringExtra("icon");
                nickname = in.getStringExtra("nickname");
                System.out.println("===nickname=="+nickname);
                SharedPreferences sp_uid=getSharedPreferences("sp_uid",MODE_PRIVATE);
                String uid = sp_uid.getString("uid", "");
                presenter.gz_user(uid,followId);
                System.out.println("===uid=="+uid+"==followId=="+followId);
                break;
        }
    }

    @Override
    public void Success(BaseBean result) {
        ShowToast(result.msg);
    }

    @Override
    public void data_faile(BaseBean msg) {
        ShowToast(msg.msg);
    }

    @Override
    public void faile(BaseBean msg) {
        ShowToast(msg.msg);
    }
}
