package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.utils.priority.HardwareQueue;
import org.firstinspires.ftc.teamcode.utils.priority.PriorityMotor;

public class Drivehw extends LinearOpMode {
    @Override

    public void runOpMode() throws InterruptedException {
        //create motors

        PriorityMotor leftFront;
        PriorityMotor leftRear;
        PriorityMotor rightRear;
        PriorityMotor rightFront;
        final HardwareQueue hardwareQueue;


        HardwareMap hardwareMap = robot.hardwareMap;
        this.hardwareQueue = robot.hardwareQueue;



        leftFront = new PriorityMotor(
                hardwareMap.get(DcMotorEx.class, "leftFront"),
                "leftFront",
                4, 5, 1.0, sensors
        );

        leftRear = new PriorityMotor(
                hardwareMap.get(DcMotorEx.class, "leftRear"),
                "leftRear",
                4, 5, -1.0, sensors
        );
        rightRear = new PriorityMotor(
                hardwareMap.get(DcMotorEx.class, "rightRear"),
                "rightRear",
                4, 5, sensors
        );
        rightFront = new PriorityMotor(
                hardwareMap.get(DcMotorEx.class, "rightFront"),
                "rightFront",
                4, 5, sensors
        );
        //use hardware map

        //init


        //while loop for updates
        //use left and right joysticks
        //left is magnitude of power
        //right is for turning

        public void setPowers(double lF, double lR, double rF, double rR) {
            leftFront.setTargetPower(lF);
            leftRear.setTargetPower(lR);
            rightRear.setTargetPower(rR);
            rightFront.setTargetPower(rF);
        }

        while(opModeIsActive()) {
            //set values from gamepad
            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double heading = gamepad1.right_stick_x;
            //calculate power for each motor
            double leftFrontPower = y + x + heading;
            double rightFrontPower = y -x - heading;
            double leftRearPower = y - x - heading;
            double rightRearPower = y + x - heading;

            setpowers(leftFrontPower, leftRearPower, rightFrontPower, rightRearPower);
        }

    }




}
