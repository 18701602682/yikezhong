package z.com.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import z.com.R;
import z.com.adapter.Frag2_Adapter;
import z.com.base.BaseBean;
import z.com.base.BaseFragment;
import z.com.bean.GetjokeBean;
import z.com.presenter.H_duanzi_presenter;
import z.com.view.H_duanzi_view;

/**
 * Created by lenovo on 2017/11/14.
 */

public class Frag2 extends BaseFragment<H_duanzi_presenter> implements H_duanzi_view {

    private int page=1;
    private XRecyclerView frag2_xrl;
    private List<GetjokeBean.DataBean> list;
    private Frag2_Adapter frag2_a;

    @Override
    public int getLayoutId() {
        return R.layout.frag2;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void Creat()
    {
        initView();
        initData();
    }

    private void initData()
    {
        present_frag=new H_duanzi_presenter(this);
        present_frag.huoqu_duanzi(1+"");
    }

    private void initView()
    {
        list = new ArrayList<>();

        frag2_xrl = view.findViewById(R.id.frag2_xrl);
        frag2_xrl.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        frag2_xrl.setPullRefreshEnabled(true);
        frag2_xrl.setLoadingMoreEnabled(true);
    }

    @Override
    public void Success(GetjokeBean result)
    {
        list.addAll(result.getData());

            if(frag2_a==null)
            {
                frag2_a = new Frag2_Adapter(getActivity(),list);
                frag2_xrl.setAdapter(frag2_a);
            }
            else
            {
                frag2_a.notifyDataSetChanged();
            }

        frag2_xrl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh()
            {
                present_frag.huoqu_duanzi(page+"");
                frag2_xrl.refreshComplete();
                ShowToast("刷新成功");
            }

            @Override
            public void onLoadMore()
            {
                page++;
                present_frag.huoqu_duanzi(page+"");
                frag2_xrl.loadMoreComplete();
                ShowToast("加载更多=="+page);
            }
        });
    }

    @Override
    public void data_faile(GetjokeBean msg) {
        System.out.println("===获取段子失败11=="+msg.msg);
    }

    @Override
    public void faile(GetjokeBean msg) {
        System.out.println("===获取段子失败22=="+msg.msg);
    }
}
