// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ChassisConstants;


public class MecanumDriveTrain extends SubsystemBase {
  private VictorSP m_frontRightMotorController;
  private VictorSP m_rearRightMotorController;
  private VictorSP m_frontLeftMotorController;
  private VictorSP m_rearLeftMotorController;

  private MecanumDrive m_robotDrive;

  /** Creates a new MecanumDriveTrain. */
  public MecanumDriveTrain() {
    m_frontRightMotorController = new VictorSP(ChassisConstants.kFrontRightMotorControllerPort);
    m_rearRightMotorController = new VictorSP(ChassisConstants.kRearRightMotorControllerPort);
    m_frontLeftMotorController = new VictorSP(ChassisConstants.kFrontLeftMotorControllerPort);
    m_rearLeftMotorController = new VictorSP(ChassisConstants.kRearLeftMotorControllerPort);

    m_frontLeftMotorController.setInverted(true);
    m_rearLeftMotorController.setInverted(true);

    m_robotDrive = new MecanumDrive(m_frontLeftMotorController, m_rearLeftMotorController, m_frontRightMotorController, m_rearRightMotorController);
  }

  public void move(CommandXboxController controller) {
    m_robotDrive.driveCartesian(controller.getLeftX(), controller.getLeftY(), controller.getRightX());
  }  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
