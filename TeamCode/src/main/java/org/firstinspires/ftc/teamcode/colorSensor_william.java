package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="colorSensor_william", group="Team5214")
@Disabled
public class colorSensor_william extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private ColorSensor colorSensorFront;
    private ColorSensor colorSensorBack;

    @Override
    public void runOpMode() {

        colorSensorFront = hardwareMap.get(ColorSensor.class, "CSF");
        colorSensorBack = hardwareMap.get(ColorSensor.class, "CSB");
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            telemetry.update();
        }
    }
}
