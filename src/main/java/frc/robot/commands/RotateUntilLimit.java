// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.StorageConstants;
import frc.robot.subsystems.Storage;

public class RotateUntilLimit extends CommandBase {
  private Storage m_Storage;
  /** Creates a new RotateUntilLimit. */
  public RotateUntilLimit(Storage storage) {
    m_Storage = storage;
    addRequirements(m_Storage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Storage.setMotorSpeed(StorageConstants.kMotorSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Storage.setMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_Storage.getLimitSwitchValue();
  }
}
