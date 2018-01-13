package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="cube_intake", group="Team5214")
//@Disabled
public class cube_intake extends LinearOpMode {

    // Declare OpMode members.
    private DcMotor leftDrive;
    private DcMotor rightDrive;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                leftDrive.setPower(0.5);
                rightDrive.setPower(0.5);
            }
            if (gamepad1.b) {
                leftDrive.setPower(-0.5);
                rightDrive.setPower(-0.5);
            }
            if (gamepad1.x) {
                leftDrive.setPower(0);
                rightDrive.setPower(0);
            }
        }
    }
}
