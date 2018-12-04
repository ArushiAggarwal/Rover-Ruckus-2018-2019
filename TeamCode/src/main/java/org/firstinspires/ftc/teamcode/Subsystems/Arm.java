package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Sumanth on 11/6/18.
 */

public class Arm {

    private DcMotor arm1, arm2, arm3;

    public Arm (HardwareMap hardwareMap) {

        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");
        arm3 = hardwareMap.dcMotor.get("arm3");


        arm1.setDirection(DcMotorSimple.Direction.REVERSE);
        arm2.setDirection(DcMotorSimple.Direction.REVERSE);
        arm3.setDirection(DcMotorSimple.Direction.FORWARD);

        arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void setPower(double power) {
        arm1.setPower(power);
        arm2.setPower(power);
        arm3.setPower(power);

    }
    public void setPower1(){

        arm1.setPower(1);

    }
    public void setPower2(){

        arm2.setPower(1);


    }
    public void setPower3(){

        arm3.setPower(1);


    }

    public void setMode() {

        arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }



}
