package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.OffSeasonBot;

@TeleOp()
public class MechanumDrive extends OpMode {
    OffSeasonBot drive = new OffSeasonBot();

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        double f = -gamepad1.left_stick_y;
        double r = gamepad1.left_stick_x;
        double s = gamepad1.right_stick_x;

        drive.drive(f, r, s);
    }
}
