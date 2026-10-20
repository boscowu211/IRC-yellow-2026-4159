// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Newton;

import org.team4159.commandsv3backport.command3.Command;
import org.team4159.commandsv3backport.command3.Trigger;
import org.team4159.commandsv3backport.command3.button.CommandNiDsXboxController;

import edu.wpi.first.wpilibj.RobotController;
import frc.robot.mechanisms.Arm;
import frc.robot.mechanisms.Drivetrain;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
    drivetrain.setDefaultCommand(driveCommand);

  }

  private void configureBindings() {
    armUpButton.whileTrue(arm.liftCommand(0.25));
    armDownButton.whileTrue(arm.liftCommand(-0.25));
  }

  public Command getAutonomousCommand() {
    return Command.noRequirements(coroutine -> System.out.println("No autonomous command configured"))
      .named("Autonomous Command");
  }
  
  private final Drivetrain  drivetrain = new Drivetrain();
  private final CommandNiDsXboxController controller = new CommandNiDsXboxController(0);
  private final Command driveCommand = drivetrain.driveCommand(controller);
  private final Arm arm = new Arm();
  private final Trigger armUpButton = controller.rightTrigger();
   private final Trigger armDownButton = controller.rightBumper();
}
