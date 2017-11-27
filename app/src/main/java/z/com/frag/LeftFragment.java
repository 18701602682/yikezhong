package z.com.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import z.com.R;
import z.com.ZuoPinActivity;

/**
 * Created by lenovo on 2017/11/24.
 */

public class LeftFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView iv_left_touxaing;
    private TextView tv_left_nicheng;
    private ImageView iv_left_ri;
    private ImageView iv_left_ye;
    private ImageView iv_left_yue1;
    private ImageView iv_left_yue2;
    private ImageView iv_left_zuopin;
    private ImageView iv_left_shezhi;
    private int r_y=0;//按钮图片
    private int yue=0;//月亮

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view = View.inflate(getContext(), R.layout.left_menu_layout,null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    /**
     * 初始化控件
     */
    private void initView()
    {
        iv_left_touxaing = view.findViewById(R.id.iv_left_touxaing);//头像
        tv_left_nicheng = view.findViewById(R.id.tv_left_nicheng);//昵称
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
        rl_left1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.iv_left_ri:
                if(r_y%2==0)
                {
                    iv_left_ri.setVisibility(View.GONE);
                    iv_left_ye.setVisibility(View.VISIBLE);

                    iv_left_yue1.setVisibility(View.GONE);
                    iv_left_yue2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.iv_left_ye:
                if(r_y%2==0)
                {
                    iv_left_ri.setVisibility(View.VISIBLE);
                    iv_left_ye.setVisibility(View.GONE);

                    iv_left_yue1.setVisibility(View.VISIBLE);
                    iv_left_yue2.setVisibility(View.GONE);
                }
                break;
            case R.id.iv_left_zuopin:
                Intent intent=new Intent(getContext(), ZuoPinActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_left_shezhi:
                break;
            case R.id.rl_left1:
                System.out.println("===关注");
                break;
        }
    }
}
