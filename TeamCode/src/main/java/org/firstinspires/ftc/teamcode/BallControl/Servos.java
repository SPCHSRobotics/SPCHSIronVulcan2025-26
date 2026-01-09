package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Servos {
    public void TurnServo(boolean FireBall, Servo Elevator, Telemetry telemetry){
        if (FireBall){
            Elevator.setPosition(0.5);
            telemetry.addLine("Firing!");
        } else {
            Elevator.setPosition(1);
        }
    }
}
