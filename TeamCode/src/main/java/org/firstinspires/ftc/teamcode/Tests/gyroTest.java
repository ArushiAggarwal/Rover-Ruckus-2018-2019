package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 10/27/18.
 */

public class gyroTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot();
        Gyro gyro = new Gyro();

        gyro.initGyro(hardwareMap);
        robot.init(hardwareMap, gyro);

        waitForStart();
        if(opModeIsActive())

            robot.driveTrain.rotateDeg(90);

    }

}
