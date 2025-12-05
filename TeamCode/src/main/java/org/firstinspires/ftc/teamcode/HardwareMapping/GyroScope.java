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

        return orientation.getYaw(AngleUnit.RADIANS);
    }
}