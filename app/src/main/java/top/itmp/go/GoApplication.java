package top.itmp.go;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by hz on 2016/5/26.
 */
public class GoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
