package z.com.frag;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import z.com.R;
import z.com.adapter.Frag1_Adapter;
import z.com.base.BaseFragment;
import z.com.bean.VideoBean;
import z.com.presenter.Hq_video_tj_presenter;
import z.com.view.hq_shipin_view;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lenovo on 2017/11/25.
 */

public class Frag1_remen extends BaseFragment<Hq_video_tj_presenter> implements hq_shipin_view {

    private XBanner f_remen_banner;
    private List<Integer> list_xbanner;
    private ImageView iv_frag1_xh;
    private PlayerView play;
    private XRecyclerView f_remen_xrl;
    private List<VideoBean.DataBean> list;
    private int page=1;
    private View view1;


    @Override
    public int getLayoutId() {
        return R.layout.frag1_remen;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void Creat()
    {
        initPage();
        initView();
        initData();
    }

    private void initPage()
    {
        present_frag=new Hq_video_tj_presenter(this);
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

        view1 = View.inflate(getContext(), R.layout.xbanner_item,null);
        f_remen_banner = view1.findViewById(R.id.f_remen_banner);

        //RelativeLayout rll=view.findViewById(R.id.rll);
        f_remen_xrl = view.findViewById(R.id.f_remen_xrl);
        f_remen_xrl.setLayoutManager(new LinearLayoutManager(getActivity()));

        SharedPreferences sp_uid=getActivity().getSharedPreferences("sp_uid",MODE_PRIVATE);
        String uid = sp_uid.getString("uid", "");
        present_frag.hq_tuijian_video(uid,"1","1");
        System.out.println("===走了吗？");



        f_remen_xrl.addHeaderView(view1);
    }

    @Override
    public void Success(VideoBean result)
    {
        list = result.getData();
        Frag1_Adapter fa1=new Frag1_Adapter(getContext(), list);
        f_remen_xrl.setAdapter(fa1);
    }

    @Override
    public void data_faile(VideoBean msg) {
        ShowToast(msg.msg);
    }

    @Override
    public void faile(VideoBean msg) {
        ShowToast(msg.msg);
    }











        /*rll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://v.youku.com/v_show/id_XMzE5MzQ5MTEwMA==.html?tpa=dW5pb25faWQ9MzAwMDAzXzEwMDAxNF8wNF8wMQ&fromvsogou=1";
                play = new PlayerView(getActivity())
                        .setTitle("什么")
                        .setScaleType(PlayStateParams.fitparent)
                        .hideMenu(true)
                        .forbidTouch(false)
                        .setPlaySource(url);
                play.startPlay();
            }
        });*/
    /*//当你离开播放界面的时候视频停止播放
    @Override
    public void onStop() {
        super.onStop();
        play.stopPlay();
    }*/
}
