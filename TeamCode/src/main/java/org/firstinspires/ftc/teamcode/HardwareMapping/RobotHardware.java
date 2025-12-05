package org.firstinspires.ftc.teamcode.HardwareMapping;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.IMU;

public class RobotHardware {
    //Each object of the class RobotHardware shall have the following variables:
    public DcMotor[] Wheels = new DcMotor[4];
    public DcMotor[] Shooters = new DcMotor[4];
    public DcMotor Intake;
    public Servo Pusher;
    public IMU imu;


    public RobotHardware(HardwareMap hardwareMap){
        /*
        Each object of the class RobotHardware shall take a HardwareMap object at declaration,
        and use it to assign these four variables to DcMotor objects.
        */
        Wheels[0] = hardwareMap.get(DcMotor.class, "rightFront");
        Wheels[1] = hardwareMap.get(DcMotor.class, "rightBack");
        Wheels[2] = hardwareMap.get(DcMotor.class, "leftBack");
        Wheels[3] = hardwareMap.get(DcMotor.class, "leftFront");

        //This loop is here for convenience
        for (int i = 0; i <= 3; i = i + 1){
            Wheels[i].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            Wheels[i].setDirection(DcMotorSimple.Direction.REVERSE);
        }

        //The intake is in the "Shooters" array for convenience;
        //they are all used in the "Shooters.java" file so they're packaged together.
        Shooters[0] = hardwareMap.get(DcMotor.class, "leftShooter");
        Shooters[1] = hardwareMap.get(DcMotor.class, "rightShooter");
        Intake = hardwareMap.get(DcMotor.class, "intake");

        Shooters[0].setDirection(DcMotorSimple.Direction.REVERSE);
        Shooters[1].setDirection(DcMotorSimple.Direction.REVERSE);
        Intake.setDirection(DcMotorSimple.Direction.REVERSE);

        Shooters[0].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Shooters[1].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Pusher  = hardwareMap.get(Servo.class, "pusher");

        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.DOWN;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);
        imu.initialize(new com.qualcomm.robotcore.hardware.IMU.Parameters(orientationOnRobot));

    }
}