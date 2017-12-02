package z.com.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 沉浸式模式
 */
public class ImmersionUtil {
    /**
     * 透明状态栏
     * @param appCompatActivity
     */
    public static void fullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                //导航栏颜色也可以正常设置
                // window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
                //attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }






    /*public static void TransparentStatusbar(AppCompatActivity appCompatActivity) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = appCompatActivity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            appCompatActivity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
            appCompatActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        if (actionBar!=null)
        actionBar.hide();

    }

    *//**
     * 全屏模式(播放电影或者游戏模式)
     * 重写AppCompatActivity的onWindowFocusChanged方法
     * @param hasFocus
     * @param appCompatActivity
     *//*
    public static void FullScreenMode(Boolean hasFocus, AppCompatActivity appCompatActivity) {
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = appCompatActivity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }
    public static void FullScreenMod(Boolean hasFocus, AppCompatActivity appCompatActivity) {


    }*/
}
