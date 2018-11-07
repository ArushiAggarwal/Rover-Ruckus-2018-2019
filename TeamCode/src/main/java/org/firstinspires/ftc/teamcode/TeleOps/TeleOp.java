package org.firstinspires.ftc.teamcode.TeleOps;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 10/2/18.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "telele", group = "")
public class TeleOp extends OpMode {

    Robot robot = new Robot();
    Gyro gyro = new Gyro();

    @Override
    public void init() {


        gyro.initGyro(hardwareMap);
        robot.init(hardwareMap, gyro);
    }

    @Override
    public void loop() {

        double leftVal = -gamepad1.left_stick_y;
        double rightVal = -gamepad1.right_stick_y;
        double wristval = -gamepad2.right_stick_y/2.0;
        double armval = -gamepad2.left_stick_y/2.0;




        if(gamepad1.left_bumper && gamepad1.right_bumper) {

            leftVal *= 0.3;
            rightVal *= -0.3;
        }


        robot.driveTrain.setLeftPower(leftVal);
        robot.driveTrain.setRightPower(rightVal);
        robot.extender.setPower(wristval);
        robot.arm.setPower(armval);


    }

    @Override
    public void stop() {

        robot.driveTrain.setLeftPower(0);
        robot.driveTrain.setRightPower(0);
        robot.extender.setPower(0);
        robot.arm.setPower(0);
    }
}
