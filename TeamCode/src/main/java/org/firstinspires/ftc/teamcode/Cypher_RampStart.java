package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name="Basic: Linear OpMode", group="Linear Opmode")
@Disabled
public class Cypher_RampStart extends LinearOpMode {
    public static final String TAG = "Vuforia VuMark Sample";

    OpenGLMatrix lastLocation = null;

    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() throws InterruptedException {

        /*
         * To start up Vuforia, tell it the view that we wish to use for camera monitor (on the RC phone);
         * If no camera monitor is desired, use the parameterless constructor instead (commented out below).
         */
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        // OR...  Do Not Activate the Camera Monitor View, to save power
        // VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        //Vuforia LicenseKey
        //do not change the license key
        parameters.vuforiaLicenseKey = "AVOFXuz/////AAAAGf45mZPfQEQBt1NyBSqlPuYQkVhLXgkSQpOqQqWb/FoWqJ" +
                "WqG7KKeaIVeJzCSsLJ58FGWwE0Z/vvzSHrZBeZN9jN7c+gru1h0T3k0wLaoN1b6bFIHn93evRQ0DcFcgy4uMHZ1" +
                "T87fT4WrKldfG6XT7PyThP2Fk5C8SbASqna7IKl26eb+zdOFXRKG+U1pZyV9yGgMsmBVZCxDZiT/G6JUpg4DMGrZVT" +
                "8BXdVvs+mpDLQ4tH/XL5ikYp1++1fbYhJtA3naS5/laHiPiHONGAdLbHkE4s8EOxpB8+lqpJN6hlcqtMegarTOuwWYXXP" +
                "jSnNnkUWBKuW6nWqtF3k1CIUoSTBuFpbwAvf+T6i1CkL6IoB";

        //chose the back camera
        //can also use the front camera by changing "BACK" to "FRONT"
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        telemetry.addData(">", "Press Play to start");
        telemetry.update();
        waitForStart();

        relicTrackables.activate();

        while (opModeIsActive()) {

            //image recognition
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

            //robot code below
            //vuMark is stored as an enum, convert to string to get the value
            switch (vuMark) {
                case CENTER:
                    break;
                case RIGHT:
                    break;
                case LEFT:
                    break;
                default:
                    break;
            }

            telemetry.update();

        }
    }
    private String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }

}
