package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Servos {
    public void TurnServo(Gamepad gamepad1, Servo Pusher, Telemetry telemetry){
        if (gamepad1.y){
            Pusher.setPosition(0.5);
            telemetry.addLine("Rotating the servo!");
        } else {
            Pusher.setPosition(0.02);
            telemetry.addLine("Setting servo position to 0");
        }
    }
}
