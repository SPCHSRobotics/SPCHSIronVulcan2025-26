package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooters {
    public void PowerShooters(float shooterPower, DcMotor Shooter, Telemetry telemetry){
        /*
        The Shooters array should label the following hardware components:
        Shooters[0] = left-side shooter
        Shooters[1] = right-side shooter
         */

        Shooter.setPower(shooterPower);

        telemetry.addLine("Shooter power: " + Shooter.getPower() * 100 + "%");
    }
}
