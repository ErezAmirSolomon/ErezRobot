// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OShoot;
import frc.robot.Constants.ShooterConstants;

public class ShootBalls extends CommandBase {
  private OShoot m_OShoot;

  /** Creates a new ShootBalls. */
  public ShootBalls(OShoot oshoot) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_OShoot = oshoot;
    addRequirements(m_OShoot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_OShoot.setShooterMotorSpeed(ShooterConstants.kShooterMotorControllerSpeed);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_OShoot.setShooterMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
