package org.firstinspires.ftc.teamcode.Controls;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class InputControls {
    public InputControls(Telemetry telemetry){
        telemetry.addLine(
                "\nDrive using the LEFT STICK\n" +
                        "Rotate using the RIGHT STICK\n" +
                        "Press RIGHT TRIGGER to move servos\n" +
                        "Press X to reset gyroscope\n" +
                        "DPAD sets shooter power:\n" +
                        "TOP: 100%  | DOWN: 0%\n" +
                        "LEFT: -10% | RIGHT: +10%\n"
        );
    }
    //God forbid a man tries to use a hashmap
    public float[][] Driving = new float[2][2];
    public boolean FireBall;
    public float Flywheel = 1.0f; // By default, the power is 100%
    public boolean ResetHeader;
    public void Update(Gamepad gamepad1, Telemetry telemetry) {
        //Omnidrive inputs
        Driving[0][0] = gamepad1.left_stick_x;  //RESULTING: Left: -1 | Right: 1
        Driving[0][1] = -gamepad1.left_stick_y; //RESULTING: Down: -1 | Up: 1
        Driving[1][0] = gamepad1.right_stick_x; //RESULTING: Left: -1 | Right: 1

        //Servo inputs
        FireBall = gamepad1.right_trigger > 0.5;

        //Flywheel control
        if (gamepad1.dpadDownWasReleased()) {
            Flywheel = 0.0f;
        } else if (gamepad1.dpadUpWasReleased()){
            Flywheel = 1.0f;
        } else if (gamepad1.dpadLeftWasReleased()){
            Flywheel = Flywheel - 0.1f; //subtract 10%
        } else if (gamepad1.dpadRightWasReleased()){
            Flywheel = Flywheel + 0.1f; //add 10%
        }

        //Gyroscope inputs
        ResetHeader = gamepad1.xWasReleased();
    }
}
