package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooters {
    public void PowerShooters(float shooterPower, DcMotor[] Shooters, Telemetry telemetry){
        /*
        The Shooters array should label the following hardware components:
        Shooters[0] = left-side shooter
        Shooters[1] = right-side shooter
         */

        Shooters[0].setPower(shooterPower);
        Shooters[1].setPower(shooterPower);

        telemetry.addLine("Shooter power: " + Shooters[0].getPower() * 100 + "%");
    }
}
