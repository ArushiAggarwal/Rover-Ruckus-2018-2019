package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 11/7/18.
 */
@Autonomous(name = "RoTATI Deg")
public class RoTATIDeg extends LinearOpMode{


    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot();

        Gyro gyro = new Gyro();
        gyro.initGyro(hardwareMap);
        robot.init(hardwareMap, gyro);

        telemetry.addData("yaw", robot.driveTrain.gyro.getYaw());
        telemetry.update();

        waitForStart();
        if (opModeIsActive()){
            telemetry.update();
            robot.driveTrain.rotaTITIDeg(90);

        }

    }
}
