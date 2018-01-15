package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="armDown_neha", group="Team5214")
//@Disabled
public class armDown_neha extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor colorServo;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        colorServo  = hardwareMap.get(DcMotor.class, "COLORSERVO");
        colorServo.setDirection(DcMotor.Direction.FORWARD);


        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            arm(0.5, 700);
            telemetry.update();
        }
    }

    private void sleep(int i){
        long initial_time = System.currentTimeMillis();
        while(System.currentTimeMillis()-initial_time <i){

        }
    }
    private void arm(double power, int time){
        colorServo.setPower(power);
        sleep(time);
        colorServo.setPower(0);
    }
}
