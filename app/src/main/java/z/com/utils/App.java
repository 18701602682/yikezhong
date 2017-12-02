package z.com.utils;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by lenovo on 2017/11/24.
 */

public class App extends Application{



     public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context=this;

        CrashReport.initCrashReport(getApplicationContext(), "94a416fcd8", false);

        Fresco.initialize(this);


        if (LeakCanary.isInAnalyzerProcess(this))
        {
            return;
        }
        LeakCanary.install(this);
    }
}
