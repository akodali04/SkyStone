package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AtharvaAutonExample", group = "FTC")
public class ExampleAutoneL extends LinearOpMode {

    DcMotor leftDrive, rightDrive;

    ElapsedTime runTime = new ElapsedTime();

    double power = 0.85; //scale from 0 to 1.0

    @Override
    public void runOpMode() throws InterruptedException {
            leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
            rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

            leftDrive.setDirection(DcMotor.Direction.FORWARD);
            rightDrive.setDirection(DcMotor.Direction.REVERSE);

            telemetry.addLine("Robot Ready");
            telemetry.update();

            waitForStart();
            for(int i = 0; i < 4; i++) {
                //go forward for 0.7 seconds
                leftDrive.setPower(power);
                rightDrive.setPower(power);
                sleep(700); //700 milisecconds = same as 0.7 seconds

                //Turn left for 0.3 seconds
                leftDrive.setPower(-power);
                rightDrive.setPower(power);
                sleep(300);
            }
            leftDrive.setPower(0);
            rightDrive.setPower(0);
    }
}
