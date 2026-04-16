package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class Robot extends TimedRobot {

    private PS5Controller joystick = new PS5Controller(0);

    private SparkMax motor = new SparkMax(10, SparkMax.MotorType.kBrushless);

    @Override
    public void robotInit() {
        System.out.println("Robot iniciado");

        SparkMaxConfig config = new SparkMaxConfig();
        config.idleMode(IdleMode.kBrake);
        config.inverted(false);

        motor.configure(config,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);  
    }

    @Override
    public void teleopPeriodic() {
        boolean crossButton = joystick.getCrossButton();
        boolean triangleButton = joystick.getTriangleButton();

        if (crossButton) {
            motor.set(-0.2);
        } else {
            motor.set(0);
        }

        if (triangleButton) {
            motor.set(0.2);
        } else {
            motor.set(0);
        }

        SmartDashboard.putBoolean("Cross Button", crossButton);
        SmartDashboard.putBoolean("Triangle Button", triangleButton);
        SmartDashboard.putNumber("Motor Output", motor.get());
    }
}
