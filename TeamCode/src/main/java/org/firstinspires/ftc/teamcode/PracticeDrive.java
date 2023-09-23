package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class PracticeDrive extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;


    @Override
    public void runOpMode() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");


        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                double speed = 0.35;
                if (gamepad1.y) {
                    telemetry.addLine("Fast Speed");
                    speed = 1;
                } else {
                    telemetry.addLine("Regular Speed");
                    speed = 0.35;
                }


                if (gamepad1.dpad_down) {
                    frontLeft.setPower(-speed);
                    frontRight.setPower(-speed);
                    backLeft.setPower(-speed);
                    backRight.setPower(-speed);
                } else {
                    if (gamepad1.dpad_up) {
                        frontLeft.setPower(speed);
                        frontRight.setPower(speed);
                        backLeft.setPower(speed);
                        backRight.setPower(speed);
                    } else {
                        if (gamepad1.dpad_left) {
                            frontRight.setPower(speed);
                            frontLeft.setPower(-speed);
                            backLeft.setPower(-speed);
                            backRight.setPower(speed);
                        } else if (gamepad1.dpad_right) {
                            frontRight.setPower(-speed);
                            frontLeft.setPower(speed);
                            backLeft.setPower(speed);
                            backRight.setPower(-speed);
                        } else {
                            frontLeft.setPower(0);
                            frontRight.setPower(0);
                            backLeft.setPower(0);
                            backRight.setPower(0);
                            if (gamepad1.right_bumper) {
                                frontRight.setPower(-0.85);
                                frontLeft.setPower(0.85);
                                backRight.setPower(0.85);
                                backLeft.setPower(-0.85);
                            } else if (gamepad1.left_bumper) {
                                frontRight.setPower(0.85);
                                frontLeft.setPower(-0.85);
                                backRight.setPower(-0.85);
                                backLeft.setPower(0.85);
                            }
                        }
                    }
                }
            }

        }
    }
}

