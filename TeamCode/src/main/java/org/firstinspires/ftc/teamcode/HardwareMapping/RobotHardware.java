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
    public DcMotor Shooter;
    public DcMotor Intake;
    public Servo Elevator;
    public Servo CameraPedestal;
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
        }

        Wheels[0].setDirection(DcMotorSimple.Direction.REVERSE);
        Wheels[1].setDirection(DcMotorSimple.Direction.FORWARD);
        Wheels[2].setDirection(DcMotorSimple.Direction.REVERSE);
        Wheels[3].setDirection(DcMotorSimple.Direction.FORWARD);

        Shooter = hardwareMap.get(DcMotor.class, "shooter");
        Intake = hardwareMap.get(DcMotor.class, "input");
        Elevator = hardwareMap.get(Servo.class, "elevator");
        CameraPedestal = hardwareMap.get(Servo.class, "camera servo");

        Shooter.setDirection(DcMotorSimple.Direction.FORWARD);
        Shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.DOWN;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);
        imu.initialize(new com.qualcomm.robotcore.hardware.IMU.Parameters(orientationOnRobot));

    }
}