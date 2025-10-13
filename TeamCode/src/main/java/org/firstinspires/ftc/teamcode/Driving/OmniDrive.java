package org.firstinspires.ftc.teamcode.Driving;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotHardware;

public class OmniDrive{
    public OmniDrive(RobotHardware RobotHardwareObject){
        // Right now, this header does nothing.
    }
    public void POV_Driving(Gamepad gamepad1, DcMotor[] Wheels, Telemetry telemetry){
        //Get our inputs
        double Axial = gamepad1.left_stick_y;
        double Lateral = gamepad1.left_stick_x;
        double Yaw = -gamepad1.right_stick_x;

        //Calculate what the power values should be for POV driving
        double leftFront = Axial+Lateral+Yaw;
        double rightFront = Axial-Lateral-Yaw;
        double leftBack = Axial-Lateral+Yaw;
        double rightBack = Axial+Lateral-Yaw;

        //Adjust the values so that they are all between -1 and 1
        /*
        The function to normalize values between -1 and 1 is:

        [Min Value] +
        (
            (
                ([Original Value] - [Min Value]) * ([Max Value] - [Min Value])
            )
            /
            (
                ([Max Value]-[Min Value])
            )
        )
         */

        leftFront = (((leftFront + 1)*(2))/(2))-1;
        rightFront = (((rightFront + 1)*(2))/(2))-1;
        leftBack = (((leftBack + 1)*(2))/(2))-1;
        rightBack = (((rightBack + 1)*(2))/(2))-1;


        //Set the motors to their respective power values
        telemetry.addData("rightFront: ", rightFront);
        telemetry.addData("rightBack: ", rightBack);
        telemetry.addData("leftBack: ", leftBack);
        telemetry.addData("leftFront: ", leftFront);

        Wheels[0].setPower(rightFront);
        Wheels[1].setPower(rightBack);
        Wheels[2].setPower(leftBack);
        Wheels[3].setPower(leftFront);
    }
}
