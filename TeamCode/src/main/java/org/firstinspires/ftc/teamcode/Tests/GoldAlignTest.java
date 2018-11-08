package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.hardware.modernrobotics.comm.RobotUsbDevicePretendModernRobotics;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.GoldAlignUtil;
import org.firstinspires.ftc.teamcode.Util.Gyro;


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


        waitForStart();
        if(opModeIsActive()){

//            telemetry.addData("pos", alignUtil.getXPos());
//            telemetry.addData("Is Aligned", alignUtil.isAligned());

            while (!alignUtil.isAligned() && opModeIsActive()){

                robot.driveTrain.alignToGold(alignUtil.getXPos());

            }




        }

    }


}
