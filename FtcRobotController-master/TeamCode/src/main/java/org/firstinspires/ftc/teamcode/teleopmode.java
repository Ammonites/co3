package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name ="TeleOpMode")
public class teleopmode extends LinearOpMode{
    //變數設定


    public class TeleOpMode extends TeleOp_Base {
        boolean right_trigger = false;
        @Override
        public void runOpMode() throws InterruptedException {
            init_hardware();
            waitForStart();
            while(opModeIsActive()) {
                Servo servo;
                ElapsedTime timer;
                if(gamepad1.right_trigger > 0.1) {
                    servo.setPosition(0.5);
                    right_trigger = true;
                    timer.reset();
                }
                if(timer.milliseconds() >= 1000 && timer.milliseconds() < 1200 && right_trigger) {
                    servo.setPosition(1);
                }
                else if(timer.milliseconds() >= 2000 && timer.milliseconds() < 2200 && right_trigger) {
                    servo.setPosition(0);
                    right_trigger = false;
                }
            }
        }
    }
    public class teleOpMode extends TeleOp_Base {
        int motor_pos = 0;
        @Override
        public void runOpMode() throws InterruptedException {
            init_hardware();
            waitForStart();
            while(opModeIsActive()) {
                if(gamepad1.a && motor_pos < 1000) {
                    motor_pos += 5;
                }
                else if(gamepad1.y && motor_pos > 0) {
                    motor_pos -= 5;
                }

            }
        }
    }
    //創建物件
    @Override
    public void runOpMode() throws InterruptedException {
        init_hardware();
        waitForStart();
        //初始狀態設定，例如Servo初始位置
        while(opModeIsActive()) {
            class TeleOpMode extends TeleOp_Base {
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
        }
            //迴圈執行內容

            idle();
        }
    }
    // 建立函式
    private void init_hardware() {
        //設定物件

        idle();
    }
}
// 外面不可以寫程式喔!!!