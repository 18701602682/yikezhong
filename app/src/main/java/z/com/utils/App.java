package z.com.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by lenovo on 2017/11/24.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        CrashReport.initCrashReport(getApplicationContext(), "94a416fcd8", false);

        Fresco.initialize(this);
    }
}
