package com.qualcomm.ftcrobotcontroller.ftcCustomOpmodes;

import android.content.Context;

import com.qualcomm.ftcrobotcontroller.FtcRoboApp;

/**
 * Created by Brendon on 9/17/2015.
 *
 * Simple TeleOp
 */
public class LoopAutoOpMode extends BaseOpMode {
    Context context;
    /**
     * Constructor
     */
    public LoopAutoOpMode() {
        context = FtcRoboApp.getInstance().getApplicationContext();
    }

    Runnable runnable;
    boolean start;
    @Override
    public void init() {
        setupController();
        runnable = new Runnable() {
            @Override
            public void run() {
                while(!start);
                drive(1,1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                drive(0,0);

            }
        };
        //context.startActivity(new Intent(context, TestFullScreen.class));
    }

    @Override
    public void start() {
        super.start();
        start = true;
    }

    @Override
    public void loop() {
        //getJoystick();

        update();
    }


    /*
	 * Code to run when the op mode is first disabled goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
	 */
    @Override
    public void stop() {
        super.stop();
        start = false;
    }
}
