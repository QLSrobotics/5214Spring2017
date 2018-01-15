package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="driveStraight", group="Team5214")
//@Disabled
public class driveStraight extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor leftFront;
    private DcMotor rightFront;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftBack  = hardwareMap.get(DcMotor.class, "LB");
        rightBack = hardwareMap.get(DcMotor.class, "RB");
        leftFront  = hardwareMap.get(DcMotor.class, "LF");
        rightFront = hardwareMap.get(DcMotor.class, "RF");

        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            driveStraight(0.25,1000);
            telemetry.update();
        }
    }
    private void driveStraight (double power, int time) {
        leftBack.setPower(power);
        rightBack.setPower(power);
        leftFront.setPower(power);
        rightFront.setPower(power);

        sleep(time);

        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
    }

    private void sleep(int i){
        long initial_time = System.currentTimeMillis();
        while(System.currentTimeMillis()-initial_time <i){

        }
    }
}
