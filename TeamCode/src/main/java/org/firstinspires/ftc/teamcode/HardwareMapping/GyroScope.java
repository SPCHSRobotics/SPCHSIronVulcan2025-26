package org.firstinspires.ftc.teamcode.HardwareMapping;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


public class GyroScope {
    public double GetYaw(boolean resetHeading, IMU imu,Telemetry telemetry){

        if (resetHeading) {
            telemetry.addData("Yaw", "Resetting\n");
            imu.resetYaw();
        }

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();

        double yawAngle360 = orientation.getYaw((AngleUnit.DEGREES));
        // ^ Is between -180 and 180. Positive turns left, negative turns right
        if (yawAngle360 > 0){
            //Do nothing
        } else if (yawAngle360 < 0){
            yawAngle360 = (yawAngle360 + 360);
        } else {
            //This line is redundant since this situation only occurs when yawAngle360 == 0 or 360
            yawAngle360 = 0;
        }

        return Math.toRadians(yawAngle360);
    }
}