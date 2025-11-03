package org.firstinspires.ftc.teamcode.Controls;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class InputControls {
    //God forbid a man tries to use a hashmap
    public float[][] Driving = new float[2][2];
    /*
    0 0 | Lateral
    0 1 | Axial
    1 0 | Yaw
     */
    public boolean PrimingShooters;
    public boolean FireBall;
    public boolean Intake[] = new boolean[2];
    //Intake[0] = Power
    //Intake[1] = Direction
    ElapsedTime Timer = new ElapsedTime();
    public void Update(Gamepad gamepad1, Telemetry telemetry) {
        Driving[0][0] = gamepad1.left_stick_x;
        Driving[0][1] = gamepad1.left_stick_y;
        Driving[1][0] = gamepad1.right_stick_x;

        PrimingShooters = gamepad1.aWasReleased();
        FireBall = gamepad1.right_trigger > 0.5;


        if (gamepad1.bWasPressed()) {
            Timer.startTime();

        }else if (gamepad1.b) {
            telemetry.addData("Button is held for: ", Timer.seconds());

        } else if (gamepad1.bWasReleased()){
            if (Timer.seconds() >= 2){
                telemetry.addLine("Long press detected!");
                if (Intake[0]){
                    Intake[0] = false;
                } else {
                    Intake[0] = true;
                }

            } else {
                telemetry.addLine("Short press detected!");
                if (Intake[1]){
                    Intake[1] = false;
                } else {
                    Intake[1] = true;
                }
            }
            Timer.reset();
        } else {
            telemetry.addLine("Isn't pressed!");
        }
    }
}
