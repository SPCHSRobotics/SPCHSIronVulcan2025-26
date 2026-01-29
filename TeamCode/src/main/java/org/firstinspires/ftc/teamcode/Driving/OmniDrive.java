package org.firstinspires.ftc.teamcode.Driving;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.Math;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class OmniDrive{
    private double[] normalize_4_values(double[] value){
        double[] normalizedValuesArray = new double[4];

        //normalize values here

        return normalizedValuesArray;
    };
    public void POV_Driving(double[][] Driving, DcMotor[] Wheels, Telemetry telemetry){
        /*
        double Driving:
        0 0 | leftStick x
        0 1 | leftStick y
        1 0 | rightStick x

        1) Place the robot on a table, with it's outtake closer to the ceiling than the intake.
        2) Crouch, and look at the robot from the same side that you put the ball into it
        3) Now imagine a regular coordinate plane behind the robot
        */
        double x_axis = Driving[0][0];
        double y_axis = Driving[0][1];
        double rotation = -(Driving[1][0]); //To rotate counterclockwise, be positive. Just like trig.


        //Calculate what the power values should be for POV driving
        double leftFront =  y_axis + x_axis + rotation;
        double rightFront = y_axis - x_axis - rotation;
        double leftBack =   y_axis - x_axis + rotation;
        double rightBack =  y_axis + x_axis - rotation;



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
        telemetry.addData("robotDirection/PI: ", robotDirection/Math.PI);

        /*
        0 0 | Lateral   | Pitch
        0 1 | Axial     | Roll
        1 0 | Yaw       | Yaw

        0 0 | leftStick x   | (left to right)  -1 ->  1
        0 1 | leftStick y   | (down to up)      1 -> -1
        1 0 | rightStick x  | (left to right)  -1 ->  1
        */

        double Lateral = Driving[0][0];
        double Axial = Driving[0][1];
        double Yaw = Driving[1][0];
        telemetry.addData("Lateral: ", Lateral);
        telemetry.addData("Axial: ", Axial);

        double stickAngle = Math.atan2(Axial, Lateral);
        if (stickAngle < 0){ //Atan2/PI returns -0.5 for 3PI/2, and it should return 1.5
            stickAngle += 2*Math.PI;
        }
        telemetry.addData("stickAngle/PI: ", stickAngle/Math.PI);

        double radius = Math.sqrt((Axial*Axial)+(Lateral*Lateral));
        radius = (radius > 1) ? 1 : radius; //Clip radius at 1. Rounding errors.

        double adjustedStickAngle = stickAngle + (5*Math.PI)/4;
        if (adjustedStickAngle > 2*Math.PI){ //Get the smallest equivalent angle
            adjustedStickAngle -= 2*Math.PI;
        }
        telemetry.addData("adjustedStickAngle/PI: ", adjustedStickAngle/Math.PI);


        //Piece-wise functions
        double leftFront = 0;
        if (robotDirection == 0 || robotDirection == 2*Math.PI){
            leftFront = 0;
        } else if (robotDirection > 0 && robotDirection < (3*Math.PI)/4){
            leftFront = ((3*Math.PI)/4)*robotDirection + 1;
        } else if (robotDirection > (3*Math.PI)/4 && robotDirection < Math.PI) {
            leftFront = (-4/Math.PI)*robotDirection + 3;
        } else if (robotDirection > Math.PI && robotDirection < (7*Math.PI)/4){
            leftFront = (4/(3*Math.PI))*robotDirection - (7/4);
        } else if (robotDirection > (7*Math.PI)/4 && robotDirection < 2*Math.PI){
            leftFront = (4/Math.PI)*robotDirection - 7;
        } else {
            telemetry.addLine("ERROR. ROBOT DIRECTION OUT OF BOUNDS");
        }

        //Assume that the other 'equal wheels' are the opposite
        double rightFront = 0;
        if (robotDirection == 0 || robotDirection == 2*Math.PI){
            leftFront = 0;
        } else if (robotDirection > 0 && robotDirection < (3*Math.PI)/4){
            rightFront = (-4/Math.PI)*robotDirection + 3;
        } else if (robotDirection > (3*Math.PI)/4 && robotDirection < Math.PI) {
            rightFront = ((3*Math.PI)/4)*robotDirection + 1;
        } else if (robotDirection > Math.PI && robotDirection < (7*Math.PI)/4){
            rightFront = (4/Math.PI)*robotDirection - 7;
        } else if (robotDirection > (7*Math.PI)/4 && robotDirection < 2*Math.PI){
            rightFront = (4/(3*Math.PI))*robotDirection - (7/4);
        } else {
            telemetry.addLine("ERROR. ROBOT DIRECTION OUT OF BOUNDS");
        }

        //These wheels are equal when the robot is not turning. 100% confidence.
        double leftBack = rightFront;
        double rightBack = leftFront;

        rightFront *= radius;
        rightBack *= radius;
        leftBack *= radius;
        leftFront *= radius;

        //Adding rotation to the robot:
        rightFront = (rightFront - Yaw);    //Right wheels are negative when turning right
        rightBack = (rightBack - Yaw);      //
        leftBack = (leftBack + Yaw);        //Left wheels are positive when turning right
        leftFront = (leftFront + Yaw);      //

        //Set the motors to their respective power values
        Wheels[0].setPower(rightFront);
        Wheels[1].setPower(rightBack);
        Wheels[2].setPower(leftBack);
        Wheels[3].setPower(leftFront);
    }
}
