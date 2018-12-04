package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Util.Gyro;

/**
 * Created by Sumanth on 11/3/18.
 */
//FOR RED
public class BlueDepot2Crater extends LinearOpMode {


    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot();
        Gyro gyro = new Gyro();

        robot.init(hardwareMap, gyro);

        String mineralLocation = "";

        ElapsedTime timer = new ElapsedTime();

        while(!opModeIsActive()){

            mineralLocation = robot.detectionUtil.getMineralPos();

        }



        waitForStart();
        if(opModeIsActive()){

            timer.startTime();

            while(mineralLocation.equals("UNKNOWN") && timer.milliseconds() < 5000){

                mineralLocation = robot.detectionUtil.getMineralPos();

            }

            if(mineralLocation.equals("LEFT")){

                robot.driveTrain.rotateDeg(-115);
                robot.driveTrain.setMoveDist(46);
                robot.driveTrain.rotateDeg(-65);
                robot.driveTrain.setMoveDist(18);
                robot.driveTrain.rotateDeg(45);
                robot.driveTrain.setMoveDist(62);


            }
            else if(mineralLocation.equals("RIGHT")){

                robot.driveTrain.rotateDeg(-65);
                robot.driveTrain.setMoveDist(46);
                robot.driveTrain.setMoveDist(-12);
                robot.driveTrain.rotateDeg(-115);
                robot.driveTrain.setMoveDist(63);
                robot.driveTrain.rotateDeg(45);
                robot.driveTrain.rotateDeg(40);

            }
            else {

                robot.driveTrain.rotateDeg(-90);
                robot.driveTrain.setMoveDist(68);
                robot.driveTrain.setMoveDist(-12);
                robot.driveTrain.rotateDeg(-90);
                robot.driveTrain.setMoveDist(48);
                robot.driveTrain.rotateDeg(-45);
                robot.driveTrain.setMoveDist(50);


            }






        }

    }
}
