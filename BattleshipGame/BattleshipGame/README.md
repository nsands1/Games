# Battleship Game
Welcome to the Battleship Game project! This Java application simulates a classic Battleship game where you strategically place ships on a grid and attempt to sink your opponent's fleet before they sink yours.

## Prerequisites

Before you can run this project, you need to have the following installed:
- Java JDK 17.0.11 or higher

- Visual Studio Code (or preferred IDE)

- Java extension for Visual Studio Code (e.g., Extension Pack for Java, Java Compiler)

## Installation

1.  **Clone the Repository**

> Clone this repository to your local machine using Git:
> git clone https://github.com/nsands1/Games/tree/main/BattleshipGame/.git

2. **Open the Project**

3. **Running the Game**
>To run the game in Visual Studio Code, follow these steps:
>>Configure the Java Environment
>>Ensure that Visual Studio Code is using the correct version of Java. You can check and select the JDK by clicking on the Java version displayed in the bottom right corner of the status bar.
>>Build the Project
>>Run the Application

## Game Instructions

### Start the Game

The game starts by asking you to place your ships on the grid. Follow the prompts to select the coordinates and heading (north, south, east, or west) for each ship. Enter the coordinates as seen on the board. The heading will position the front of the ship in that direction placing the remainder behind the front.

### Play the Game

After setting up the board, you will alternate turns with the computer, choosing coordinates to attack. The goal is to sink all of the opponent's ships before they sink yours.

### Winning the Game

The game ends when all ships of either player are sunk. The program will announce the winner.

### Features

- Full simulation of the Battleship game.
- Simple console-based UI.
- Single player gameplay against a computer opponent.
- Computer difficulty is moderate. Computer will target adjacent spaces to hits.

## Contributing

Contributions to this project are welcome. Contact owner for permissions. Please fork the repository and submit a pull request with your enhancements.
  
## License

This project is open-source.  

## Contact

For support or to contact the developer, please visit the GitHub issues page for this repository.

This README provides a complete guide from setup to gameplay, making it easier for new users to get started with the game.

## Folder Structure

The workspace contains folders by default, where:

-  `src`: the folder to maintain sources

-  `lib`: the folder to maintain dependencies

-  `img`: the folder to maintain UML Diagrams

Meanwhile, the compiled output files will be generated in the `bin` folder by default.
- Customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## UML diagrams
See the `img` folder to review the basic UML diagrams used for planning this project.  
The MSPPT file has been included in the repository if contributors so choose to make adjustments.

#### Markdown 
This README.md file was generated with the assistance of [StackEdit](https://stackedit.io/app#).
