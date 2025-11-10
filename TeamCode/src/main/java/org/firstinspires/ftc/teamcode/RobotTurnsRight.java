package org.firstinspires.ftc.teamcode;

//Importing the libraries needed to run "Main.java"
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Driving.OmniDrive;
import org.firstinspires.ftc.teamcode.HardwareMapping.RobotHardware;

@Autonomous(name="RobotTurnsRight", group="Linear OpMode")
public class RobotTurnsRight extends LinearOpMode {

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

            if (runtime.seconds() < 2){
                //Instead of taking driver input, these values represent what the driver would have
                //pressed for the bot to move the way we want it to
                float[][] SimulatedDriving = new float[2][2];
                SimulatedDriving[0][0] = 0f; //Here for consistency
                SimulatedDriving[0][1] = -1f; //Move forward
                SimulatedDriving[1][0] = 0f; //Turn right

                OmniDriveObject.POV_Driving(
                        SimulatedDriving,
                        RobotHardwareObject.Wheels,
                        telemetry
                );
            } else {
                //Instead of taking driver input, these values represent what the driver would have
                //pressed for the bot to move the way we want it to
                float[][] SimulatedDriving = new float[2][2];
                SimulatedDriving[0][0] = 0f; //Here for consistency
                SimulatedDriving[0][1] = 0f; //Move forward
                SimulatedDriving[1][0] = 0f; //Turn right

                OmniDriveObject.POV_Driving(
                        SimulatedDriving,
                        RobotHardwareObject.Wheels,
                        telemetry
                );
            }

            //Add the "Run Time" string to telemetry and then update all telemetry
            telemetry.addData("Status: Running | Run Time: ", runtime.toString());
            telemetry.update();
        }
    }
}