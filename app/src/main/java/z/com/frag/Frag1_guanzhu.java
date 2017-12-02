package z.com.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import z.com.R;

/**
 * Created by lenovo on 2017/11/25.
 */

public class Frag1_guanzhu extends Fragment{

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view = View.inflate(getActivity(), R.layout.frag1_guanzhu,null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }


    private void initView()
    {
        ImageView iv_frag1_guanzhu=view.findViewById(R.id.iv_frag1_guanzhu);
        XRecyclerView xrl_frag1_guanzhu=view.findViewById(R.id.xrl_frag1_guanzhu);
    }
}
