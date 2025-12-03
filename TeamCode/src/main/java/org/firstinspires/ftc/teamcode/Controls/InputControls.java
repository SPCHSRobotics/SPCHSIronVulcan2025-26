package org.firstinspires.ftc.teamcode.Controls;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class InputControls {
    public InputControls(Telemetry telemetry){
        telemetry.addLine(
                "\nDrive using the LEFT STICK\n" +
                        "Rotate using the RIGHT STICK\n" +
                        "Press A (bottom, green) for shooters\n" +
                        "Press the DPAD to change shooter speed:\n" +
                        "Down: slowest | Top: fastest\n" +
                        "Press RIGHT TRIGGER to move servo\n" +
                        "Press Y (top, yellow) for intake\n" +
                        "Press B (right, red) to change intake direction\n" +
                        "Press X (left, COLOR) to reset gyroscope"
        );
    }
    //God forbid a man tries to use a hashmap
    public float[][] Driving = new float[2][2];
    /*
    0 0 | Lateral
    0 1 | Axial
    1 0 | Yaw
     */
    public boolean FireBall;
    public boolean[] Intake = new boolean[2];
    //Intake[0] = Power
    //Intake[1] = Direction
    public float ShooterPower = 0.45f; // By default, the power is 45%.
    public boolean ResetHeader;
    public void Update(Gamepad gamepad1, Telemetry telemetry) {
        //Omnidrive inputs
        Driving[0][0] = gamepad1.left_stick_x;
        Driving[0][1] = gamepad1.left_stick_y;
        Driving[1][0] = gamepad1.right_stick_x;

        //Servo inputs
        FireBall = gamepad1.right_trigger > 0.5;

        //Intake inputs
        //We can't have the hold/touch behaviour I wanted because if we do, then the robot
        //will switch directions every time we go to hold the button.
        if (gamepad1.yWasReleased()){
            Intake[0] = !Intake[0];
        }

        if (gamepad1.bWasReleased()){
            Intake[1] = !Intake[1];
        }

        //Shooter inputs
        if (gamepad1.dpadDownWasReleased()){
            ShooterPower = 0.45f;
        } else if (gamepad1.dpadUpWasReleased()) {
            ShooterPower = 0.5f;
        }

        if (gamepad1.aWasReleased()){
            ShooterPower = 0;
        }

        //Gyroscope inputs
        ResetHeader = gamepad1.xWasReleased();
    }
}
