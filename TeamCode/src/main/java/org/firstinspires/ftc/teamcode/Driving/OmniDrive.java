package org.firstinspires.ftc.teamcode.Driving;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.Math;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class OmniDrive{
    final double PI = 3.14159265359;
    public void POV_Driving(float[][] Driving, DcMotor[] Wheels, Telemetry telemetry){

        double Lateral = Driving[0][0];
        double Axial = Driving[0][1];
        double Yaw = Driving[1][0];


        //Calculate what the power values should be for POV driving
        double leftFront = Axial-Lateral-Yaw;
        double rightFront = Axial+Lateral+Yaw;
        double leftBack = Axial+Lateral-Yaw;
        double rightBack = Axial-Lateral+Yaw;

        leftFront = Math.cos(Math.toRadians(leftFront) + PI/4);
        

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

    public void Character_Driving(float[][] Driving, double robotDirection, DcMotor[] Wheels, Telemetry telemetry){
        double Lateral = Driving[0][0];
        double Axial = Driving[0][1];
        double Yaw = Driving[1][0];

        double leftFront = Axial-Lateral-Yaw;
        double rightFront = Axial+Lateral+Yaw;
        double leftBack = Axial+Lateral-Yaw;
        double rightBack = Axial-Lateral+Yaw;

        leftFront =

        //Please see POV drive for an explanation of this formula
        leftFront = (((leftFront + 1)*(2))/(2))-1;
        rightFront = (((rightFront + 1)*(2))/(2))-1;
        leftBack = (((leftBack + 1)*(2))/(2))-1;
        rightBack = (((rightBack + 1)*(2))/(2))-1;


        //Set the motors to their respective power values
        Wheels[0].setPower(rightFront);
        Wheels[1].setPower(rightBack);
        Wheels[2].setPower(leftBack);
        Wheels[3].setPower(leftFront);
    }
}
