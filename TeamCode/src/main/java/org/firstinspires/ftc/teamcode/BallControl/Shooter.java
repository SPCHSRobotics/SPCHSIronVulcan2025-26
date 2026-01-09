package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    public void PowerShooters(float shooterPower, DcMotor Shooter, Telemetry telemetry){
        Shooter.setPower(shooterPower);
        telemetry.addLine("Shooter power: " + Shooter.getPower() * 100 + "%");
    }
}
