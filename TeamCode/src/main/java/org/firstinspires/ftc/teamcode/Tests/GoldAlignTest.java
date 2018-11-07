package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Util.GoldAlignUtil;


/**
 * Created by SumanthbutactuallyNoorandArushi on 11/3/18.
 */

public class GoldAlignTest extends LinearOpMode {
    public void runOpMode() throws InterruptedException {

        GoldAlignUtil alignUtil = new GoldAlignUtil(hardwareMap);

        alignUtil.init();


        waitForStart();
        while( opModeIsActive()){

            telemetry.addData("pos", alignUtil.getXPos());
            telemetry.addData("Is Aligned", alignUtil.isAligned());




        }

    }


}
