package z.com.frag;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import z.com.R;

/**
 * Created by lenovo on 2017/11/14.
 */

public class Frag3 extends Fragment{

    private View view;
    private TabLayout f3_tabLayout;
    private ViewPager f3_vp;
    private List<String> list3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view = View.inflate(getContext(), R.layout.frag3,null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        initView();
        MysetIndicator(f3_tabLayout,50,50);
    }

    /**
     * 初始化数据
     */
    private void initData()
    {
        list3 = new ArrayList<>();
        list3.add("热门");
        list3.add("附近");
    }

    /**
     * 初始化控件
     */
    private void initView()
    {
        f3_tabLayout = view.findViewById(R.id.f3_tablayout);
        f3_vp = view.findViewById(R.id.f3_vp);
        f3_vp.setAdapter(new f3_adapter(getActivity().getSupportFragmentManager()));
        f3_tabLayout.setupWithViewPager(f3_vp);
    }

    /**
     * ViewPager的适配器
     */
    class f3_adapter extends FragmentPagerAdapter
    {
        public f3_adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            Fragment f3=null;
            switch (position)
            {
                case 0:
                    f3=new Frag3_remen();
                    break;
                case 1:
                    f3=new Frag3_fujin();
                    break;
            }
            return f3;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return list3.get(position);
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
