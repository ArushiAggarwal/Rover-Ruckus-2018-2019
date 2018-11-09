package org.firstinspires.ftc.teamcode.TeleOps;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 10/29/18.
 */

@TeleOp(name = "arcadeNiggas",group = "")
public class ArcadeTeleOp extends OpMode {

    Robot robot = new Robot();
    Gyro gyro = new Gyro();

    @Override
    public void init() {

        gyro.initGyro(hardwareMap);
        robot.init(hardwareMap, gyro);

        robot.driveTrain.setDrive(DriveTrain.Drive.SPEED);

    }

    @Override
    public void loop() {

        double leftVal = -gamepad1.left_stick_y;
        double rightVal = -gamepad1.right_stick_y;


        if(gamepad1.left_bumper && gamepad1.right_bumper) {

            leftVal *= 0.3;
            rightVal *= -0.3;
        }


        robot.driveTrain.setLeftPower(leftVal);
        robot.driveTrain.setRightPower(rightVal);

        if (Math.abs(gamepad2.left_stick_y) > 0.1){
            robot.arm.setPower(-gamepad2.left_stick_y/5.0);
        }
        else if (gamepad2.right_bumper){
            robot.arm.setPower1();
        }
        else if(gamepad2.left_bumper){
            robot.arm.setPower2();
        }
        else if(gamepad2.a){
            robot.arm.setPower3();
        }
        else{
            robot.arm.setPower(0);
        }
        if(gamepad2.dpad_up) {
            robot.extender.setPower(0.5);
        }
        else if(gamepad2.dpad_down) {
            robot.extender.setPower(-0.5);
        }
        else{
            robot.extender.setPower(0);
        }
        if(Math.abs(gamepad2.right_stick_y) > 0.1){
            robot.intake.setPower(-0.5 * Math.signum(gamepad2.right_stick_y));
        }
        else{
            robot.intake.setPower(0);
        }
        if(gamepad2.y){
            robot.wrist.outtakePos();
        }
        else if(gamepad2.x){
            robot.wrist.intakePos();
        }

        telemetry.addData("", robot.wrist.display());
        telemetry.update();


    }

    @Override
    public void stop() {

        robot.driveTrain.setLeftPower(0);
        robot.driveTrain.setRightPower(0);

    }


}
