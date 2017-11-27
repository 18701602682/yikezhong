package z.com;

import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import z.com.frag.Zp_bendi;
import z.com.frag.Zp_shangchuan;

public class ZuoPinActivity extends AppCompatActivity {

    private TabLayout zp_tablayout;
    private ViewPager zp_vp;
    private List<String> list;
    private TextView zp_tv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuo_pin);

        initData();
        initView();
    }

    private void initData()
    {
        list = new ArrayList<>();
        list.add("本地作品");
        list.add("已上传");
    }

    private void initView()
    {
        zp_tv_back = findViewById(R.id.zp_tv_back);
        zp_tablayout = findViewById(R.id.zp_tablayout);
        zp_vp =findViewById(R.id.zp_vp);
        zp_vp.setAdapter(new zp_adapter(getSupportFragmentManager()));
        zp_tablayout.setupWithViewPager(zp_vp);
        MysetIndicator(zp_tablayout,50,50);
    }

    class zp_adapter extends FragmentPagerAdapter
    {
        public zp_adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            Fragment f=null;
            switch (position)
            {
                case 0:
                    f=new Zp_bendi();
                    break;
                case 1:
                    f=new Zp_shangchuan();
                    break;
            }
            return f;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }
    }

    /**
     * tablayout的间距
     * @param tabs
     * @param leftDip 左
     * @param rightDip 右
     */
    public void MysetIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
