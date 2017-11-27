package z.com;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.igexin.sdk.PushManager;
import com.kson.slidingmenu.SlidingMenu;
import com.tencent.bugly.crashreport.CrashReport;

import z.com.frag.Frag1;
import z.com.frag.Frag2;
import z.com.frag.Frag3;
import z.com.frag.LeftFragment;
import z.com.utils.DemoIntentService;
import z.com.utils.DemoPushService;
import z.com.utils.ImmersionUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private ImageView iv_tuijian;
    private ImageView iv_duanzi;
    private ImageView iv_shipin;
    private TextView tv_tuijian;
    private TextView tv_duanzi;
    private TextView tv_shipin;
    private TextView tv_name;
    private ImageView iv_touxaing;
    private SlidingMenu slidingMenu;
    private ImageView iv_bianji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bugly
        //CrashReport.testJavaCrash();

        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(), DemoPushService.class);
        // com.getui.demo.DemoIntentService 为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);

        initView();
        initData();
        initMenu();
    }

    /**
     * 侧滑
     */
    private void initMenu()
    {
        slidingMenu = new SlidingMenu(this);
        //添加左侧滑
        slidingMenu.setMenu(R.layout.left_menu_content);
        getSupportFragmentManager().beginTransaction().replace(R.id.left_menu_content,new LeftFragment()).commit();
        //设置显示模式，左
        slidingMenu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        // 设置滑动菜单视图的宽度
        slidingMenu.setBehindOffsetRes(R.dimen.size);
        // 设置渐入渐出效果的值
        slidingMenu.setFadeDegree(0.75f);

        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
    }

    private void initView()
    {
        iv_tuijian = findViewById(R.id.iv_tuijian);
        iv_duanzi = findViewById(R.id.iv_duanzi);
        iv_shipin = findViewById(R.id.iv_shipin);
        iv_bianji = findViewById(R.id.iv_bianji);
        iv_touxaing = findViewById(R.id.iv_touxaing);

        tv_name = findViewById(R.id.tv_name);
        tv_tuijian = findViewById(R.id.tv_tuijian);
        tv_duanzi = findViewById(R.id.tv_duanzi);
        tv_shipin = findViewById(R.id.tv_shipin);

        iv_tuijian.setOnClickListener(this);
        iv_duanzi.setOnClickListener(this);
        iv_shipin.setOnClickListener(this);
        iv_touxaing.setOnClickListener(this);
        iv_bianji.setOnClickListener(this);
    }

    private void initData()
    {
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();

        getSupportFragmentManager().beginTransaction().add(R.id.fl,frag1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,frag2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,frag3).commit();

        tv_name.setText("推荐");
        iv_tuijian.setImageResource(R.drawable.raw_1500085367);
        iv_duanzi.setImageResource(R.drawable.raw_1500085327);
        iv_shipin.setImageResource(R.drawable.raw_1500083686);

        tv_tuijian.setTextColor(Color.BLUE);
        tv_duanzi.setTextColor(Color.GRAY);
        tv_shipin.setTextColor(Color.GRAY);

        getSupportFragmentManager().beginTransaction().show(frag1).commit();
        getSupportFragmentManager().beginTransaction().hide(frag2).commit();
        getSupportFragmentManager().beginTransaction().hide(frag3).commit();
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.iv_tuijian:
                tv_name.setText("推荐");
                iv_tuijian.setImageResource(R.drawable.raw_1500085367);
                iv_duanzi.setImageResource(R.drawable.raw_1500085327);
                iv_shipin.setImageResource(R.drawable.raw_1500083686);

                tv_tuijian.setTextColor(Color.BLUE);
                tv_duanzi.setTextColor(Color.GRAY);
                tv_shipin.setTextColor(Color.GRAY);

                getSupportFragmentManager().beginTransaction().show(frag1).commit();
                getSupportFragmentManager().beginTransaction().hide(frag2).commit();
                getSupportFragmentManager().beginTransaction().hide(frag3).commit();
                break;
            case R.id.iv_duanzi:
                tv_name.setText("段子");
                iv_tuijian.setImageResource(R.drawable.raw_1500083878);
                iv_duanzi.setImageResource(R.drawable.raw_1500085899);
                iv_shipin.setImageResource(R.drawable.raw_1500083686);

                tv_tuijian.setTextColor(Color.GRAY);
                tv_duanzi.setTextColor(Color.BLUE);
                tv_shipin.setTextColor(Color.GRAY);

                getSupportFragmentManager().beginTransaction().show(frag2).commit();
                getSupportFragmentManager().beginTransaction().hide(frag1).commit();
                getSupportFragmentManager().beginTransaction().hide(frag3).commit();
                break;
            case R.id.iv_shipin:
                tv_name.setText("视频");
                iv_tuijian.setImageResource(R.drawable.raw_1500083878);
                iv_duanzi.setImageResource(R.drawable.raw_1500085327);
                iv_shipin.setImageResource(R.drawable.raw_1500086067);

                tv_tuijian.setTextColor(Color.GRAY);
                tv_duanzi.setTextColor(Color.GRAY);
                tv_shipin.setTextColor(Color.BLUE);

                getSupportFragmentManager().beginTransaction().show(frag3).commit();
                getSupportFragmentManager().beginTransaction().hide(frag1).commit();
                getSupportFragmentManager().beginTransaction().hide(frag2).commit();
                break;
            case R.id.iv_touxaing:
                //显示左侧拉
                slidingMenu.showMenu();
                break;
            case R.id.iv_bianji:
                //跳转到创作页面(视频，段子)
                Intent intent=new Intent(MainActivity.this,WriteActivity.class);
                startActivity(intent);
                System.out.println("====");
                break;
        }
    }
}
