package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;;import java.math.RoundingMode;

public class Shooters {
    public void ToggleShooters(float shooterPower, boolean PrimingShooters, DcMotor[] Shooters, Telemetry telemetry){
        /*
        The Shooters array should label the following hardware components:
        Shooters[0] = left-side shooter
        Shooters[1] = right-side shooter
         */

        Shooters[0].setPower(shooterPower);
        Shooters[1].setPower(shooterPower);

        /*
        double turnacatedShooterOutput = Shooters[0].getPower();
        int turnicatedSO = (int) (turnacatedShooterOutput*100);
        turnacatedShooterOutput = turnicatedSO/100.0f;
        telemetry.addData("turnacatedShooterOutput: ", turnacatedShooterOutput);
        telemetry.addData("shooterPowerModifier: ", shooterPowerModifier);


        boolean powerChanged = (turnacatedShooterOutput != (shooterPowerModifier));
        telemetry.addData("powerChanged: ", powerChanged);

        boolean shooterOn = (Shooters[0].getPower() != 0);

        if (PrimingShooters || ( shooterOn && powerChanged)){
            Shooters[0].setPower(shooterPowerModifier);
            Shooters[1].setPower(shooterPowerModifier);
        } else {
            Shooters[0].setPower(0);
            Shooters[1].setPower(0);
        }

         */
        telemetry.addLine("Shooter power: " + Shooters[0].getPower() * 100 + "%");
    }
}
