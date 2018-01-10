package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by hima on 1/10/18.
 */

public class mec_straf extends LinearOpMode{
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor clawFront;
    private DcMotor clawBack;
    private Servo clawFrontServo;
    private Servo clawColour;


    public void runOpMode (){
        leftFront = hardwareMap.dcMotor.get("LF");
        rightFront = hardwareMap.dcMotor.get("RF");
        leftBack = hardwareMap.dcMotor.get("LB");
        rightBack = hardwareMap.dcMotor.get("RB");
        clawFront = hardwareMap.dcMotor.get("CF");
        clawBack = hardwareMap.dcMotor.get("CB");
        clawFrontServo = hardwareMap.servo.get("CFS");
        clawColour = hardwareMap.servo.get("CC");

    }

    public void straf(int time, double power){ //takes input of seconds and power from 0 to 1
        //sets some motors pos and some neg to stafe in meccumam read more https://www.youtube.com/watch?v=o-j9TReI1aQ
        leftFront.setPower(power);
        leftBack.setPower(-power);
        rightFront.setPower(-power);
        rightBack.setPower(power);

        //waits for that amount of time
        sleep(time);

        //kills all motors
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);


    }

    public void sleep(int i){
        long initial_time = System.currentTimeMillis();
        while(System.currentTimeMillis()-initial_time <i){

        }
    }


}
