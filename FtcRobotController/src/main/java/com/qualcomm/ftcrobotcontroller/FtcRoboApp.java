package com.qualcomm.ftcrobotcontroller;

import android.content.Context;

/**
 * Created by Brendon on 9/17/2015.
 *
 * Base Application that will give the context to other classes that normally would not have access
 */
public class FtcRoboApp extends android.app.Application {
    public static Context context;
    private static FtcRoboApp instance;
    public FtcRoboApp(){
        instance = this;
        //context = getApplicationContext();
    }

    public static FtcRoboApp getInstance() {
        if(instance == null){
            instance = new FtcRoboApp();
        }
        return instance;
    }
}
