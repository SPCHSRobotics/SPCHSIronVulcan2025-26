package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotHardware {
    //Declare hardware here
    private  DcMotor leftFrontDrive;
    private DcMotor righFrontDrive;
    private DcMotor leftBackDrive;
    private DcMotor rightBackDrive;

    //Map the hardware to it's respective specified entry in the driver's hub
    public void Initialize(HardwareMap hardwareMap) {
        leftFrontDrive = hardwareMap.get(DcMotor.class, "leftFront");
        righFrontDrive = hardwareMap.get(DcMotor.class, "rightFront");
        leftBackDrive = hardwareMap.get(DcMotor.class, "leftBack");
        rightBackDrive = hardwareMap.get(DcMotor.class, "rightBack");

    }

}