package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Sumanth on 11/8/18.
 */

public class Wrist implements SubsystemTemplate {

    Servo wrist;

    public Wrist(HardwareMap hardwareMap){

        wrist = hardwareMap.servo.get("mover");
//        wrist.setDirection(Servo.Direction.REVERSE);

    }
    public void intakePos(){

        wrist.setPosition(0.5);

    }
    public void backOuttakePos(){

        wrist.setPosition(0.1);

    }
    public void frontOuttakePos(){
        wrist.setPosition(1);
    }

    @Override
    public String display() {
        return "Pos" + wrist.getPosition();
    }
}
