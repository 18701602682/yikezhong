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

/**
 * Created by lenovo on 2017/11/30.
 * 给段子配图的适配器
 */

public class Dz_tp_Adapter extends RecyclerView.Adapter<Dz_tp_Adapter.ViewHolder> {

    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<String> result;
    private final static String TAG = "Adapter";

    public Dz_tp_Adapter(Context context, List<String> result) {
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.result = result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.dz_tp_item1, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load(result.get(position))
                .centerCrop()
                .into(holder.iv_dz_tp);

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_dz_tp;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_dz_tp = (ImageView) itemView.findViewById(R.id.iv_dz_tp);
        }

    }


}
