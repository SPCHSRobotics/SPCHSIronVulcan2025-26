package org.firstinspires.ftc.teamcode.Driving;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class OmniDrive{
    public void POV_Driving(float[][] Driving, DcMotor[] Wheels, Telemetry telemetry){

        double Lateral = Driving[0][0];
        double Axial = Driving[0][1];
        double Yaw = Driving[1][0];


        //Calculate what the power values should be for POV driving
        double leftFront = Axial-Lateral-Yaw;
        double rightFront = Axial+Lateral+Yaw;
        double leftBack = Axial+Lateral-Yaw;
        double rightBack = Axial-Lateral+Yaw;

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
        Wheels[0].setPower(rightFront);
        Wheels[1].setPower(rightBack);
        Wheels[2].setPower(leftBack);
        Wheels[3].setPower(leftFront);

        /* Per-wheel telemetry:
        telemetry.addData("rightFront: ", rightFront);
        telemetry.addData("rightBack: ", rightBack);
        telemetry.addData("leftBack: ", leftBack);
        telemetry.addData("leftFront: ", leftFront);
         */
    }
}
