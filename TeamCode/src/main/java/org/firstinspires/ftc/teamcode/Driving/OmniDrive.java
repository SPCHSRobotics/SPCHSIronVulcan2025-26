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
        double Axial = -Driving[0][1];
        double Yaw = Driving[1][0];

        telemetry.addData("Lateral: ", Lateral);
        telemetry.addData("Axial: ", Axial);
        double stickAngle = (Math.sin(Axial))/(Math.cos(Lateral));
        telemetry.addData("stickAngle/PI: ", stickAngle/PI);

        double adjustedStickAngle = stickAngle + (5*PI)/4;
        telemetry.addData("adjustedStickAngle/PI: ", adjustedStickAngle/PI);

        /*  If you graph what powers the robot should set its right front motor to (based off degree,
         *  going from 0 degrees to 360 degrees) when going right, you'll notice that the graph is
         *  basically just cos(x + pi/4)
         */

        double leftFront = Math.cos(robotDirection + adjustedStickAngle);
        //Assume that the other 'equal wheels' are the opposite
        double rightFront = Math.cos(-(robotDirection + adjustedStickAngle));
        //Assume that the left front is equal to the right back and the
        //right front is equal to the left back
        double leftBack = rightFront;
        double rightBack = leftFront;


        //Set the motors to their respective power values
        Wheels[0].setPower(rightFront);
        Wheels[1].setPower(rightBack);
        Wheels[2].setPower(leftBack);
        Wheels[3].setPower(leftFront);
    }
}
