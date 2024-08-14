
# Code-A-Mon Battle Simulator

This project is a Java-based battle system where a simulated `Code-A-Mon` Trainer battles with `Code-A-Mon` creatures, each having different types and moves, similar to the mechanics of Pokémon. The system is built with modular components for trainers, battles, and different `Code-A-Mon` types.

This project was completed with the purpose of learning, understanding, and then utilizing a minimum of 2 Design Patterns.  
___
### Design Patterns Used

1.  **Factory Pattern**: The Factory pattern is heavily utilized in the `CodeAMonFactory` module. This design pattern allows the creation of different types of `Code-A-Mon` objects without specifying the exact class that will be instantiated. By encapsulating the object creation logic in a factory, the code becomes more flexible and scalable, making it easy to add new `Code-A-Mon` types or modify existing ones without affecting the client code.
    
2.  **Mediator Pattern**: The `CycleMediator` module uses the Mediator pattern to manage interactions between different components, such as battles, weather conditions, and game cycles. The Mediator pattern centralizes communication between components, reducing the dependencies between them. This results in a more maintainable and loosely coupled system, where changes in one component don't directly affect others.
    
3.  **Strategy Pattern**: The Strategy pattern is implemented in the `TrainerFactory` module, where different strategies for training and battling with `Code-A-Mon` are encapsulated in separate classes (e.g., `ComputerTrainer`, `PlayerTrainer`). The Strategy pattern allows the behavior of the trainers to be selected at runtime, enabling flexibility in how trainers interact with their `Code-A-Mon` and engage in battles.
    

### How They Work Together

These design patterns work together to create a cohesive and flexible system for the `CodeAMon Battle System`. The Factory pattern ensures that the creation of `Code-A-Mon` is centralized and modular, making it easy to integrate with other parts of the system. The Mediator pattern manages the complex interactions between different game components, ensuring that the game cycle, weather, and battles are coordinated effectively. The Strategy pattern allows different trainers to adopt various behaviors during training and battles, providing flexibility and enhancing the game's dynamics. Together, these patterns contribute to a modular, maintainable, and scalable architecture, where each component is decoupled and can evolve independently.
___
## Prerequisites

Before you can run this project, you need to have the following installed:
- Java JDK 17.0.11 or higher
- Gradle 7.4.2 or higher
- Install Test Prerequisites **or** comment them out in the `build.gradle` file
___
##  Test Prerequisites (Not Required)

    ----- The following is included in the repository if correctly cloned -----

Before running the test files, SpotBugs, or StyleCheck, you must:  
 - Install the "Checkstyle for Java" extension by Sheng Chen.
 - Install the "SpotBugs" extension by Andrey Loskutov.
 > These are used in the build.gradle file and for more information on how to configure or install CheckStyle & SpotBugs review the following links [CheckStyle](https://www.youtube.com/watch?v=9CCBRzlrmTg) and [SpotBugs](https://spotbugs.readthedocs.io/en/stable/gradle.html).
___
## Project Structure

The project is organized into several modules, each responsible for different aspects of the game:

### CodeAMonFactory Module
Contains the classes related to the different types of CodeAMon and the factory pattern used to create them.

- `BugCodeAMon.java`  
- `CodeAMon.java`
- `CodeAMonFactory.java`
- `CodeAMonGenerator.java`
- `DarkCodeAMon.java`
- `DragonCodeAMon.java`
- `ElectricCodeAMon.java`
- `FairyCodeAMon.java`
- `FightingCodeAMon.java`
- `FireCodeAMon.java`
- `FlyingCodeAMon.java`
- `GhostCodeAMon.java`
- `GrassCodeAMon.java`
- `GroundCodeAMon.java`
- `IceCodeAMon.java`
- `Moves.java`
- `NormalCodeAMon.java`
- `PoisonCodeAMon.java`
- `PsychicCodeAMon.java`
- `RockCodeAMon.java`
- `SteelCodeAMon.java`
- `Types.java`
- `TypesChart.java`
- `WaterCodeAMon.java`

### CycleMediator Module
This module manages the game cycles, weather conditions, and battles.
- `Battle.java`
- `Cycle.java`
- `Weather.java`
- `WeatherList.java`

### TrainerFactory Module
This module is responsible for managing the trainers and their interactions with the CodeAMon.
- `ComputerTrainer.java`
- `PlayerTrainer.java`
- `Trainer.java`
- `TrainerFactory.java`
- `TrainerGenerator.java`

### Main and GamePlay
These are the entry point and the main game logic files.
- `GamePlay.java`
- `Main.java`

### Tests
Contains test files to ensure the functionality of the main application.
- `MainTest.java`
___
## Installation

1. **Clone the Repository**
   Clone this repository to your local machine using Git:
   ```bash
   git clone https://github.com/your-repo/codeamon-battle-system.git
   cd codeamon-battle-system 

2.  **Build the Project** Use Gradle to build the project and run tests.
    
    `./gradlew build`   **or**   `gradle build`
    
3.  **Run the Application** You can run the application using the following command:
     
    `./gradlew run`   **or**  `gradle run`
    
4.  **Run Tests** To execute the tests, run:
    
	`jacocoTestCoverageVerification - Verifies code coverage metrics based on specified rules for 	the test task. ` 
`jacocoTestReport - Generates code coverage report for the test task.  `  
`spotbugsMain - Run SpotBugs analysis for the source set 'main'  `
`spotbugsTest - Run SpotBugs analysis for the source set 'test'  `
`test - Runs the test suite. ` 

### Plugins and Tools

The project is configured with the following plugins:

-   **Checkstyle**: Ensures coding standards.
-   **SpotBugs**: Static code analysis for bug detection.
-   **PMD**: Scans the source code for potential issues.
-   **Jacoco**: Provides code coverage metrics for unit tests.
___
## Contributing

Contributions to this project are welcome. Please fork the repository and submit a pull request with your changes.
___
## License

This project is open-source and licensed under the MIT License.
___
## Contact

For any inquiries or support, please open an issue on the GitHub repository.
___
#### Markdown

This README.md file was generated with the assistance of [StackEdit](https://stackedit.io/app#).
___
## Types Chart 

![Types_Chart](https://github.com/nsands1/Games/blob/main/Code-A-Mon_Battle_Simulator/img/Type_Chart.png)

## Example Outputs

-![Example_Output_1](https://github.com/nsands1/Games/blob/main/Code-A-Mon_Battle_Simulator/img/Example_Output_1.PNG)
-![Example_Output_2](https://github.com/nsands1/Games/blob/main/Code-A-Mon_Battle_Simulator/img/Example_Output_2.PNG)
-![Example_Output_3](https://github.com/nsands1/Games/blob/main/Code-A-Mon_Battle_Simulator/img/Example_Output_3.PNG)