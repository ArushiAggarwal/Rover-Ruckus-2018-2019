package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.hardware.modernrobotics.comm.RobotUsbDevicePretendModernRobotics;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.GoldAlignUtil;
import org.firstinspires.ftc.teamcode.Util.Gyro;
import org.opencv.core.Mat;


/**
 * Created by SumanthbutactuallyNoorandArushi on 11/3/18.
 */
@Autonomous(name = "goldAligner", group = "")
public class GoldAlignTest extends LinearOpMode {
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot();
        Gyro gyro = new Gyro();

        gyro.initGyro(hardwareMap);
        robot.init(hardwareMap, gyro);

        GoldAlignUtil alignUtil = new GoldAlignUtil(hardwareMap);

        alignUtil.init();

        double storeHeading;


        waitForStart();
        if(opModeIsActive()){

//            telemetry.addData("pos", alignUtil.getXPos());
//            telemetry.addData("Is Aligned", alignUtil.isAligned());

            storeHeading = gyro.getYaw();

            while (!alignUtil.isAligned() && opModeIsActive()){

                robot.driveTrain.alignToGold(alignUtil.getXPos());

            }

            robot.driveTrain.setMoveDist(50);

            storeHeading = gyro.getYaw()-storeHeading;

            if(storeHeading > -10){
                robot.driveTrain.rotateDeg(90 - storeHeading);
                robot.driveTrain.setMoveDist(Math.sqrt(68*68 + 50*50 - 2*68*50* Math.cos(storeHeading)));
            }
            else if(storeHeading > 10){
                robot.driveTrain.rotateDeg(-90 + storeHeading);
                robot.driveTrain.setMoveDist(Math.sqrt(68*68 + 50*50 - 2*68*50* Math.cos(storeHeading)));
            }
            else{

                robot.driveTrain.setMoveDist(18);

            }



        }

    }


}
