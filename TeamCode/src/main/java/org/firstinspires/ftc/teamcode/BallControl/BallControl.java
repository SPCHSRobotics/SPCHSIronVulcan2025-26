package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BallControl {
    final float magnitude = 1.0f; //"Final" means we can't change this value anywhere else
    public void PowerFlywheel(float shooterPower, DcMotor Shooter, Telemetry telemetry){
        Shooter.setPower(shooterPower);
        telemetry.addLine("Shooter power: " + Shooter.getPower() * 100 + "%");
    }

    public void Gate (Servo[] gate){
        gate[0].setPosition(magnitude);
        gate[1].setPosition(magnitude * -1);
    }
}
