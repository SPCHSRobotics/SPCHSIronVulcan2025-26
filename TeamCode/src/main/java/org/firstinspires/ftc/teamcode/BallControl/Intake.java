package org.firstinspires.ftc.teamcode.BallControl;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;;
public class Intake {
    public void ToggleIntake(boolean[] IntakeInput, DcMotor Intake , Telemetry telemetry){

        if (IntakeInput[0]){ //If the driver means for the intake to be on
            int direction = (IntakeInput[1]) ? -1 : 1;
            Intake.setPower(direction*0.8);
        } else {
            Intake.setPower(0);
        }

        String telInDir = (IntakeInput[1]) ? "OUT" : "IN";
        telemetry.addData("Intake direction: ", telInDir);
    }
}
