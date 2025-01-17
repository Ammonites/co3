package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

@TeleOp(name = "AbsoluteDirectionDrive", group = "Linear Opmode")
class co3 extends LinearOpMode {

    private DcMotor LF;
    private DcMotor LB;
    private DcMotor RF;
    private DcMotor RB;

    @Override
    public void runOpMode() {
        // 設定變數
        double driveSpeed = 0.7;

        // 初始化馬達
        LF = hardwareMap.get(DcMotor.class, "LF");
        LB = hardwareMap.get(DcMotor.class, "LB");
        RF = hardwareMap.get(DcMotor.class, "RF");
        RB = hardwareMap.get(DcMotor.class, "RB");

        LF.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);

        RF.setDirection(DcMotorSimple.Direction.REVERSE);
        RB.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            double driveY = gamepad1.left_stick_y;
            double driveX = gamepad1.left_stick_x;
            double driveO = gamepad1.right_stick_x;

            LF.setPower((driveY - driveX - driveO) * driveSpeed);
            LB.setPower((driveY + driveX - driveO) * driveSpeed);
            RF.setPower((driveY + driveX + driveO) * driveSpeed);
            RB.setPower((driveY - driveX + driveO) * driveSpeed);

            telemetry.addData("LF", LF.getCurrentPosition());
            telemetry.addData("LB", LB.getCurrentPosition());
            telemetry.addData("RF", RF.getCurrentPosition());
            telemetry.addData("RB", RB.getCurrentPosition());
            telemetry.update();
        }
    }
}