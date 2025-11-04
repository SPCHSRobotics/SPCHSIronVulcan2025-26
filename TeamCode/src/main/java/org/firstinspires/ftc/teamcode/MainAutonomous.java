/*
package org.firstinspires.ftc.teamcode;

//Importing the libraries needed to run "Main.java"
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BallControl.Intake;
import org.firstinspires.ftc.teamcode.BallControl.Servos;
import org.firstinspires.ftc.teamcode.BallControl.Shooters;
import org.firstinspires.ftc.teamcode.Controls.InputControls;
import org.firstinspires.ftc.teamcode.Driving.OmniDrive;
import org.firstinspires.ftc.teamcode.HardwareMapping.RobotHardware;

@Autonomous(name="MainAutonomous", group="Iterative OpMode")
public class MainAutonomous extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.update();
        waitForStart();
        runtime.reset();

        //Initialize Hardware, and assign it to an object
        RobotHardware RobotHardwareObject = new RobotHardware(hardwareMap);
        //Load our files so that we can use the functions listed therein
        OmniDrive OmniDriveObject = new OmniDrive();


        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Call our functions here

            OmniDriveObject.POV_Driving(
                    InputControlObject.Driving,
                    RobotHardwareObject.Wheels,
                    telemetry
            );

            //Add the "Run Time" string to telemetry and then update all telemetry
            telemetry.addData("Status: Running | Run Time: ", runtime.toString());
            telemetry.update();
        }
    }
}
 */