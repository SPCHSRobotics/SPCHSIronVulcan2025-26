package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Servos {
    public void TurnServo(boolean FireBall, Servo Pusher, Telemetry telemetry){
        if (FireBall){
            Pusher.setPosition(0.5);
        } else {
            Pusher.setPosition(0);
        }
    }
}
