package z.com.frag;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import z.com.LoginStyleActivity;
import z.com.MainActivity;
import z.com.Nickname_HeadActivity;
import z.com.R;
import z.com.ZuoPinActivity;
import z.com.base.BaseFragment;
import z.com.bean.UserBean;
import z.com.presenter.User_presenter;
import z.com.presenter.Xg_nickname_presenter;
import z.com.presenter.Zhuce_presenter;
import z.com.view.User_view;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lenovo on 2017/11/24.
 */

public class LeftFragment extends BaseFragment<User_presenter> implements View.OnClickListener, User_view {

    private ImageView iv_left_touxaing;
    private TextView tv_left_nicheng;
    private ImageView iv_left_ri;
    private ImageView iv_left_ye;
    private ImageView iv_left_yue1;
    private ImageView iv_left_yue2;
    private ImageView iv_left_zuopin;
    private ImageView iv_left_shezhi;
    private int r_y=0;//按钮图片
    private TextView tv_left_ri_ye;
    private Bundle bundle;
    private SharedPreferences sp_icon;
    private SharedPreferences sp_nickname;

    @Override
    public int getLayoutId() {
        return R.layout.left_menu_layout;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void Creat()
    {
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView()
    {
        //获取用户信息
        present_frag=new User_presenter(this);
        SharedPreferences sp_uid=getActivity().getSharedPreferences("sp_uid",MODE_PRIVATE);
        String uid = sp_uid.getString("uid", "");
        present_frag.getuser(uid);

        iv_left_touxaing = view.findViewById(R.id.iv_left_touxaing);//头像
        tv_left_nicheng = view.findViewById(R.id.tv_left_nicheng);//昵称
        tv_left_ri_ye = view.findViewById(R.id.tv_left_ri_ye);//日夜间字体切换
        iv_left_ri = view.findViewById(R.id.iv_left_ri);
        iv_left_ye = view.findViewById(R.id.iv_left_ye);
        iv_left_yue1 = view.findViewById(R.id.iv_left_yue1);
        iv_left_yue2 = view.findViewById(R.id.iv_left_yue2);
        iv_left_zuopin = view.findViewById(R.id.iv_left_zuopin);
        iv_left_shezhi = view.findViewById(R.id.iv_left_shezhi);
        RelativeLayout rl_left1=view.findViewById(R.id.rl_left1);
        RelativeLayout rl_left2=view.findViewById(R.id.rl_left2);
        RelativeLayout rl_left3=view.findViewById(R.id.rl_left3);
        RelativeLayout rl_left4=view.findViewById(R.id.rl_left4);

        iv_left_ri.setOnClickListener(this);
        iv_left_ye.setOnClickListener(this);
        iv_left_yue1.setOnClickListener(this);
        iv_left_zuopin.setOnClickListener(this);
        iv_left_shezhi.setOnClickListener(this);
        iv_left_touxaing.setOnClickListener(this);
        tv_left_nicheng.setOnClickListener(this);
        rl_left1.setOnClickListener(this);
        tv_left_ri_ye.setText("夜间模式");


    }

    @Override
    public void onResume() {
        super.onResume();

        sp_nickname = getActivity().getSharedPreferences("sp_nickname",MODE_PRIVATE);
        tv_left_nicheng.setText(sp_nickname.getString("nickname",""));
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv_left_nicheng:
                startActivity(Nickname_HeadActivity.class);
                break;
            case R.id.iv_left_ri:
                if(r_y%2==0)
                {
                    tv_left_ri_ye.setText("日间模式");
                    iv_left_ri.setVisibility(View.GONE);
                    iv_left_ye.setVisibility(View.VISIBLE);

                    iv_left_yue1.setVisibility(View.GONE);
                    iv_left_yue2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.iv_left_ye:
                if(r_y%2==0)
                {
                    tv_left_ri_ye.setText("夜间模式");
                    iv_left_ri.setVisibility(View.VISIBLE);
                    iv_left_ye.setVisibility(View.GONE);

                    iv_left_yue1.setVisibility(View.VISIBLE);
                    iv_left_yue2.setVisibility(View.GONE);
                }
                break;
            case R.id.iv_left_zuopin:
                startActivity(ZuoPinActivity.class);
                break;
            case R.id.iv_left_shezhi:
                //startActivity(MainActivity.class, bundle);
                break;
            case R.id.rl_left1:
                System.out.println("===关注");
                break;
            case R.id.iv_left_touxaing:
                startActivity(LoginStyleActivity.class);
                break;
        }
    }

    @Override
    public void Success(UserBean result)
    {
        String nickname = result.getData().getNickname();
        String icon = result.getData().getIcon();

        tv_left_nicheng.setText(nickname);
        iv_left_touxaing.setImageURI(Uri.parse(icon));
        //把头像保存到sp里
        //sp_icon = getActivity().getSharedPreferences("sp_icon",MODE_PRIVATE);
        //sp_icon.edit().putString("icon",icon).commit();
    }

    @Override
    public void data_faile(UserBean msg) {
        System.out.println("===获取用户信息失败啊=="+msg.msg);
    }

    @Override
    public void faile(UserBean msg) {
        System.out.println("===获取用户信息失败=="+msg.msg);
    }
}
