package z.com.base;

/**
 * Created by lenovo on 2017/11/23.
 */

public class BasePresenter<V> {

    private V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public void deatach()
    {
        this.mView=null;
    }
}
