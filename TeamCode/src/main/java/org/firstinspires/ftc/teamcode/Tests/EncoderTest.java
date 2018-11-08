package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 10/2/18.
 */
@Autonomous(name = "enc", group = "")
public class EncoderTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot();
        Gyro gyro = new Gyro();
        gyro.initGyro(hardwareMap);
        robot.init(hardwareMap, gyro);

        int i = 0;

        waitForStart();
        while(opModeIsActive()){

            if(i == 0){

                robot.driveTrain.setMoveDist(25);
                i++;

            }

            telemetry.addData("dt", robot.driveTrain.display());
            telemetry.update();

        }

    }

    //TODO: Write a program that will drive a set number of inches,
    //TODO: given the diameter of the wheel and the number of encoder
    //TODO: ticks per one revolution
    //TODO: Diameter : 4 inches
    //TODO: Ticks per Revolution : 1500
    //TODO: -- Be able to drive a set number of inches


}
