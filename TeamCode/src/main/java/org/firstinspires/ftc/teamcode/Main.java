package org.firstinspires.ftc.teamcode;

//Importing the libraries needed to run "Main.java"
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

//Importing other files that we call to "Main.java"
import org.firstinspires.ftc.teamcode.RobotHardware;

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

        //Initialize Hardware
        RobotHardware RobotHardwareObject = new RobotHardware();
        RobotHardwareObject.Initialize(hardwareMap);



        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Call our functions here

            //Add the "Run Time" string to telemetry and then update all telemetry
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
