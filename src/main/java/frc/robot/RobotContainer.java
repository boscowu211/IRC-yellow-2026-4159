// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.team4159.commandsv3backport.command3.Command;
import org.team4159.commandsv3backport.command3.button.CommandNiDsXboxController;

import edu.wpi.first.wpilibj.RobotController;
import frc.robot.mechanisms.Drivetrain;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
    drivetrain.setDefaultCommand(driveCommand);

  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Command.noRequirements(coroutine -> System.out.println("No autonomous command configured"))
      .named("Autonomous Command");
  }
  
  private final Drivetrain  drivetrain = new Drivetrain();
  private final CommandNiDsXboxController controller = new CommandNiDsXboxController(0);
  private final Command driveCommand = drivetrain.driveCommand(controller);
}
