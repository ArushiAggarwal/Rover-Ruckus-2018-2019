package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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
    public Intake intake;
    public Wrist wrist;

    public void init(HardwareMap hardwareMap, Gyro gyrofromOpMode)
    {
        driveTrain = new DriveTrain(hardwareMap);
        driveTrain.setGyro(gyrofromOpMode);
        extender = new Extender(hardwareMap);
        arm = new Arm(hardwareMap);
        intake = new Intake(hardwareMap);
        wrist = new Wrist(hardwareMap);

    }
}
