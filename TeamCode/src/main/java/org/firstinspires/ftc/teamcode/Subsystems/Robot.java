package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Util.GoldAlignUtil;
import org.firstinspires.ftc.teamcode.Util.Gyro;
import org.firstinspires.ftc.teamcode.Util.MineralDetectionUtil;

public class Robot
{
    public DriveTrain driveTrain;
    public MineralDetectionUtil detectionUtil;
    public GoldAlignUtil goldUtil;
    public Extender extender;
    public Arm arm;

    public void init(HardwareMap hardwareMap, Gyro gyrofromOpMode)
    {
        driveTrain = new DriveTrain(hardwareMap);
        driveTrain.setGyro(gyrofromOpMode);

        detectionUtil = new MineralDetectionUtil(hardwareMap);
        detectionUtil.init();

        goldUtil = new GoldAlignUtil(hardwareMap);

//        extender = new Extender(hardwareMap);
//        arm = new Arm(hardwareMap);
    }

}
