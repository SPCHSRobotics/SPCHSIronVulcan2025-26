package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;;
public class Intake {
    public void ToggleIntake(boolean[] IntakeInput, DcMotor Intake , Telemetry telemetry){

        if (IntakeInput[0]){
            if (IntakeInput[1]){
                Intake.setPower(-1);
            } else {
                Intake.setPower(1);
            }
            telemetry.addLine("Intake on!");
        } else {
            Intake.setPower(0);
            telemetry.addLine("Intake off!");
        }
    }
}
