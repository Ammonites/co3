package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "TeleOpMode")
class MyTeleOpMode extends LinearOpMode  {
    public class TeleOpMode extends TeleOp_Base {
        double drive, turn, strafe;
        double fr, fl, br, bl, scale;
        @Override
        public void runOpMode() throws InterruptedException {
            init_hardware();
            waitForStart();
            while(opModeIsActive()) {
                drive = -gamepad1.left_stick_y;     //前進
                turn = gamepad1.right_stick_x;      //自旋
                strafe = gamepad1.left_stick_x;    //平移


                fr = drive + turn - strafe;
                fl = drive - turn + strafe;
                br = drive + turn + strafe;
                bl = drive - turn - strafe;


                scale = scaling_power(fr, fl, br, bl);


                FR.setPower(fr/scale);
                FL.setPower(fl/scale);
                BR.setPower(br/scale);
                BL.setPower(bl/scale);
            }
        }

        private double scaling_power(double fr, double fl, double br, double bl) {
            return fr;
        }
    }
    private DcMotorEx leftMotor;
    private DcMotorEx rightMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        init_hardware();
        waitForStart();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            double leftPower = drive + turn;
            double rightPower = drive - turn;

            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);

            telemetry.addData("Left Power", leftPower);
            telemetry.addData("Right Power", rightPower);
            telemetry.update();
            idle();
        }
    }

    private void init_hardware() {
        leftMotor = hardwareMap.get(DcMotorEx.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotorEx.class, "right_motor");

        leftMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    private abstract class TeleOp_Base {
        public abstract void runOpMode() throws InterruptedException;
    }
}