package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="armDown_neha", group="Team5214")
//@Disabled
public class armDown_neha extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Servo colorServo;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        colorServo  = hardwareMap.get(Servo.class, "COLORSERVO");
        colorServo.setDirection(Servo.Direction.FORWARD);


        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            arm(.5); //arm up, arm down is .75
            telemetry.update();
        }
    }

    private void sleep(int i){
        long initial_time = System.currentTimeMillis(); //creates variable that saves the current time in milliseconds
        while(System.currentTimeMillis()-initial_time <i){ //subtracts the initial time value from the current time to measure elapsed time

        }
    }
    private void arm(double position){
        colorServo.setPosition(position);
    }
}
