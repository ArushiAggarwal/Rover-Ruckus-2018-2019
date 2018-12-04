package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Util.MineralDetectionUtil;

/**
 * Created by Sumanth on 11/2/18.
 */

@Autonomous(name = "MineralDetectionTest", group = "")

public class MineralUtilTest extends LinearOpMode {



    @Override
    public void runOpMode() throws InterruptedException {

        MineralDetectionUtil detectionUtil = new MineralDetectionUtil(hardwareMap);

        detectionUtil.init();


        waitForStart();
        while( opModeIsActive()){

            telemetry.addData("pos", detectionUtil.getMineralPos());



        }

    }
}
