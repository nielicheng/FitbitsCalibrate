# FitbitsCalibrate

### Environment required:
  - Maven: Maven2 or Maven3
  - JDK: JDK8

### Import into IDE
   This is a maven project, you can import into your IDE as Existing Maven Project

### How to build
  - Add Maven bin folder to %path% environment variable.
  -  Add JDK8 bin folder to %path% environment variable. Set JAVA_HOME environment variable to point to JDK home folder. 
  - From command line console, go to FitbitsCalibrate folder.
  - Run "mvn package" to build, test and package it. FitbitsCalibrate-1.0.jar will be generated in target folder.

### How to run
  From command line console, go to FitbitsCalibrate folder.
  Run following command
```java
java -cp ./target/FitbitsCalibrate-1.0.jar com.nie.fitbits.Main ./instructions.txt
```
### Brief of design
 * Classes and functions are properly named which are self-explained.
 * Code are properly aligned and organised so they are neat.
 * Applied Command design pattern.
 * Followed TDD.

Classes are organised in following packages:
 * com.nie.fitbits
    * Pitch : Implements the pitch of the coding problem.
    * Trainee : Implements the trainee of the coding problem.
    * DIRECTION : An enum which defines compass directions of E, N, W, S .
    * CalibrateInvoker : Implements the main logic of invoking the calibrate process.
    * Main : The main class of the application. It reads instructions from a file and call CalibrateInvoker to start the calibrate process.
 *  com.nie.fitbits.instruction : Instruction parsing class and classes which hold the parsed instruction details
    * InstructionParser : Implements instruction parsing functions.
    * CalibrateSession : Hold the parsed instructions of the whole calibrate session.
    * CalibrateInstruction : Hold all parsed instructions of one trainee.
    * PitchUpperRight : Hold parsed upper-right instruction.
    * Position : Hold parsed position (location, facing) instruction.
 *  com.nie.fitbits.command : Implements command design pattern
    * Command : Interface of all commands.
    * TurnLeftCommand : Turn left command.
    * TurnRightCommand : Turn right command.
    * MoveForwardCommand : Move forward command.
    * CommandFactory : The factory class that help generate particular command instance.
 * com.nie.fitbits.command.exception : 
    * CommandFormatException : Indicate not able to generate command due to wrong move text passed in.
 * com.nie.fitbits.instruction.exception
    * InstructionFormatException : Indicate wrong format of instruction is come across.
