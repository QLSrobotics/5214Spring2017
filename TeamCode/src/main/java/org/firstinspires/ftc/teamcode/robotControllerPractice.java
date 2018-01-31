package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Faisal on 1/30/2018.
 */

    @TeleOp(name="robotControllerPractice", group="Team5214")
//@Disabled
    public class robotControllerPractice extends LinearOpMode {

        // Declare OpMode members.
        private ElapsedTime runtime = new ElapsedTime();
        private DcMotor leftFront;
        private DcMotor leftBack;
        private DcMotor rightFront;
        private DcMotor rightBack;

        @Override
        public void runOpMode() {
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            leftFront = hardwareMap.get(DcMotor.class, "LF");
            leftBack = hardwareMap.get(DcMotor.class, "LB");
            rightFront = hardwareMap.get(DcMotor.class, "RF");
            rightBack = hardwareMap.get(DcMotor.class, "RB");
            rightBack = hardwareMap.get(DcMotor.class, "RB");

            leftFront.setDirection(DcMotor.Direction.FORWARD);
            leftBack.setDirection(DcMotor.Direction.REVERSE);
            rightFront.setDirection(DcMotor.Direction.FORWARD);
            rightBack.setDirection(DcMotor.Direction.REVERSE);


            waitForStart();
            runtime.reset();


            while (opModeIsActive()) {

                telemetry.update();
            }
        }

        private void driveStraight(double power, int time) {
            leftBack.setPower(power);
            leftFront.setPower(power);
            rightBack.setPower(power);
            rightFront.setPower(power);

            sleep(time);

            leftBack.setPower(0);
            leftFront.setPower(0);
            rightBack.setPower(0);
            rightFront.setPower(0);
        }
        private void turn(double power, int time) {
            leftBack.setPower(-power);
            leftFront.setPower(-power);
            rightBack.setPower(power);
            rightFront.setPower(power);

            sleep(time);

            leftBack.setPower(0);
            leftFront.setPower(0);
            rightBack.setPower(0);
            rightFront.setPower(0);

        }

        private void sleep(int i) {
            long initial_time = System.currentTimeMillis();
            while (System.currentTimeMillis() - initial_time < i) {
            }
        }
    }


