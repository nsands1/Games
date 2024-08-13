
# Random Maze Generator

Welcome to the Random Maze Generator project! This Java application generates a solvable maze using a depth-first search (DFS) algorithm with a stack for backtracking. The maze is created by randomly choosing directions to move and backtracking when no unvisited cells are available. The result is a fully utilized maze grid with a single solvable path from start (S) to finish (F).

## Prerequisites

Before you can run this project, you need to have the following installed:
- Java JDK 17.0.11 or higher
- Visual Studio Code (or preferred IDE)
- Java extension for Visual Studio Code (e.g., Extension Pack for Java, Java Compiler)

## Installation

1.  **Clone the Repository**

   >Clone this repository to your local machine using Git:
   `git clone https://github.com/nsands1/Games/tree/main/RandomMazeGenerator.git` 

2.  **Open the Project**
    
   > Open the cloned project in your IDE of choice.
    
3.  **Running the Maze Generator**
    
  >To run the maze generator in Visual Studio Code, follow these steps:
    
  >> **Configure the Java Environment**:  
  >>> Ensure that Visual Studio Code is using the correct version of Java. You can check and select the JDK by clicking on the Java version displayed in the bottom right corner of the status bar.  

>>**Build the Project**: 
>>>Compile the `SandsMazeGen.java` file using the terminal or built-in build tools in your IDE.  

>>**Run the Application**: 
>>>Execute the generated `.class` file to see the maze output.

**Alternatively**, use the following command line to compile and run the application, where `file_source_path` is the location of the SandsMazeGen.java file:
    
    
   `cd"\file_source_path\" ; if ($?) { javac SandsMazeGen.java } ; if ($?) { java SandsMazeGen }` 
    

## Maze Generator Instructions

### Start the Program

The program generates a maze with dimensions defined by `LEVEL_HEIGHT` and `LEVEL_WIDTH`. The start (`S`) and finish (`F`) points are randomly placed on the maze's perimeter.

### Maze Generation

The maze is generated using a DFS algorithm with backtracking, ensuring that the entire grid is utilized. The generated maze will always have a single solvable path from start to finish, with additional dead-ends and branches to increase complexity.

### Features

-   Fully random maze generation.
-   Single solvable path from start to finish.
-   Utilizes programming fundamentals of DFS and Stacks.
-   Utilizes the entire grid with complex paths and dead-ends.
-   Increasing size parameters makes the maze more complex.

## Contributing

Contributions to this project are welcome. Please fork the repository and submit a pull request with your enhancements.

## License

This project is open-source.

## Contact

For support or to contact the developer, please visit the GitHub issues page for this repository.

This README provides a complete guide from setup to execution, making it easier for new users to get started with the maze generator.

## Folder Structure

The workspace contains the following folders by default:

-   `src`: the folder to maintain sources
-   `lib`: the folder to maintain dependencies
-  `img`: the folder to showcase examples of random mazes

Meanwhile, the compiled output files will be generated in the `bin` folder by default. Customize the folder structure by opening `.vscode/settings.json` and updating the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

#### Markdown

This README.md file was generated with the assistance of StackEdit.

## Example Mazes 

![Example_1](https://github.com/nsands1/Games/blob/main/RandomMazeGenerator/img/Example_1.PNG)
 ____
![Example_2](https://github.com/nsands1/Games/blob/main/RandomMazeGenerator/img/Example_2.PNG)
 ____
![Example_3](https://github.com/nsands1/Games/blob/main/RandomMazeGenerator/img/Example_3.PNG)