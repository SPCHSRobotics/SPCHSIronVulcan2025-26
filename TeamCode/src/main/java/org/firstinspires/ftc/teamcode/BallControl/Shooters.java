package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;;
public class Shooters {
    public void ToggleShootersAndIntake(Gamepad gamepad1, DcMotor[] Shooters, Telemetry telemetry){
        /*
        The Shooters array should label the following hardware components:
        Shooters[0] = left-side shooter
        Shooters[1] = right-side shooter
        Shooters[2] = intake motor
         */


        //Create a variable every tick that reflects whether or not "a" was released
        boolean buttonInputA = gamepad1.aWasReleased();

        //If the button was released on the tick, run this code
        if (buttonInputA){
            boolean shooterStateOn = ((Shooters[0].getPower() + Shooters[1].getPower()) > 0 );
            //The above checks BOTH shooting motors for their power
            if (shooterStateOn){
                Shooters[0].setPower(0.0);
                Shooters[1].setPower(0.0);
            } else {
                Shooters[0].setPower(0.6);
                Shooters[1].setPower(0.6/5.;;'');
            }
        }

        //Create a variable every tick that reflects whether or not "b" was released
        boolean buttonInputB = gamepad1.bWasReleased();

        //If the button was released on the tick, run this code
        if (buttonInputB){
            boolean intakeStateOn = (Shooters[2].getPower() > 0);

            if (intakeStateOn){
                Shooters[2].setPower(0);
            } else {
                Shooters[2].setPower(1);
            }
        }

        boolean buttonInputX = gamepad1.xWasReleased();
        boolean intakeStateOnReverse = (Shooters[2].getPower() < 0);

        if (buttonInputX){
            if (intakeStateOnReverse){
                Shooters[2].setPower(0);
            } else {
                Shooters[2].setPower(-1);
            }
        }

    }
}
