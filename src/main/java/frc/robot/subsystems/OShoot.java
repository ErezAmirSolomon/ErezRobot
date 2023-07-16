// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;


public class OShoot extends SubsystemBase {
  private VictorSP m_shooterMotorController;

  /** Creates a new OShoot. */
  public OShoot() {
    m_shooterMotorController = new VictorSP(ShooterConstants.kShooterMotorControllerPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void setShooterMotorSpeed(int motorSpeed) {
    m_shooterMotorController.set(motorSpeed);
  }
}
