package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name ="TeleOpMode")
public class teleopmode extends TeleOp_Base{
    //變數設定
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
    // 建立函式
<<<<<<< HEAD
    private void init_hardware() {
        //設定物件

        idle();
    }
=======
>>>>>>> 27adbfae39c2d56f0a31911f4c474cdc3fe63ed1
}
// 外面不可以寫程式喔!!!