package com.qualcomm.ftcrobotcontroller.ftcCustomOpmodes;

import android.content.Context;

/**
 * Created by Brendon on 9/17/2015.
 *
 * Simple TeleOp
 */
public class TeleOpMode extends BaseOpMode {
    Context context;
    /**
     * Constructor
     */
    public TeleOpMode() {
        //context = FtcRoboApp.getInstance().getApplicationContext();
    }

    @Override
    public void init() {
        setupController();
        //context.startActivity(new Intent(context, TestFullScreen.class));
    }

    @Override
    public void loop() {
        try {
            getJoystick();
            drive(0, 0);
            if (!gamepad1.atRest()) {
                //gamepad 1 logic
                drive(joyLeft, joyRight);
            }
            if (!gamepad2.atRest()) {
                //gamepad 2 logic
                if (gamepad2.a)
                    derpPosition = 1.0;
                if (gamepad2.b)
                    derpPosition = 0.0;
            }
            //update all motors and servos
            update();
        }catch (Exception e){

        }
    }

    /*
	 * Code to run when the op mode is first disabled goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
	 */
    @Override
    public void stop() {

    }
}
