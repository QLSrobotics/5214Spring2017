/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="sample", group="Team5214")
//@Disabled
public class sample extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    //declare drive motors
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor leftFront;
    private DcMotor rightFront;
    // declare dump servo
    private Servo leftDump;
    private Servo rightDump;
    // declare color servo
    private Servo colorServo;
    // declare color sensor
    ColorSensor colorFront;
    ColorSensor colorBack;
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //mapping drive motors to configuration
        leftBack  = hardwareMap.get(DcMotor.class, "LB");
        rightBack = hardwareMap.get(DcMotor.class, "RB");
        leftFront  = hardwareMap.get(DcMotor.class, "LF");
        rightFront = hardwareMap.get(DcMotor.class, "RF");

        //mapping dump servos to configuration
        leftDump  = hardwareMap.get(Servo.class, "LD");
        rightDump = hardwareMap.get(Servo.class, "RD");

        //mapping color servo to configuration
        colorServo  = hardwareMap.get(Servo.class, "COLORSERVO");

        //mapping color sensor to configuration
        colorFront  = hardwareMap.get(ColorSensor.class, "CSF");
        colorBack = hardwareMap.get(ColorSensor.class, "CSB");

        //drive motor directions
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

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
    private void dump(double leftActive, double rightActive, double leftRest, double rightRest) {
        leftDump.setPosition(leftActive);
        rightDump.setPosition(rightActive);
    }
    private void arm(double position) {

        colorServo.setPosition(position);
    }
    private void sleep(int i) {
        long initial_time = System.currentTimeMillis();
        while (System.currentTimeMillis() - initial_time < i) {

        }
    }
    public String checkColor(ColorSensor front, ColorSensor back, double ratio) {
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
