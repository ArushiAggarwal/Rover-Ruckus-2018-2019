package org.firstinspires.ftc.teamcode.TeleOps;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 10/29/18.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOpMotors",group = "")
public class ArcadeTeleOp extends OpMode {

    Robot robot = new Robot();
    Gyro gyro = new Gyro();

    @Override
    public void init() {

    }

    @Override
    public void loop() {

        float yval = gamepad1.left_stick_y;
        float xval = gamepad1.right_stick_x;


        float lpwr = (float) Math.pow(((yval - xval)), 3);
        float rpwr = (float) Math.pow((yval + xval), 3);

        robot.driveTrain.setLeftPower(lpwr);
        robot.driveTrain.setRightPower(rpwr);

        if (Math.abs(gamepad2.left_stick_y) > 0.1) {

            robot.arm.setPower(-gamepad2.left_stick_y / 2.0);

        }
        if (Math.abs(gamepad2.right_stick_y) > 0.1) {
            robot.extender.setPower(-gamepad2.right_stick_y / 2.0);
        }
        if (gamepad1.a)
            robot.arm.setPower1();
        else if(gamepad1.b)
            robot.arm.setPower2();
        else if(gamepad2.y)
            robot.arm.setPower3();
        if(gamepad2.right_bumper)
            robot.extender.setPower(0.5);
        else if(gamepad2.left_bumper)
            robot.extender.setPower(-0.5);
    }

    @Override
    public void stop() {

        robot.driveTrain.setLeftPower(0);
        robot.driveTrain.setRightPower(0);

    }


}
