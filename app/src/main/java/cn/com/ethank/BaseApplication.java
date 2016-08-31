package cn.com.ethank;

import android.app.Application;

/**
 * Created by lhuan on 2016/2/22.
 */
public class BaseApplication extends Application {
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }


    public static BaseApplication getInstance() {

        return instance;
    }

}
