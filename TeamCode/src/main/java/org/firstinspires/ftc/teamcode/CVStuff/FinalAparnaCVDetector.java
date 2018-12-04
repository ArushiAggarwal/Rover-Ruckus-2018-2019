package org.firstinspires.ftc.teamcode.CVStuff;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.disnodeteam.dogecv.detectors.roverrukus.SamplingOrderDetector;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp(name = "Final RohParnaCv")
public class FinalAparnaCVDetector extends LinearOpMode {
    public SamplingOrderDetector detector;
    public GoldAlignDetector detectorAlign;


    @Override
    public void runOpMode() throws InterruptedException {
        initOrder();
//        initAlign();

        waitForStart();

        while (opModeIsActive()){
            telemetry.addData("Current Order" , detector.getCurrentOrder().toString()); // The current result for the frame
//            telemetry.addData("IsAligned" , detectorAlign.getAligned()); // Is the bot aligned with the gold mineral
//            telemetry.addData("X Pos" , detectorAlign.getXPosition()); // Gold X pos.
        }
//        detectorAlign.disable();
        detector.disable();

    }

//
//    public void initAlign() {
//        telemetry.addData("Status", "DogeCV 2018.0 - Sampling Order Example");
//
//        detector = new SamplingOrderDetector();
//        detector.initTeleOp(hardwareMap.appContext, CameraViewDisplay.getInstance());
//        detector.useDefaults();
//
//        detector.downscale = 0.4; // How much to downscale the input frames
//
//        // Optional Tuning
//        detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
//        //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
//        detector.maxAreaScorer.weight = 0.001;
//
//        detector.ratioScorer.weight = 15;
//        detector.ratioScorer.perfectRatio = 1.0;
//
//        detector.enable();
//
//
//    }

    public void initOrder() {
        telemetry.addData("Status", "DogeCV 2018.0 - Sampling Order Example");

        detector = new SamplingOrderDetector();
        detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
        detector.useDefaults();

        detector.downscale = 0.4; // How much to downscale the input frames

        // Optional Tuning
        detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
        //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
        detector.maxAreaScorer.weight = 0.001;

        detector.ratioScorer.weight = 15;
        detector.ratioScorer.perfectRatio = 1.0;

        detector.enable();


    }
}

