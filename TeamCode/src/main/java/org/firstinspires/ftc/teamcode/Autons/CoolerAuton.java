package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.GoldAlignUtil;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 11/3/18.
 */

public class CoolerAuton extends LinearOpMode {

    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot();
        Gyro gyro = new Gyro();
        double heading;
        robot.init(hardwareMap, gyro);
        double initHeading = gyro.getYaw();
        ElapsedTime timer = new ElapsedTime();

        waitForStart();
        if(opModeIsActive()){

            timer.startTime();


            while (robot.goldUtil.isAligned() != true){

                robot.driveTrain.alignToGold(robot.goldUtil.getXPos());

            }

            heading = gyro.getYaw();

            if (heading > 5 && heading < 25){

                robot.driveTrain.setMoveDist(46);
                robot.driveTrain.rotateDeg(-110);
                robot.driveTrain.setMoveDist(48);

            }
            else if(heading < 5 && heading < -5){

                robot.driveTrain.setMoveDist(68);

            }
            else if (heading < -5 && heading > -25){

                robot.driveTrain.setMoveDist(46);
                robot.driveTrain.rotateDeg(110);
                robot.driveTrain.setMoveDist(48);

            }

        }

    }

}
