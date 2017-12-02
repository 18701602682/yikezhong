package z.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import z.com.R;
import z.com.bean.GetjokeBean;

/**
 * Created by lenovo on 2017/11/30.
 * 给段子配图的适配器
 */

public class Frag2_tp_Adapter extends RecyclerView.Adapter<Frag2_tp_Adapter.ViewHolder> {

    private Context context;
    private LayoutInflater mLayoutInflater;
    private String[] result;

    public Frag2_tp_Adapter(Context context, String[] result) {
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.result = result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.dz_tp_item, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(result.length==1)
        {
            holder.iv_dz_tp3.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(result[position])
                    .centerCrop()
                    .into(holder.iv_dz_tp3);
        }
        else if(result.length==2)
        {
            holder.iv_dz_tp2.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(result[position])
                    .centerCrop()
                    .into(holder.iv_dz_tp2);
        }
        else{
            holder.iv_dz_tp1.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(result[position])
                    .centerCrop()
                    .into(holder.iv_dz_tp1);
        }

    }

    @Override
    public int getItemCount() {
        return result.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iv_dz_tp1,iv_dz_tp2,iv_dz_tp3;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_dz_tp1 = (ImageView) itemView.findViewById(R.id.iv_dz_tp1);
            iv_dz_tp2 = (ImageView) itemView.findViewById(R.id.iv_dz_tp2);
            iv_dz_tp3 = (ImageView) itemView.findViewById(R.id.iv_dz_tp3);
        }
    }
}
