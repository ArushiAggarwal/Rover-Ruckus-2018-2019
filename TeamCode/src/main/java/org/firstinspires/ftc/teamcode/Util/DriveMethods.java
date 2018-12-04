package org.firstinspires.ftc.teamcode.Util;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Sumanth on 9/29/18.
 */

public class DriveMethods{

    private DcMotor l1, l2, r1, r2;

    public DriveMethods(HardwareMap hardwareMap){

        l1 = hardwareMap.dcMotor.get("l1");
        l2 = hardwareMap.dcMotor.get("l2");
        r1 = hardwareMap.dcMotor.get("r1");
        r2 = hardwareMap.dcMotor.get("r2");

    }

    //TODO: method for changing mode of motors
    //TODO: method for changing direction of motors
    //TODO: method for setting power of motors


}
