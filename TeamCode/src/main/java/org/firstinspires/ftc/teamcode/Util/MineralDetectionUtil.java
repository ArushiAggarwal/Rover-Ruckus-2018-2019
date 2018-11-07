package org.firstinspires.ftc.teamcode.Util;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.SamplingOrderDetector;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Sumanth on 11/2/18.
 */

public class MineralDetectionUtil{

    private SamplingOrderDetector detector;
    private HardwareMap hardwareMap;


    public MineralDetectionUtil(HardwareMap hardwareMap){

        this.hardwareMap = hardwareMap;


    }

    public void init(){

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

    public String getMineralPos(){

        return detector.getCurrentOrder().toString();


    }

    public void stop(){

        detector.disable();

    }

}
