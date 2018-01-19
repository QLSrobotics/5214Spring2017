package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by hima on 1/18/18.
 */

@TeleOp(name="manual_2_crtls", group="Team5214")

public class manual_2_crtls extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    //declares motors
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor leftFront;
    private DcMotor rightFront;

    private DcMotor liftMotor;
    private DcMotor ramp;

    private DcMotor lBelt;
    private DcMotor rBelt;

    private Servo colSer;

    private Servo align;

    private Servo rDum;
    private Servo lDum;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //hooks up all of these motors with the config file
        leftBack  = hardwareMap.get(DcMotor.class, "LB");
        rightBack = hardwareMap.get(DcMotor.class, "RB");
        leftFront  = hardwareMap.get(DcMotor.class, "LF");
        rightFront = hardwareMap.get(DcMotor.class, "RF");

        rDum = hardwareMap.servo.get("RD");
        lDum = hardwareMap.servo.get("LD");
        colSer =hardwareMap.servo.get("COLORSERVO");
        align = hardwareMap.servo.get("ALIGN1");

        lBelt = hardwareMap.dcMotor.get("LBELT");
        rBelt = hardwareMap.dcMotor.get("RBELT");

        liftMotor = hardwareMap.dcMotor.get("LIFT");
        ramp = hardwareMap.dcMotor.get("RMP");

        waitForStart();

        boolean limtHit = true;
        boolean go;

        while (opModeIsActive()) {


            //game pad one cotrls

            //gp 1 dpad
            if(gamepad1.dpad_up){lBelt.setPower(.5);rBelt.setPower(-.5);}
            if(gamepad1.dpad_down){lBelt.setPower(-.5);rBelt.setPower(.5);}
            if(gamepad1.dpad_left){colSer.setPosition(.5);}
            if(gamepad1.dpad_right){lBelt.setPower(0);rBelt.setPower(0);}

            if(gamepad1.y){ramp.setPower(0.5);
            } else if(gamepad1.x){ramp.setPower(-0.5);
            } else{ramp.setPower(0);}

            if(gamepad1.a){
                align.setPosition(0);
                sleep(100);
                align.setPosition(0.25);
                sleep(100);
                align.setPosition(0.35);
                sleep(100);
                align.setPosition(0.45);
                sleep(100);
                align.setPosition(0.55);
                sleep(150);
                align.setPosition(0.7);
                sleep(150);
                align.setPosition(0.8);
                sleep(300);
                align.setPosition(0.9);
                sleep(400);
                align.setPosition(0);
                sleep(100);

            }

            if(gamepad2.a){
                align.setPosition(0);
                sleep(100);
                align.setPosition(0.25);
                sleep(100);
                align.setPosition(0.35);
                sleep(100);
                align.setPosition(0.45);
                sleep(100);
                align.setPosition(0.55);
                sleep(150);
                align.setPosition(0.7);
                sleep(150);
                align.setPosition(0.8);
                sleep(300);
                align.setPosition(0.9);
                sleep(400);
                align.setPosition(0);
                sleep(100);

            }

            //mecaum
            leftFront.setPower(curveSqr(((gamepad2.left_trigger - gamepad2.right_trigger)*-.50)-gamepad1.left_stick_y + gamepad1.left_stick_x+ gamepad1.right_stick_x - gamepad2.left_stick_y + gamepad2.left_stick_x+ gamepad2.right_stick_x )*.5);
            rightFront.setPower(curveSqr(((gamepad2.left_trigger - gamepad2.right_trigger)*-.50)+gamepad1.left_stick_y + gamepad1.left_stick_x+ gamepad1.right_stick_x + gamepad2.left_stick_y + gamepad2.left_stick_x+ gamepad2.right_stick_x)*.5);
            leftBack.setPower(curveSqr(((-gamepad2.left_trigger + gamepad2.right_trigger)*-.50)-gamepad1.left_stick_y - gamepad1.left_stick_x+ gamepad1.right_stick_x - gamepad2.left_stick_y - gamepad2.left_stick_x+ gamepad2.right_stick_x)*.5);
            rightBack.setPower(curveSqr(((-gamepad2.left_trigger + gamepad2.right_trigger)*-.50)+gamepad1.left_stick_y - gamepad1.left_stick_x+ gamepad1.right_stick_x + gamepad2.left_stick_y - gamepad2.left_stick_x+ gamepad2.right_stick_x)*.5);



            //elevator controls
            if((gamepad2.b) && (limtHit=false)){
                go = true;
            }

            if((go=true) && (limtHit=false)){
                liftMotor.setPower(-.5);
            }



            //game pd ywo d pad
            if(gamepad2.dpad_up){lBelt.setPower(.5);rBelt.setPower(-.5);}
            if(gamepad2.dpad_down){lBelt.setPower(-.5);rBelt.setPower(.5);}
            if(gamepad2.dpad_left){liftMotor.setPower(0);}
            if(gamepad2.dpad_right){lBelt.setPower(0);rBelt.setPower(0);}


            //servo Y up gamepad 2
            if(gamepad2.y){ lDum.setPosition(.15); rDum.setPosition(.85);}

            //servo X down gamepad 2
            if(gamepad2.x){lDum.setPosition(.7); rDum.setPosition(.3);}



        }
    }


    private double curveSqr (double in){
        double out = (in * Math.abs(in));
        return out;
    }
    private double curveCube(double in){
        double out = (in * in * in);
        return out;
    }
    private void sleep(int i){
        long initial_time = System.currentTimeMillis(); //creates variable that saves the current time in milliseconds
        while(System.currentTimeMillis()-initial_time <i){ //subtracts the initial time value from the current time to measure elapsed time

        }
    }

}
