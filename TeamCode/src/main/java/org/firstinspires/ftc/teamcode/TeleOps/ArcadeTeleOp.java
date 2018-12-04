package org.firstinspires.ftc.teamcode.TeleOps;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 10/29/18.
 */

@TeleOp(name = "TeleOp",group = "")
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

        float yval = -gamepad1.left_stick_y;
        float xval = -gamepad1.right_stick_x;

        if(Math.abs(xval) < 0.15){
            xval = 0;
        }
        if(Math.abs(yval) < 0.05){
            yval = 0;
        }

        float lpwr = (float) Math.pow(((yval - xval)), 3);
        float rpwr = (float) Math.pow((yval + xval), 3);


//        turtle mode
        if (gamepad1.right_trigger != 0) {
            lpwr /= 3.0f;
            rpwr /= 3.0f;
        }

        else if(gamepad1.left_trigger != 0){
            lpwr /= 7.0f;
            rpwr /= 7.0f;
        }

        if(Math.abs(lpwr)<0.1)
            lpwr = 0;

        if(Math.abs(rpwr)<0.1)
            rpwr = 0;

//      Setting the power for dt
        robot.driveTrain.setLeftPower(lpwr);
        robot.driveTrain.setRightPower(rpwr);

        if (Math.abs(gamepad2.left_stick_y) > 0.1){
            robot.arm.setPower(-gamepad2.left_stick_y/5.0);
        }
//        else if (gamepad2.right_bumper){
//            robot.arm.setPower1();
//        }
//        else if(gamepad2.left_bumper){
//            robot.arm.setPower2();
//        }
//        else if(gamepad2.a){
//            robot.arm.setPower3();
//        }
        else{
            robot.arm.setPower(0);
        }
        if(gamepad2.dpad_up) {
            robot.extender.setPower(1);
        }
        else if(gamepad2.dpad_down) {
            robot.extender.setPower(-1);
        }
        else{
            robot.extender.setPower(0);
        }
        if(gamepad2.right_bumper){
            robot.intake.setPower(0.5);
        }
        else if(gamepad2.left_bumper){
            robot.intake.setPower(-0.5);
        }
        else{
            robot.intake.setPower(0);
        }
        if(-gamepad2.right_stick_y < -0.1){
            robot.wrist.backOuttakePos();
        }
        else if(-gamepad2.right_stick_y > 0.1){
            robot.wrist.intakePos();
        }
        else if(gamepad2.y){
            robot.wrist.frontOuttakePos();
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
