package z.com.frag;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import z.com.R;

/**
 * Created by lenovo on 2017/11/25.
 */

public class Frag3_remen extends Fragment{

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view = View.inflate(getActivity(), R.layout.frag3_remen,null);
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

    }

}
