package z.com;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.util.ArrayList;
import java.util.List;

import z.com.adapter.Dz_tp_Adapter;
import z.com.base.BaseActivity;
import z.com.base.BaseBean;
import z.com.base.BasePresenter;
import z.com.presenter.F_duanzi_presenter;
import z.com.utils.GlideLoader;
import z.com.view.F_duanzi_view;

public class DuanZiActivity extends BaseActivity<F_duanzi_presenter> implements View.OnClickListener, F_duanzi_view {

    private TextView tv_czdz_quxiao;
    private TextView tv_czdz_fabiao;
    private EditText et_czdz_neirong;
    private ImageView iv_czdz_tupian;

    public static final int REQUEST_CODE = 1000;
    private ArrayList<String> path = new ArrayList<>();
    private RecyclerView rlv_duanzi_tupian;
    private Dz_tp_Adapter dz_tp_adapter;

    @Override
    public F_duanzi_presenter initPresenter() {
        return new F_duanzi_presenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_duan_zi;
    }

    @Override
    public void creat()
    {
        initView();
    }

    @Override
    public boolean bool() {
        return false;
    }

    public void initView()
    {
        tv_czdz_quxiao = findViewById(R.id.tv_czdz_quxiao);
        tv_czdz_fabiao = findViewById(R.id.tv_czdz_fabiao);
        et_czdz_neirong = findViewById(R.id.et_czdz_neirong);
        iv_czdz_tupian = findViewById(R.id.iv_czdz_tupian);
        rlv_duanzi_tupian = findViewById(R.id.rlv_duanzi_tupian);

        tv_czdz_quxiao.setOnClickListener(this);
        tv_czdz_fabiao.setOnClickListener(this);
        iv_czdz_tupian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv_czdz_quxiao://取消发表段子
                initPop();
                break;
            case R.id.tv_czdz_fabiao://发表段子
                String content = et_czdz_neirong.getText().toString();
                SharedPreferences sp_uid=getSharedPreferences("sp_uid",MODE_PRIVATE);
                String uid = sp_uid.getString("uid", "");
                presenter.fabiao_duanzi(uid,content,path);
                System.out.println("===走了吗？");
                break;
            case R.id.iv_czdz_tupian://添加图片
                tupian();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
                rlv_duanzi_tupian.setLayoutManager(gridLayoutManager);
                dz_tp_adapter = new Dz_tp_Adapter(this, path);
                rlv_duanzi_tupian.setAdapter(dz_tp_adapter);
                break;
        }
    }


    @Override
    public void Success(BaseBean result) {
        ShowToast(result.msg);
        startActivity(PulishSussessActivity.class);
        finish();
    }

    @Override
    public void data_faile(BaseBean msg) {
        ShowToast(msg.msg);
    }

    @Override
    public void faile(BaseBean msg) {
        ShowToast(msg.msg);
    }


    /**
     * 点击取消，弹出popwindow
     */
    private void initPop()
    {
        //构建一个popupwindow的布局
        View view1=View.inflate(this,R.layout.pop_duanzi,null);
        //创建PopupWindow对象，指定宽度和高度
        final PopupWindow pop_duanzi = new PopupWindow(view1,400,200,true);
        //弹入弹出动画
        pop_duanzi.setAnimationStyle(R.style.MyPopupWindow_anim_style);
        //弹框距离底部的距离
        pop_duanzi.showAtLocation(view1, Gravity.BOTTOM,0,0);
        //弹框显示背景半透明
        backgroundAlpha(0.5f);
        //获取焦点
        pop_duanzi.setFocusable(true);
        pop_duanzi.update();//刷新
        TextView tv_pop_duanzi_1=view1.findViewById(R.id.tv_pop_duanzi_1);
        TextView tv_pop_duanzi_2=view1.findViewById(R.id.tv_pop_duanzi_2);
        TextView tv_pop_duanzi_3=view1.findViewById(R.id.tv_pop_duanzi_3);
        //保存
        tv_pop_duanzi_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(DuanZiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //不保存
        tv_pop_duanzi_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(MainActivity.class);
                finish();
            }
        });
        //取消
        tv_pop_duanzi_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //背景正常
                backgroundAlpha(1.0f);
                startActivity(MainActivity.class);
                pop_duanzi.dismiss();
                finish();
            }
        });
    }
    // popwindow背景半透明
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; // 0.0~1.0
        getWindow().setAttributes(lp);
    }


    /**
     * 添加图片{段子的配图}
     */
    public void tupian()
    {
        ImageConfig imageConfig
                = new ImageConfig.Builder(
                // GlideLoader 可用自己用的缓存库
                new GlideLoader())
                // 如果在 4.4 以上，则修改状态栏颜色 （默认黑色）
                .steepToolBarColor(getResources().getColor(R.color.blue))
                // 标题的背景颜色 （默认黑色）
                .titleBgColor(getResources().getColor(R.color.blue))
                // 提交按钮字体的颜色  （默认白色）
                .titleSubmitTextColor(getResources().getColor(R.color.white))
                // 标题颜色 （默认白色）
                .titleTextColor(getResources().getColor(R.color.white))
                // 开启多选   （默认为多选）  (单选 为 singleSelect)
                //.singleSelect()
                .crop()
                // 多选时的最大数量   （默认 9 张）
                .mutiSelectMaxSize(9)
                // 已选择的图片路径
                .pathList(path)
                // 拍照后存放的图片路径（默认 /temp/picture）
                .filePath("/ImageSelector/Pictures")
                // 开启拍照功能 （默认开启）
                .showCamera()
                //.requestCode(REQUEST_CODE)
                .build();

        ImageSelector.open(DuanZiActivity.this, imageConfig);   // 开启图片选择器
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImageSelector.IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            // Get Image Path List
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);

            for (String path : pathList) {
                Log.i("ImagePathList", path);
            }
            path.clear();
            path.addAll(pathList);
            dz_tp_adapter.notifyDataSetChanged();
        }
    }
}
