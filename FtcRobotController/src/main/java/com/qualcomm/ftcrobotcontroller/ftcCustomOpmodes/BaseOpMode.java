package com.qualcomm.ftcrobotcontroller.ftcCustomOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Brendon Telman on 9/17/2015.
 *
 * FTC Base OpMode Template for Team ####
 */
public abstract class BaseOpMode extends OpMode {
    DcMotor leftBackDrive, leftFrontDrive;
    DcMotor rightBackDrive, rightFrontDrive;
    Servo derpyServo;

    double derpPosition = 0.0;
    float leftDriveSpeed = 0.0f;
    float rightDriveSpeed = 0.0f;
    double driveSpeedScale = 0.0;

    /**
     * Constructor
     */
    public BaseOpMode() {

    }

    public void setupController(){
        //Init left drive motors
        leftBackDrive = hardwareMap.dcMotor.get("motorLeft");
        leftFrontDrive = hardwareMap.dcMotor.get("motor_2");
        //Reverse left drive motors
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);

        //Init right drive motors
        rightBackDrive = hardwareMap.dcMotor.get("motorRight");
        rightFrontDrive = hardwareMap.dcMotor.get("motor_4");

        derpyServo = hardwareMap.servo.get("servo_1");
    }

    protected void drive(float leftSpeed, float rightSpeed){
        leftDriveSpeed = leftSpeed;
        rightDriveSpeed = rightSpeed;
    }

    protected void update(){
        leftFrontDrive.setPower(leftDriveSpeed);
        leftBackDrive.setPower(leftDriveSpeed);
        rightFrontDrive.setPower(rightDriveSpeed);
        rightBackDrive.setPower(rightDriveSpeed);
        derpyServo.setPosition(derpPosition);
    }

    float joyLeft;
    float joyRight;
    protected void getJoystick(){
        joyLeft = -gamepad1.left_stick_y;
        joyRight = -gamepad1.right_stick_y;
    }
    /*
    Abstracted methods extend BaseOpMode to implement

    @Override
    public void init() {
        //initialize motor configuration
    }

    @Override
    public void loop() {
        //main loop, DO NOT CALL Thread.sleep() or delay!!!
    }*/

}
