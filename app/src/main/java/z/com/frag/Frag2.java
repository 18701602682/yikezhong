package z.com.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import z.com.R;

/**
 * Created by lenovo on 2017/11/14.
 */

public class Frag2 extends Fragment{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view = View.inflate(getContext(), R.layout.frag2,null);
        }
        return view;
    }
}
