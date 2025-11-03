package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;;
public class Shooters {
    public void ToggleShooters(boolean PrimingShooters, DcMotor[] Shooters, Telemetry telemetry){
        /*
        The Shooters array should label the following hardware components:
        Shooters[0] = left-side shooter
        Shooters[1] = right-side shooter
         */

        //If the button was released on the tick, run this code
        if (PrimingShooters){
            boolean shooterStateOn = ((Shooters[0].getPower() + Shooters[1].getPower()) > 0 );
            //The above checks BOTH shooting motors for their power
            if (shooterStateOn){
                Shooters[0].setPower(0.0);
                Shooters[1].setPower(0.0);
            } else {
                Shooters[0].setPower(0.5);
                Shooters[1].setPower(0.5);
            }
        }
    }
}
