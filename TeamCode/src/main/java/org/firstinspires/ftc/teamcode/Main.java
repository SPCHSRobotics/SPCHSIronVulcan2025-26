package org.firstinspires.ftc.teamcode;

//Importing the libraries needed to run "Main.java"
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BallControl.BallControl;
import org.firstinspires.ftc.teamcode.Controls.InputControls;
import org.firstinspires.ftc.teamcode.Driving.OmniDrive;
import org.firstinspires.ftc.teamcode.HardwareMapping.GyroScope;
import org.firstinspires.ftc.teamcode.HardwareMapping.RobotHardware;

@TeleOp(name="Main", group="Linear OpMode")
public class Main extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");


        //Load our input bindings
        InputControls InputControlObject = new InputControls(telemetry);
        //Initialize Hardware, and assign it to an object
        RobotHardware RobotHardwareObject = new RobotHardware(hardwareMap);
        //Load our files so that we can use the functions listed therein
        OmniDrive OmniDriveObject = new OmniDrive();
        BallControl BallControlObject = new BallControl();
        GyroScope GyroScopeObject = new GyroScope();


        telemetry.update();
        waitForStart();
        runtime.reset();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Call our functions here
            InputControlObject.Update(gamepad1, telemetry);

            OmniDriveObject.POV_Driving(
                    InputControlObject.Driving,
                    RobotHardwareObject.Wheels,
                    telemetry
            );

            /*
            OmniDriveObject.Character_Driving(
                    InputControlObject.Driving,
                    GyroScopeObject.GetYaw(
                            InputControlObject.ResetHeader,
                            RobotHardwareObject.imu,
                            telemetry),
                    RobotHardwareObject.Wheels,
                    telemetry
            ); */

            BallControlObject.PowerFlywheel(
                    InputControlObject.Flywheel,
                    RobotHardwareObject.Flywheel,
                    telemetry
            );

            BallControlObject.Gate(
                    RobotHardwareObject.Gate
            );


            //Add the "Run Time" string to telemetry and then update all telemetry
            telemetry.addData("Status: Running | Run Time: ", runtime.toString());
            telemetry.update();
        }

    }
}
