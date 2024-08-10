import java.util.Scanner;

public class Player {

    Boards board = new Boards();
    Scanner scanner = new Scanner(System.in);

    public Player() {
        boards.initBoardA();
        boards.initBoardB();
    }

    public void fireAndAttackComp(Computer opposition, Coordinate attack) {
        board.printResult(board.resultHitMissComp(attack, opposition));
    }

    public char[][] getBoardA() {
        return board.getBoardA();
    }

    public char[][] getBoardB() {
        return board.getBoardB();
    }

    public void playerSetUp() {
        System.out.println("Prepare your fleet for battle!");
        board.printBoardA();

        /* Position your Aircraft Carrier */
        System.out.println("Your Aircraft Carrier has arrived. (Size 5)");
        System.out.println("What coordinates would you like to position the Aircraft Carrier?");
        System.out.println("Enter the the coordinate pair: 'D6'");
        int yCor = scanner.next().charAt(0);
        int xCor = scanner.next().charAt(1);

        System.out.println("What heading would you like to position the Aircraft Carrier?");
        System.out.println("Enter the Aircraft Carrier's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        char direction = scanner.next().charAt(0);

        Coordinate coord = new Coordinate(yCor, xCor);

        Ship aircraftCarrier = new Ship('A', direction, coord);
        while(board.isValidLocation(coord, aircraftCarrier) == false) {
            System.out.println("That is not a valid operating position or heading. Please order the Aircraft Carrier's position and heading again.");

            System.out.println("What coordinates would you like to position the Aircraft Carrier?");
            System.out.println("Enter the the coordinate pair: 'D6'");
            yCor = scanner.next().charAt(0);
            xCor = scanner.next().charAt(1);
            coord = new Coordinate(yCor, xCor);

            System.out.println("What heading would you like to position the Aircraft Carrier?");
            System.out.println("Enter the Aircraft Carrier's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);

        }

        board.placeShips(coord, aircraftCarrier);
        board.printBoardA();


        /* Position your Battleship */
        System.out.println("Your Battleship has arrived. (Size 4)");
        System.out.println("What coordinates would you like to position the Battleship?");
        System.out.println("Enter the the coordinate pair: 'D6'");
        yCor = scanner.next().charAt(0);
        xCor = scanner.next().charAt(1);

        System.out.println("What heading would you like to position the Battleship?");
        System.out.println("Enter the Battleship's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        direction = scanner.next().charAt(0);

        coord = new Coordinate(yCor, xCor);

        Ship battleship = new Ship('B', direction, coord);
        while(board.isValidLocation(coord, battleship) == false) {
            System.out.println("That is not a valid operating position or heading. Please order the Battleship's position and heading again.");

            System.out.println("What coordinates would you like to position the Battleship?");
            System.out.println("Enter the the coordinate pair: 'D6'");
            yCor = scanner.next().charAt(0);
            xCor = scanner.next().charAt(1);
            coord = new Coordinate(yCor, xCor);

            System.out.println("What heading would you like to position the Battleship?");
            System.out.println("Enter the Battleship's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);

        }

        board.placeShips(coord, battleship);
        board.printBoardA();

        /* Position your Destroyer */
        System.out.println("Your Destroyer has arrived. (Size 3)");
        System.out.println("What coordinates would you like to position the Destroyer?");
        System.out.println("Enter the the coordinate pair: 'D6'");
        yCor = scanner.next().charAt(0);
        xCor = scanner.next().charAt(1);

        System.out.println("What heading would you like to position the Destroyer?");
        System.out.println("Enter the Destroyer's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        direction = scanner.next().charAt(0);

        coord = new Coordinate(yCor, xCor);

        Ship destroyer = new Ship('D', direction, coord);
        while(board.isValidLocation(coord, destroyer) == false) {
            System.out.println("That is not a valid operating position or heading. Please order the Destroyer's position and heading again.");

            System.out.println("What coordinates would you like to position the Destroyer?");
            System.out.println("Enter the the coordinate pair: 'D6'");
            yCor = scanner.next().charAt(0);
            xCor = scanner.next().charAt(1);
            coord = new Coordinate(yCor, xCor);

            System.out.println("What heading would you like to position the Destroyer?");
            System.out.println("Enter the Destroyer's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);

        }

        board.placeShips(coord, destroyer);
        board.printBoardA();

        /* Position your Submarine */
        System.out.println("Your Submarine has arrived. (Size 3)");
        System.out.println("What coordinates would you like to position the Submarine?");
        System.out.println("Enter the the coordinate pair: 'D6'");
        yCor = scanner.next().charAt(0);
        xCor = scanner.next().charAt(1);

        System.out.println("What heading would you like to position the Submarine?");
        System.out.println("Enter the Submarine's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        direction = scanner.next().charAt(0);

        coord = new Coordinate(yCor, xCor);

        Ship submarine = new Ship('S', direction, coord);
        while(board.isValidLocation(coord, submarine) == false) {
            System.out.println("That is not a valid operating position or heading. Please order the Submarine's position and heading again.");

            System.out.println("What coordinates would you like to position the Submarine?");
            System.out.println("Enter the the coordinate pair: 'D6'");
            yCor = scanner.next().charAt(0);
            xCor = scanner.next().charAt(1);
            coord = new Coordinate(yCor, xCor);

            System.out.println("What heading would you like to position the Submarine?");
            System.out.println("Enter the Submarine's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);

        }

        board.placeShips(coord, submarine);
        board.printBoardA();

        /* Position your Patrol Boat */
        System.out.println("Your Patrol Boat has arrived. (Size 2)");
        System.out.println("What coordinates would you like to position the Patrol Boat?");
        System.out.println("Enter the the coordinate pair: 'D6'");
        yCor = scanner.next().charAt(0);
        xCor = scanner.next().charAt(1);

        System.out.println("What heading would you like to position the Patrol Boat?");
        System.out.println("Enter the Patrol Boat's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        direction = scanner.next().charAt(0);

        coord = new Coordinate(yCor, xCor);

        Ship patrolBoat = new Ship('P', direction, coord);
        while(board.isValidLocation(coord, patrolBoat) == false) {
            System.out.println("That is not a valid operating position or heading. Please order the Patrol Boat's position and heading again.");

            System.out.println("What coordinates would you like to position the Patrol Boat?");
            System.out.println("Enter the the coordinate pair: 'D6'");
            yCor = scanner.next().charAt(0);
            xCor = scanner.next().charAt(1);
            coord = new Coordinate(yCor, xCor);

            System.out.println("What heading would you like to position the Patrol Boat?");
            System.out.println("Enter the Patrol Boat's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);

        }

        board.placeShips(coord, patrolBoat);
        board.printBoardA();
        scanner.close();
        System.out.println("Your fleet is ready for battle!");
        

    }

    public Coordinate playerGuessAttack() {
        System.out.println("Enter the the coordinate pair for your targeted attack: 'D6'");
        int attackYCor = scanner.next().charAt(0);
        int attackXCor = scanner.next().charAt(1);
        Coordinate attack = new Coordinate(attackYCor, attackXCor);

        while (boards.isValidAttack(attack) == false) {
            System.out.println("That is not a valid target coordinate! Try again: ");
            System.out.println("Enter the the coordinate pair for your targeted attack: 'D6'");
            attackYCor = scanner.next().charAt(0);
            attackXCor = scanner.next().charAt(1);
            attack = new Coordinate(attackYCor, attackXCor);
        }

        return attack;

    }

    public void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "        ");
            }
            System.out.println();
        }

    }

    public boolean verifyPlayerWin(Computer opposition) {
        for (int i = 1; i < opposition.getBoardA().length; i++) {
            for (int j = 1; j < opposition.getBoardA()[0].length; j++) {
                if (opposition.getBoardA()[i][j] != '~' && board.getBoardB()[i][j] != 'H') {
                    return false;
                }
            }
        }
        return true;
    }
    
}
