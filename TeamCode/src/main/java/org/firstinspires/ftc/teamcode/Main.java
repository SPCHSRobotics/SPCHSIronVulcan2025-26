package org.firstinspires.ftc.teamcode;

//Importing the libraries needed to run "Main.java"
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BallControl.Shooters;
import org.firstinspires.ftc.teamcode.Driving.OmniDrive;

@TeleOp(name="Main", group="Linear OpMode")
public class Main extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");

        //Instruction for the offchance our driver is missing
        telemetry.addLine(
        "\n__TO CONTROL ROBOT:__\n" +
        "(On gamepad 1)\n" +
        "Left Joystick to move\n" +
        "Press the A button (green) to toggle shooters\n" +
        "Press the B button (red) to toggle intake\n");
        
        telemetry.update();
        waitForStart();
        runtime.reset();

        //Initialize Hardware, and assign it to an object
        RobotHardware RobotHardwareObject = new RobotHardware(hardwareMap);
        //Load our files so that we can use the functions listed therein
        OmniDrive OmniDriveObject = new OmniDrive(RobotHardwareObject);
        Shooters ShootersObject = new Shooters();


        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Call our functions here
            OmniDriveObject.POV_Driving(gamepad1, RobotHardwareObject.Wheels, telemetry);
            ShootersObject.ToggleShootersAndIntake(gamepad1, RobotHardwareObject.Shooters, telemetry);

            //Add the "Run Time" string to telemetry and then update all telemetry
            telemetry.addData("Status: Running | Run Time: ", runtime.toString());
            telemetry.update();
        }
    }
}
