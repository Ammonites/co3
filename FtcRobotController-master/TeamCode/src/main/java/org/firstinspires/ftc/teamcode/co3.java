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

@TeleOp(name = "co3", group = "Linear Opmode")
public class co3 extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;


    @Override
    public void runOpMode() {
        // 初始化硬件
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");
       

        // 設定馬達方向
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // 設定馬達零功率行為
        leftMotor.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);

        // 初始化IMU


        // 等待比賽開始
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            double leftPower = drive + turn;
            double rightPower = drive - turn;

            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);




        }
    }
}

@TeleOp(name = "AbsoluteDirectionDrive", group = "Linear Opmode")
class AbsoluteDirectionDrive extends LinearOpMode {

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