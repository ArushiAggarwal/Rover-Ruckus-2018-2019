package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Sumanth on 11/6/18.
 */

public class Extender {

    private DcMotor extender;

    public Extender(HardwareMap hardwareMap) {
        extender = hardwareMap.dcMotor.get("extender");

        extender.setDirection(DcMotorSimple.Direction.REVERSE);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        extender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setPower(double power) {
        extender.setPower(power);
    }

    public void setMode() {

        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

}
