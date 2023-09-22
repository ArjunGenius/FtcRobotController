package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

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

        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        while (opModeIsActive()) {
            double f = -gamepad1.left_stick_y;
            double r = gamepad1.right_stick_x;
            double s = gamepad1.left_stick_x;

        }


    }
    private void setPowers(double backLeftPower, double backRightPower, double frontLeftPower,
        double frontRightPower) {
        double maxSpeed = 1.0;
        maxSpeed = Math.max(maxSpeed, Math.abs(backLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backRightPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontRightPower));
        backLeftPower/=maxSpeed;
        backRightPower/=maxSpeed;
        frontLeftPower/=maxSpeed;
        frontRightPower/=maxSpeed;

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);
    }
    public void drive(double f, double r, double s) {
        double frontLeftPower = f+r+s;
        double frontRightPower = f-r-s;
        double backLeftPower = f+r-s;
        double backRightPower= f-r+s;

        setPowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }

    public void init(HardwareMap hardwareMap) {
    }
}

