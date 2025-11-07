package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;;
public class Shooters {
    final float defaultShooterValue = 0.0f;
    public void ToggleShooters(float shooterPowerModifier, boolean PrimingShooters, DcMotor[] Shooters, Telemetry telemetry){
        /*
        The Shooters array should label the following hardware components:
        Shooters[0] = left-side shooter
        Shooters[1] = right-side shooter
         */

        boolean powerChanged = (Shooters[0].getPower() != shooterPowerModifier * defaultShooterValue);

        if (PrimingShooters || ((Shooters[0].getPower() != 0) && powerChanged)){
            Shooters[0].setPower(defaultShooterValue + shooterPowerModifier);
            Shooters[1].setPower(defaultShooterValue + shooterPowerModifier);
        } else {
            Shooters[0].setPower(0);
            Shooters[1].setPower(0);
        }

        telemetry.addLine("Shooter power: " + Shooters[0].getPower() * 100 + "%");
    }
}
