package org.firstinspires.ftc.teamcode;

//Importing the libraries needed to run "Main.java"
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.BallControl.Intake;
import org.firstinspires.ftc.teamcode.BallControl.Servos;
import org.firstinspires.ftc.teamcode.BallControl.Shooters;
import org.firstinspires.ftc.teamcode.Controls.InputControls;
import org.firstinspires.ftc.teamcode.Driving.OmniDrive;
import org.firstinspires.ftc.teamcode.HardwareMapping.GyroScope;
import org.firstinspires.ftc.teamcode.HardwareMapping.RobotHardware;

import java.util.PrimitiveIterator;

@TeleOp(name="Main", group="Linear OpMode")
public class Main extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        //Load our input bindings
        InputControls InputControlObject = new InputControls(telemetry);

        telemetry.update();
        waitForStart();
        runtime.reset();

        //Initialize Hardware, and assign it to an object
        RobotHardware RobotHardwareObject = new RobotHardware(hardwareMap);
        //Load our files so that we can use the functions listed therein
        OmniDrive OmniDriveObject = new OmniDrive();
        Shooters ShootersObject = new Shooters();
        Servos ServoObject = new Servos();
        Intake IntakeObject = new Intake();
        GyroScope GyroScopeObject = new GyroScope();


        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Call our functions here
            InputControlObject.Update(gamepad1, telemetry);

            OmniDriveObject.POV_Driving(
                    InputControlObject.Driving,
                    RobotHardwareObject.Wheels,
                    telemetry
            );

            OmniDriveObject.Character_Driving(
                    InputControlObject.Driving,
                    GyroScopeObject.GetYaw(
                            InputControlObject.ResetHeader,
                            RobotHardwareObject.imu,
                            telemetry),
                    RobotHardwareObject.Wheels,
                    telemetry
            );

            ShootersObject.PowerShooters(
                    InputControlObject.ShooterPower,
                    RobotHardwareObject.Shooters,
                    telemetry
            );

            ServoObject.TurnServo(
                    InputControlObject.FireBall,
                    RobotHardwareObject.Pusher,
                    telemetry
            );

            IntakeObject.ToggleIntake(
                    InputControlObject.Intake,
                    RobotHardwareObject.Intake,
                    telemetry
            );

            //Add the "Run Time" string to telemetry and then update all telemetry
            telemetry.addData("Status: Running | Run Time: ", runtime.toString());
            telemetry.addData("IMU Yaw: ", GyroScopeObject.GetYaw(
                    false,
                    RobotHardwareObject.imu,
                    telemetry
            ));
            telemetry.update();
        }
    }
}
