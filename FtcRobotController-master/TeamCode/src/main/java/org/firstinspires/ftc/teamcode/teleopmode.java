package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name ="TeleOpMode")
public class teleopmode extends LinearOpMode{
    //變數設定

    //創建物件
    @Override
    public void runOpMode() throws InterruptedException {
        init_hardware();
        waitForStart();
        //初始狀態設定，例如Servo初始位置
        while(opModeIsActive()) {
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