package z.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import z.com.utils.TUtil;

/**
 * Created by lenovo on 2017/11/29.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment{

    public P present_frag;
    public View view;
    public Toast toast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(getLayoutId(),container,false);

        present_frag= TUtil.getT(this,0);
        initPresenter();
        Creat();
        return view;
    }

    public abstract int getLayoutId();
    public abstract void initPresenter();
    public abstract void Creat();
    //吐司
    public void ShowToast(String msg)
    {
        if(toast==null)
        {
            toast = Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 无参跳转
     * @param clz
     */
    public void startActivity(Class<?> clz){
        Intent intent = new Intent(getActivity(),clz);
        startActivity(intent);
    }
    /**
     * 有参跳转
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz,Bundle bundle){
        Intent intent = new Intent(getActivity(),clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
