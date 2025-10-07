package org.firstinspires.ftc.teamcode;

//Importing the libraries needed to run "Main.java"
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Driving.OmniDrive;

@TeleOp(name="Main", group="Linear OpMode")
public class Main extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Initialized", "Status");
        telemetry.update();
        waitForStart();
        runtime.reset();

        //Initialize Hardware, and assign it to an object
        RobotHardware RobotHardwareObject = new RobotHardware(hardwareMap);
        OmniDrive OmniDriveObject = new OmniDrive(RobotHardwareObject);
        //CURRENTLY, PASSING RobotHardwareObject INTO THE DECLARATION DOES NOTHING.

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Call our functions here
            OmniDriveObject.POV_Driving(gamepad1, RobotHardwareObject.Wheels);
            //Add the "Run Time" string to telemetry and then update all telemetry
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
