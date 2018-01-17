package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Created by hima on 1/17/18.
 */

public class rangeLED extends LinearOpMode{
    private DistanceSensor sensorDistance;
    private DigitalChannel digitalPort;
    @Override
    public void runOpMode (){
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        sensorDistance = hardwareMap.get(DistanceSensor.class, "DIST");
        digitalPort = hardwareMap.digitalChannel.get("DIGI");
        while (opModeIsActive()){
            digitalPort.setMode(DigitalChannel.Mode.OUTPUT);

            double distance = sensorDistance.getDistance(DistanceUnit.CM);

            if(distance > 10){
                digitalPort.setState(true);

            } else{
                digitalPort.setState(false);

            }


        }

    }
}
