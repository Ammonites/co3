package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name ="TeleOpMode")
public class teleopmode extends TeleOp_Base {
    //變數設定

        double drive, turn, strafe;
        double fr, fl, br, bl, scale;

        @Override
        public void runOpMode() throws InterruptedException {
            init_hardware();
            waitForStart();
            while (opModeIsActive()) {
                drive = -gamepad1.left_stick_y;     //前進
                turn = gamepad1.right_stick_x;      //自旋
                strafe = gamepad1.left_stick_x;    //平移


                fr = drive + turn - strafe;
                fl = drive - turn + strafe;
                br = drive + turn + strafe;
                bl = drive - turn - strafe;


                scale = scaling_power(fr, fl, br, bl);


                FR.setPower(fr / scale);
                FL.setPower(fl / scale);
                BR.setPower(br / scale);
                BL.setPower(bl / scale);

                if (gamepad1.a) {
                    servo.setPosition(0.56);
                } else {
                    servo.setPosition(0.0);


                }
                int motor_pos = 0;

                    {
                        if(gamepad1.b && motor_pos < 1000) {
                            motor_pos += 5;
                        }
                        else if(gamepad1.y && motor_pos > 0) {
                            motor_pos -= 5;
                        }

                    }
                }   
            }
        }

    // 建立函式
// 外面不可以寫程式喔!!!