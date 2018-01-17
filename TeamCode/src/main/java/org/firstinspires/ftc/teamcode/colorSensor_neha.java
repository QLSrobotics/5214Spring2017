package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="colorSensor_neha", group="Team5214")
//@Disabled
public class colorSensor_neha extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    private ColorSensor colorSensorFront; //declares two color sensor objects, colorSensorFront and colorSensorBack
    private ColorSensor colorSensorBack;

    @Override
    public void runOpMode() {

        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        colorSensorFront  = hardwareMap.get(ColorSensor.class, "CSF");
        colorSensorBack = hardwareMap.get(ColorSensor.class, "CSB");
        //if checkCol(colorSensorBack,colorSensorFront,3) == "rED"

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {


            telemetry.update();
        }
    }


    public String checkColor(ColorSensor front, ColorSensor back, double ratio){ //declares string
        double redOverBluFront = front.red()/front.blue(); //red over blue ratio for front color sensor
        double redOverBluBack = back.red()/back.blue();//red over blue ratio for back color sensor
        if(redOverBluBack >= ratio && redOverBluFront >= ratio){ //if front is red and back is blue, return red
            return "RED";
        }
        else if (((1/redOverBluBack)>=ratio) && ((redOverBluFront)>=ratio)){ //if front is blue and back is red, return blue
            return "BLUE";
        }
        else if (((1/redOverBluBack)>=ratio) && ((redOverBluFront)<=ratio) && ((redOverBluFront)>=1/ratio)){ //if back is blue and front is unsure, return red
            return "RED";
        }
        else if (((redOverBluBack)>=ratio) && ((redOverBluFront)<=ratio) && ((redOverBluFront)>=1/ratio)){ //if back is red and front is unsure, return blue
            return "BLUE";
        }
        else if (((1/redOverBluFront)>=ratio) && ((redOverBluBack)<=ratio) && ((redOverBluBack)>=1/ratio)){ //if front is blue and back is unsure, return blue
            return "BLUE";
        }
        else if (((redOverBluBack)>=ratio) && ((redOverBluFront)<=ratio) && ((redOverBluFront)>=1/ratio)){ //if front is red and back is unsure, return red
            return "RED";
        }
        else { //if none of the above, we don't know what's happening, so return undefined.
            return "UNDEF";
        }
    }
}
