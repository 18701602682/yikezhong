package z.com.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import z.com.R;
import z.com.User_XiangqingActivity;
import z.com.bean.VideoBean;

/**
 * Created by lenovo on 2017/11/27.
 */

public class Frag1_Adapter extends XRecyclerView.Adapter<Frag1_Adapter.ViewHolder> implements View.OnClickListener {

    Context context;
    List<VideoBean.DataBean> list;
    private ViewHolder holder;
    private View view_pop;

    public Frag1_Adapter(Context context, List<VideoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    private int a=0;
    private ObjectAnimator animator;
    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;
    private int xh=0;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        view_pop = View.inflate(context, R.layout.popwindow,null);

        View view=View.inflate(context,R.layout.frag1_remen_item,null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        holder.setIsRecyclable(false);
        holder.tv_frag1_item_nicheng.setText(list.get(position).getUser().getNickname());
        holder.tv_frag1_item_date.setText(list.get(position).getCreateTime());
        holder.tv_frag1_title.setText(list.get(position).getUser().getNickname());
        holder.iv_frag1_item_touxaing.setImageURI(Uri.parse(list.get(position).getUser().getIcon()));


        final Map<Integer, Boolean> map = new HashMap();
        if(map.get(position)==null)
        {
            map.put(position,false);
        }
        holder.iv_frag1_item_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(map.get(position)==false)
                {
                    holder.ll_frag1_pingbi.setVisibility(View.VISIBLE);
                    holder.ll_frag1_copy.setVisibility(View.VISIBLE);
                    holder.ll_frag1_jubao.setVisibility(View.VISIBLE);

                    holder.iv_frag1_item_jia.setImageResource(R.drawable.icon_packup);
                    float translationX = holder.ll_frag1_jubao.getTranslationX();
                    ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(holder.ll_frag1_jubao,"translationX",translationX,-50f);

                    float translationX1 = holder.ll_frag1_copy.getTranslationX();
                    ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(holder.ll_frag1_copy,"translationX",translationX1,-100f);

                    float translationX2 = holder.ll_frag1_pingbi.getTranslationX();
                    ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(holder.ll_frag1_pingbi,"translationX",translationX2,-150f);

                    objectAnimator.setDuration(500);
                    objectAnimator1.setDuration(500);
                    objectAnimator2.setDuration(500);
                    objectAnimator.start();
                    objectAnimator1.start();
                    objectAnimator2.start();
                    map.put(position,true);
                }
                else if(map.get(position)==true)
                {
                    float translationX = holder.ll_frag1_pingbi.getTranslationX();
                    ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(holder.ll_frag1_pingbi,"translationX",translationX,0f);

                    float translationX1 = holder.ll_frag1_copy.getTranslationX();
                    ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(holder.ll_frag1_copy,"translationX",translationX1,0f);

                    float translationX2 = holder.ll_frag1_jubao.getTranslationX();
                    ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(holder.ll_frag1_jubao,"translationX",translationX2,0f);

                    objectAnimator.setDuration(500);
                    objectAnimator1.setDuration(500);
                    objectAnimator2.setDuration(500);
                    objectAnimator.start();
                    objectAnimator1.start();
                    objectAnimator2.start();
                    objectAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            holder.ll_frag1_pingbi.setVisibility(View.INVISIBLE);
                            holder.ll_frag1_copy.setVisibility(View.INVISIBLE);
                            holder.ll_frag1_jubao.setVisibility(View.INVISIBLE);
                            holder.iv_frag1_item_jia.setImageResource(R.drawable.icon_open);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    map.put(position,false);
                }
            }
        });

        holder.ll_frag1_xh.setOnClickListener(this);
        holder.rl_frag1_item.setOnClickListener(this);
        holder.ll_frag1_sc.setOnClickListener(this);
        holder.ll_frag1_fx.setOnClickListener(this);
        //holder.bt_frag1_quxiao.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder
    {
        private final ImageView iv_frag1_item_touxaing;
        private final TextView tv_frag1_item_nicheng;
        private final TextView tv_frag1_item_date;

        private final ImageView iv_frag1_item_jia;
        private final LinearLayout ll_frag1_pingbi;
        private final LinearLayout ll_frag1_copy;
        private final LinearLayout ll_frag1_jubao;

        private final LinearLayout ll_frag1_xh;
        private final ImageView iv_frag1_xh;
        private final ImageView iv_frag1_xh2;

        private final RelativeLayout rl_frag1_item;

        private final LinearLayout ll_frag1_sc;
        private final ImageView iv_frag1_sc;
        private final ImageView iv_frag1_sc2;

        private final LinearLayout ll_frag1_fx;
        private final TextView tv_frag1_title;

        /*private final LinearLayout ll_frag_fenxiang;
        private final Button bt_frag1_quxiao;*/


        public ViewHolder(View itemView) {
            super(itemView);

            rl_frag1_item = itemView.findViewById(R.id.rl_frag1_item);

            ll_frag1_pingbi = itemView.findViewById(R.id.ll_frag1_pingbi);
            ll_frag1_copy = itemView.findViewById(R.id.ll_frag1_copy);
            ll_frag1_jubao = itemView.findViewById(R.id.ll_frag1_jubao);
            iv_frag1_item_jia = itemView.findViewById(R.id.iv_frag1_item_jia);

            iv_frag1_item_touxaing = itemView.findViewById(R.id.iv_frag1_item_touxaing);
            tv_frag1_item_nicheng = itemView.findViewById(R.id.tv_frag1_item_nicheng);
            tv_frag1_item_date = itemView.findViewById(R.id.tv_frag1_item_date);

            tv_frag1_title = itemView.findViewById(R.id.tv_frag1_title);


            ll_frag1_xh = itemView.findViewById(R.id.ll_frag1_xh);
            iv_frag1_xh = itemView.findViewById(R.id.iv_frag1_xh);
            iv_frag1_xh2 = itemView.findViewById(R.id.iv_frag1_xh2);
            TextView tv_frag1_xh=itemView.findViewById(R.id.tv_frag1_xh);

            ll_frag1_sc = itemView.findViewById(R.id.ll_frag1_sc);
            iv_frag1_sc = itemView.findViewById(R.id.iv_frag1_sc);
            iv_frag1_sc2 = itemView.findViewById(R.id.iv_frag1_sc2);
            TextView tv_frag1_sc=itemView.findViewById(R.id.tv_frag1_sc);

            ll_frag1_fx = itemView.findViewById(R.id.ll_frag1_fx);
            ImageView iv_frag1_fx=itemView.findViewById(R.id.iv_frag1_fx);
            TextView tv_frag1_fx=itemView.findViewById(R.id.tv_frag1_fx);

            LinearLayout ll_frag1_pl=itemView.findViewById(R.id.ll_frag1_pl);
            ImageView iv_frag1_pl=itemView.findViewById(R.id.iv_frag1_pl);
            TextView tv_frag1_pl=itemView.findViewById(R.id.tv_frag1_pl);

            /*ll_frag_fenxiang = itemView.findViewById(R.id.ll_frag_fenxiang);
            bt_frag1_quxiao = itemView.findViewById(R.id.bt_frag1_quxiao);*/
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.rl_frag1_item:
                Intent intent=new Intent(context, User_XiangqingActivity.class);

                context.startActivity(intent);
                break;

            case R.id.ll_frag1_xh:
                xh++;
                if(xh%2==0)
                {
                    holder.iv_frag1_xh.setVisibility(View.VISIBLE);
                    holder.iv_frag1_xh2.setVisibility(View.GONE);
                }
                else
                {
                    holder.iv_frag1_xh.setVisibility(View.GONE);
                    holder.iv_frag1_xh2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_frag1_sc:
                xh++;
                if(xh%2==0)
                {
                    holder.iv_frag1_sc.setVisibility(View.VISIBLE);
                    holder.iv_frag1_sc2.setVisibility(View.GONE);
                }
                else
                {
                    holder.iv_frag1_sc.setVisibility(View.GONE);
                    holder.iv_frag1_sc2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_frag1_fx:
                //构建一个popupwindow的布局
                final PopupWindow pop=new PopupWindow(view_pop,500,200,true);
                pop.setFocusable(true);//获取焦点
                pop.update();//刷新
                //弹入弹出动画
                pop.setAnimationStyle(R.style.MyPopupWindow_anim_style);
                //弹框距离底部的距离
                pop.showAtLocation(v, Gravity.BOTTOM,0,0);
                LinearLayout ll_frag1_qq1=view_pop.findViewById(R.id.ll_frag1_qq1);
                LinearLayout ll_frag1_qq2=view_pop.findViewById(R.id.ll_frag1_qq2);
                LinearLayout ll_frag1_wx1=view_pop.findViewById(R.id.ll_frag1_wx1);
                LinearLayout ll_frag1_wx2=view_pop.findViewById(R.id.ll_frag1_wx2);
                Button bt_frag1_quxiao=view_pop.findViewById(R.id.bt_frag1_quxiao);
                ll_frag1_qq1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        System.out.println("===分享至QQ好友");
                    }
                });
                bt_frag1_quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        System.out.println("====取消弹框");
                        pop.dismiss();
                    }
                });
                break;
        }
    }



    private OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public interface OnClickListener
    {
        void onClick(View view);
    }
}
