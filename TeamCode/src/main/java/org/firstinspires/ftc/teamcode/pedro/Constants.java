package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//import org.firstinspires.ftc.teamcode.pedroPathing.Controller;


public class Constants {

    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("front_left");
        c.frontRightName.set("front_right");
        c.backLeftName.set("back_left");
        c.backRightName.set("back_right");
        c.frontLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.frontRightDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(DcMotorSimple.Direction.REVERSE);
        c.manualBrakeMode.set(true);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-0.06004785928200549);
        c.yPodOffset.set(7.773409265232837);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.5007944321768295);
                Controller secondaryTranslationalForward = Controller.proportional(0.18503016121566063);
                Controller primaryTranslationalLateral = Controller.proportional(1.1850674165690247);
                Controller secondaryTranslationalLateral = Controller.proportional(0.4378507448376904);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.015454897808530309));
                c.brake.set(Controller.proportionalFeedforward(0.013136663137250763));

                c.headingFeedback.set(Controller.proportional(7.403136332530957));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.04571311663141066, 0.007505068907367873));

                c.linearBrakeCoefficients.set(Matrix.diag(0.0959571525319088, 0.055565687767542386));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.002004457573859635, 0.0021458088124383687));

                c.maxAchievableForwardVelocity.set(63.689752203460365);
                c.maxAchievableStrafeVelocity.set(43.05339518074692);
                c.naturalForwardDeceleration.set(27.196839980326494);
                c.naturalStrafeDeceleration.set(72.59446430374132);
            }
    );
    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }
}