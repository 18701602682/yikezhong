package z.com.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import z.com.R;
import z.com.User_XiangqingActivity;
import z.com.bean.GetjokeBean;

/**
 * Created by lenovo on 2017/11/27.
 */

public class Frag2_Adapter extends XRecyclerView.Adapter<Frag2_Adapter.ViewHolder> implements View.OnClickListener {

    Context context; List<GetjokeBean.DataBean> list;
    private ViewHolder holder;
    private Bundle bundle;
    private Intent intent;


    public Frag2_Adapter(Context context, List<GetjokeBean.DataBean> list) {
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view=View.inflate(context,R.layout.frag2_item,null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        intent = new Intent(context, User_XiangqingActivity.class);
        intent.putExtra("followId",list.get(position).getUid()+"");
        intent.putExtra("icon",list.get(position).getUser().getIcon()+"");
        intent.putExtra("nickname",list.get(position).getUser().getNickname()+"");


        //Glide.with(context).load(list.get(position).getUser().getIcon()).into(holder.iv_frag2_item_touxaing);
        String icon = list.get(position).getUser().getIcon()+"";
        holder.iv_frag2_item_touxaing.setImageURI(Uri.parse(icon));
        System.out.println("===icon适配器=="+list.get(position).getUser().getIcon()+"");
        holder.tv_frag2_item_nicheng.setText(list.get(position).getUser().getNickname());
        holder.tv_frag2_item_date.setText(list.get(position).getCreateTime());
        holder.tv_frag2_item_content.setText(list.get(position).getContent());

        String imgUrls = list.get(position).getImgUrls()+"";
        String[] split = imgUrls.split("\\|");

        if(split.length==1)
        {
            holder.rlv_frag2_item.setLayoutManager(new GridLayoutManager(context,1));
            Frag2_tp_Adapter dz_tp_adapter=new Frag2_tp_Adapter(context,split);
            holder.rlv_frag2_item.setAdapter(dz_tp_adapter);
        }
        else if(split.length==2)
        {
            holder.rlv_frag2_item.setLayoutManager(new GridLayoutManager(context,2));
            Frag2_tp_Adapter dz_tp_adapter=new Frag2_tp_Adapter(context,split);
            holder.rlv_frag2_item.setAdapter(dz_tp_adapter);

        }
        else
        {
            holder.rlv_frag2_item.setLayoutManager(new GridLayoutManager(context,3));
            Frag2_tp_Adapter dz_tp_adapter=new Frag2_tp_Adapter(context,split);
            holder.rlv_frag2_item.setAdapter(dz_tp_adapter);

        }


        final Map<Integer, Boolean> map = new HashMap();
        if(map.get(position)==null)
        {
            map.put(position,false);
        }
        holder.iv_frag2_item_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(map.get(position)==false)
                {
                    holder.ll_frag2_pingbi.setVisibility(View.VISIBLE);
                    holder.ll_frag2_copy.setVisibility(View.VISIBLE);
                    holder.ll_frag2_jubao.setVisibility(View.VISIBLE);

                    holder.iv_frag2_item_jia.setImageResource(R.drawable.icon_packup);
                    float translationX = holder.ll_frag2_jubao.getTranslationX();
                    ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(holder.ll_frag2_jubao,"translationX",translationX,-50f);

                    float translationX1 = holder.ll_frag2_copy.getTranslationX();
                    ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(holder.ll_frag2_copy,"translationX",translationX1,-100f);

                    float translationX2 = holder.ll_frag2_pingbi.getTranslationX();
                    ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(holder.ll_frag2_pingbi,"translationX",translationX2,-150f);

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
                    float translationX = holder.ll_frag2_pingbi.getTranslationX();
                    ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(holder.ll_frag2_pingbi,"translationX",translationX,0f);

                    float translationX1 = holder.ll_frag2_copy.getTranslationX();
                    ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(holder.ll_frag2_copy,"translationX",translationX1,0f);

                    float translationX2 = holder.ll_frag2_jubao.getTranslationX();
                    ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(holder.ll_frag2_jubao,"translationX",translationX2,0f);

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
                            holder.ll_frag2_pingbi.setVisibility(View.INVISIBLE);
                            holder.ll_frag2_copy.setVisibility(View.INVISIBLE);
                            holder.ll_frag2_jubao.setVisibility(View.INVISIBLE);
                            holder.iv_frag2_item_jia.setImageResource(R.drawable.icon_open);
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

        holder.rl_frag2_item.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.rl_frag2_item:

                context.startActivity(intent);
                break;
        }
    }

    /**
     * 自定义ViewHolder
     */
    class ViewHolder extends XRecyclerView.ViewHolder
    {
        private final ImageView iv_frag2_item_touxaing;
        private final TextView tv_frag2_item_nicheng;
        private final TextView tv_frag2_item_date;

        private final ImageView iv_frag2_item_jia;
        private final LinearLayout ll_frag2_pingbi;
        private final LinearLayout ll_frag2_copy;
        private final LinearLayout ll_frag2_jubao;

        private final TextView tv_frag2_1;
        private final TextView tv_frag2_2;
        private final TextView tv_frag2_3;

        private final TextView tv_frag2_item_content;
        private final RecyclerView rlv_frag2_item;
        private final RelativeLayout rl_frag2_item;

        public ViewHolder(View itemView) {
            super(itemView);
            rl_frag2_item = itemView.findViewById(R.id.rl_frag2_item);

            ll_frag2_pingbi = itemView.findViewById(R.id.ll_frag2_pingbi);
            ll_frag2_copy = itemView.findViewById(R.id.ll_frag2_copy);
            ll_frag2_jubao = itemView.findViewById(R.id.ll_frag2_jubao);

            tv_frag2_1 = itemView.findViewById(R.id.tv_frag2_1);
            tv_frag2_2 = itemView.findViewById(R.id.tv_frag2_2);
            tv_frag2_3 = itemView.findViewById(R.id.tv_frag2_3);
            iv_frag2_item_jia = itemView.findViewById(R.id.iv_frag2_item_jia);

            iv_frag2_item_touxaing = itemView.findViewById(R.id.iv_frag2_item_touxaing);
            tv_frag2_item_nicheng = itemView.findViewById(R.id.tv_frag2_item_nicheng);
            tv_frag2_item_date = itemView.findViewById(R.id.tv_frag2_item_date);

            tv_frag2_item_content = itemView.findViewById(R.id.tv_frag2_item_content);
            rlv_frag2_item = itemView.findViewById(R.id.rlv_frag2_item);
        }
    }
}
