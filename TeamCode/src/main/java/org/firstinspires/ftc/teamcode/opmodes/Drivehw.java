package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.utils.priority.HardwareQueue;
import org.firstinspires.ftc.teamcode.utils.priority.PriorityMotor;
import org.firstinspires.ftc.teamcode.Robot;

public class Drivehw extends LinearOpMode {
    @Override

    public void runOpMode() throws InterruptedException {
        //create motors
        //use hardwareMap
        Robot robot = new Robot(hardwareMap);
        HardwareQueue hardwareQueue = new HardwareQueue();

        PriorityMotor leftFront = new PriorityMotor(
                hardwareMap.get(DcMotorEx.class, "leftFront"),
                "leftFront",
                4, 5, 1.0, sensors
        );
        PriorityMotor leftRear = new PriorityMotor(
                hardwareMap.get(DcMotorEx.class, "leftRear"),
                "leftRear",
                4, 5, -1.0, sensors
        );
        PriorityMotor rightRear = new PriorityMotor(
                hardwareMap.get(DcMotorEx.class, "rightRear"),
                "rightRear",
                4, 5, sensors
        );
        PriorityMotor rightFront = new PriorityMotor(
                hardwareMap.get(DcMotorEx.class, "rightFront"),
                "rightFront",
                4, 5, sensors
        );
        
        hardwareQueue.addDevice(leftFront);
        hardwareQueue.addDevice(leftRear);
        hardwareQueue.addDevice(rightRear);
        hardwareQueue.addDevice(rightFront);


        //init


        //while loop for updates
        //use left and right joysticks
        //left is magnitude of power
        //right is for turning

        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double heading = gamepad1.right_stick_x;

        double rightRearPower;
        double leftRearPower;
        double rightFrontPower;
        double leftFrontPower;



        while(opModeIsActive()) {
            //set values from gamepad

            //calculate power for each motor
            leftFrontPower = y + x + heading;
            rightFrontPower = y -x - heading;
            leftRearPower = y - x - heading;
            rightRearPower = y + x - heading;
            leftFront.setTargetPower(leftFrontPower);
            rightFront.setTargetPower(rightFrontPower);
            leftRear.setTargetPower(leftRearPower);
            rightRear.setTargetPower(rightRearPower);
            //setPowers(leftFrontPower, leftRearPower, rightFrontPower, rightRearPower);
        }

    }

    


}
