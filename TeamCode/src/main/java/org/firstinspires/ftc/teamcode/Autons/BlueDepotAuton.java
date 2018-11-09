package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.GoldAlignUtil;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 11/3/18.
 */

@Autonomous(name = "BlueHomeDepot", group = "")
public class BlueDepotAuton extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot();
        Gyro gyro = new Gyro();

        gyro.initGyro(hardwareMap);
        robot.init(hardwareMap, gyro);

        GoldAlignUtil alignUtil = new GoldAlignUtil(hardwareMap);

        alignUtil.init();



        waitForStart();
        if(opModeIsActive()){

//            telemetry.addData("pos", alignUtil.getXPos());
//            telemetry.addData("Is Aligned", alignUtil.isAligned());

            while (!alignUtil.isAligned() && opModeIsActive()){

                robot.driveTrain.alignToGold(alignUtil.getXPos());

            }

            if(Math.abs(gyro.getYaw()) < 7.5)
                robot.driveTrain.setMoveDist(40);
            else if(gyro.getYaw() > 7.5){
                robot.driveTrain.setMoveDist(48);
                robot.driveTrain.rotaTITIDeg( - gyro.getYaw() - 45);
                robot.driveTrain.setMoveDist(Math.sqrt(48*48 + 40*40 - 2*48*40*Math.cos(gyro.getYaw())));
            }
            else if(gyro.getYaw() < -7.5){
                robot.driveTrain.setMoveDist(48);
                robot.driveTrain.rotaTITIDeg( - gyro.getYaw() + 45);
                robot.driveTrain.setMoveDist(Math.sqrt(48*48 + 40*40 - 2*48*40*Math.cos(gyro.getYaw())));
            }

        }









    }
}
