package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "OffSeasonBot")
public class OffSeasonBot extends LinearOpMode {
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    double backLeftPower;
    double backRightPower;
    double frontLeftPower;
    double frontRightPower;

    @Override
    public void runOpMode() {
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();
        while (opModeIsActive()) {
            double f = -gamepad1.left_stick_y;
            double r = gamepad1.right_stick_x;
            double s = gamepad1.left_stick_x;

            frontLeft.setPower((f+r+s)/3);
            frontRight.setPower((f-r-s)/3);
            backLeft.setPower((f+r-s)/3);
            backRight.setPower((f-r+s)/3);

        }



    }
}

