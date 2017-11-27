package z.com.frag;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import z.com.R;

/**
 * Created by lenovo on 2017/11/25.
 */

public class Frag1_remen extends Fragment{

    private View view;
    private XBanner f_remen_banner;
    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    private List<Integer> list_xbanner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view = View.inflate(getActivity(), R.layout.frag1_remen,null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
    }

    private void initData()
    {
        list_xbanner = new ArrayList<>();
        list_xbanner.add(R.drawable.raw_1500258840);
        list_xbanner.add(R.drawable.raw_1500258881);
        list_xbanner.add(R.drawable.raw_1500258901);
        list_xbanner.add(R.drawable.raw_1500259026);

        f_remen_banner.setData(list_xbanner,null);
        f_remen_banner.setPoinstPosition(XBanner.RIGHT);

        f_remen_banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position)
            {
                Glide.with(getActivity()).load(list_xbanner.get(position)).into((ImageView) view);
            }
        });
    }

    private void initView()
    {
        f_remen_banner = view.findViewById(R.id.f_remen_banner);
    }


}
