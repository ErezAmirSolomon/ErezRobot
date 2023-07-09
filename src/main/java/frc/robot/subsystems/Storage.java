// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.StorageConstants;

public class Storage extends SubsystemBase {
  private VictorSP m_storageMotorController;

  private DigitalInput m_limitswitch;


  /** Creates a new Storage. */
  public Storage() {
    m_storageMotorController = new VictorSP(StorageConstants.kStorageMotorControllerPort);

    m_limitswitch = new DigitalInput(StorageConstants.kLimitSwitchPort);
  }

  public void getLimitSwitchValue() {
    m_limitswitch.get();
  }

  public void setMotorSpeed(double motorSpeed) {
    m_storageMotorController.set(motorSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

