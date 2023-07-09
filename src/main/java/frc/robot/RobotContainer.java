// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.StorageConstants;
import frc.robot.commands.RotateUntilLimit;
import frc.robot.subsystems.MecanumDriveTrain;
import frc.robot.subsystems.Storage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private MecanumDriveTrain m_MecanumDriveTrain = new MecanumDriveTrain();
  private Storage m_Storage = new Storage();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  private RotateUntilLimit m_RotateUntilLimit = new RotateUntilLimit(m_Storage);
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_MecanumDriveTrain
        .setDefaultCommand(new RunCommand(() -> m_MecanumDriveTrain.move(m_driverController), m_MecanumDriveTrain));

    m_Storage.setDefaultCommand(new RunCommand(() -> m_Storage.setMotorSpeed(0), m_Storage));
  }

  private void configureBindings() {
    m_driverController.x()
        .whileTrue(new RunCommand(() -> m_Storage.setMotorSpeed(StorageConstants.kMotorSpeed), m_Storage));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
