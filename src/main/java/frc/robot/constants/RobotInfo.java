package frc.robot.constants;

import com.pathplanner.lib.util.PIDConstants;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public final class RobotInfo {
    public static final class SwerveInfo {
        public static final double centerToWheel = 0.245;

        // Change MOVEMENT_SPEED to 1.0 for max speed
        public static final double CURRENT_MAX_ROBOT_MPS = 9;
        public static final double TELOP_ROTATION_SPEED = 12;


        public static final PIDController choreoX = new PIDController(10, 0, 0);
        public static final PIDController choreoY = new PIDController(10, 0, 0);
        public static final PIDController choreoRotation = new PIDController(10, 0, 0);
        public static final PIDTemplate TeleopRotationPID = new PIDTemplate(1, 0, 0);
        public static final double TIME_BEFORE_INTAKE_START = 1;
    }

    public static final class IntakeInfo {

        public static final double INTAKE_SPEED = -0.8;
        public static final double INTAKE_PIVOT_DEFAULT_SETPOINT = 0.63;
        public static final double INTAKE_PIVOT_EXTENDED_SETPOINT = 0.87;
        public static final PIDTemplate INTAKE_PIVOT_PID_CONSTANTS = new PIDTemplate(.008, 0, 0);
    }

    public static final class HopperInfo {

        public static final double HOPPER_SPEED = 0.7;
    }

    public static final class ClimberInfo {
        public static final double CLIMBER_SPEED = 0.9;
    }

    public static final class AimInfo {

        public static final double AIM_TOLERANCE = Math.toRadians(1);
        public static final PIDTemplate LIMELIGHT_AIM_PID_CONSTANTS = new PIDTemplate(2, 0.01, 0);
        public static final double AIM_ROT_POW = 1.2;
        public static final double AIM_UPWARDS_TILT = Math.PI / 6;
        public static final double AIM_TIME = 0.5;
    }

    public static class ShooterInfo {
        public static double LimelightTxOffset = -8;
        public static double LimelightOffsetZ = -0.1651;
        public static double LimelightOffsetX = -0.1267;

        public static double ShooterLowerOffset = 0.9;

        public record ShooterSetpoint(double speed, double angle) {
        }

        public record ShooterSetpointMeasurement(double distance, ShooterInfo.ShooterSetpoint setpoint) {
        }

        public enum ShootingMode {
            AUTO_SPEAKER, SPINUP, SPEAKER, AMP, IDLE, LAUNCH, INTAKE
        }

        public static final double SHOOTER_IDLE_SPEED = 0.2;
        public static final double SHOOTER_AUTON_IDLE_SPEED = 0.35;
        public static final double SHOOTER_INTAKE_SPEED = -0.35;
        public static final double SHOOTER_PIVOT_BOTTOM_SETPOINT = .9;
        public static final double AngleOffset = -0.005;

        public static final double SHOOTER_PIVOT_ERROR = 0.01;

        public static final ShooterInfo.ShooterSetpoint SHOOTER_AMP_SETPOINT = new ShooterInfo.ShooterSetpoint(
                6.8,
                .8
       );
        public static final ShooterInfo.ShooterSetpoint SHOOTER_SPEAKER_SETPOINT =
                new ShooterSetpointMeasurement(1.2, new ShooterSetpoint(24.5, ShooterLowerOffset - 0.083)).setpoint;
        public static final ShooterInfo.ShooterSetpoint SHOOTER_LAUNCH_SETPOINT = new ShooterInfo.ShooterSetpoint(
                40,
                .8
        );

        public static final ShooterInfo.ShooterSetpoint SHOOTER_INTAKE_SETPOINT = new ShooterInfo.ShooterSetpoint(
                -15,
                .8
        );

        public static final double SHOOTER_VOLTAGE = 10;

        public static final PIDTemplate SHOOTER_AIM_PID_CONSTANTS = new PIDTemplate(4, 0, 0);
    }
}
