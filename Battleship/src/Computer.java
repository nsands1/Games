import java.util.ArrayList;

public class Computer {

    Boards board = new Boards();
    ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
    ArrayList<Coordinate> chooseFrom = new ArrayList<Coordinate>();

    public Computer() {
        board.initBoardA();
        board.initBoardB();
    }

    public void compSetUp() {
        
        System.out.println("The enemy fleet is approaching!");

        /* Computer Aircraft Carrier */
        char randomDirection = randomDirection();
        Coordinate randomCoordinate = randomCoordinate();
        Ship aircraftCarrier = new Ship('A', randomDirection, randomCoordinate);
        while (board.isValidLocation(randomCoordinate, aircraftCarrier) == false) {
            randomCoordinate = randomCoordinate();
        }
        board.placeShips(randomCoordinate, aircraftCarrier);
        
        /* Computer Battleship */
        randomDirection = randomDirection();
        randomCoordinate = randomCoordinate();
        Ship battleship = new Ship('B', randomDirection, randomCoordinate);
        while (board.isValidLocation(randomCoordinate, battleship) == false) {
            randomCoordinate = randomCoordinate();
        }
        board.placeShips(randomCoordinate, battleship);

        /* Computer Destroyer */
        randomDirection = randomDirection();
        randomCoordinate = randomCoordinate();
        Ship destroyer = new Ship('D', randomDirection, randomCoordinate);
        while (board.isValidLocation(randomCoordinate, destroyer) == false) {
            randomCoordinate = randomCoordinate();
        }
        board.placeShips(randomCoordinate, destroyer);

        /* Computer Submarine */
        randomDirection = randomDirection();
        randomCoordinate = randomCoordinate();
        Ship submarine = new Ship('S', randomDirection, randomCoordinate);
        while (board.isValidLocation(randomCoordinate, submarine) == false) {
            randomCoordinate = randomCoordinate();
        }
        board.placeShips(randomCoordinate, submarine);

        /* Computer Patrol Boat */
        randomDirection = randomDirection();
        randomCoordinate = randomCoordinate();
        Ship patrolBoat = new Ship('P', randomDirection, randomCoordinate);
        while (board.isValidLocation(randomCoordinate, patrolBoat) == false) {
            randomCoordinate = randomCoordinate();
        }
        board.placeShips(randomCoordinate, patrolBoat);

        System.out.println("The enemy fleet is within range!\n");
        System.out.println("We'll mark the charts with an 'X' where the enemy has fired.");

    }

    public void attackPlayer(Player player, Coordinate attack) {
        printResult(board.resultHitMissPlay(attack, player));
    }

    public char[][] getBoardA() {
        return board.getBoardA();
    }

    public char[][] getBoardB() {
        return board.getBoardB();
    }

    public Coordinate getPredictedCoord(Player player) {
        Coordinate c = randomCoordinate();

        if (coord.size >= 1) {
            c = coords.get(coords.size() - 1);
            if (board.resultHitMissPlay(c, player) == 'H') {
                chooseFrom = chooseAdjacentLocations(c);
                int randNum = (int) (Math.random() * chooseFrom.size()) + 1;
                while (!board.isValidAttack(chooseFrom.get(randNum - 1)) 
                || board.getBoardB()[chooseFrom.get(randNum - 1).getY() + 1][chooseFrom.get(randNum - 1).getX() + 1] != '~') {
                    randNum = (int)(Math.random() * chooseFrom.size()) + 1;
                }

                coords.add(chooseFrom.get(randNum - 1));
                return chooseFrom.get(randNum - 1);
            }
        }
        c = randomCoordinate();
        while(!board.isValidAttack(c) || board.getBoardB()[c.getY() + 1][c.getX() + 1] != '~') {
            c = randomCoordinate();
        }

        coords.add(c);
        return c;

    }

    public void printResult(char hitOrMiss) {
        if (result == 'H') {
            System.out.println("!!BANG!!\n\nAdmiral! The enemy has hit one of our ships!");
        } else {
            System.out.println("~~ SPLASH! ~~\n\nThe enemy missed.");
        }
    }

    public char randomDirection() {
        int dirNum = (int)(Math.random() * 4) + 1;
        if (dirNum == 1) {
            return 'n';
        } else if (dirNum == 2) {
            return 's';
        } else if (dirNum == 3) {
            return 'e';
        } else {
            return 'w';
        }
    }

    public Coordinate randomCoordinate() {
        int randNum1 = (int)(Math.random() * 10);
        int randNum2 = (int)(Math.random() * 10);

        return new Coordinate(randNum1, randNum2);

    }

    public boolean verifyCompW(Player player) {
        for (int i = 1; i < player.getBoardA().length; i++) {
            for (int j = 1; j < player.getBoardA()[0].length; j++) {
                if (player.getBoardA()[i][j] != '~' && board.getBoardB()[i][j] != 'H') {
                    return false;
                }

            }
        }
        return true;

    }

    public ArrayList<Coordinate> chooseAdjacentLocations(Coordinate coord) {
        ArrayList<Coordinate> adjacentCoordinates = new ArrayList<Coordinate>();
        if (coord.getY() == 0 && coord.getX() == 0) {
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() + 1));
            adjacentCoordinates.add(new Coordinate(coord.getY() + 1, coord.getX()));
        } else if (coord.getY() == 9 && coord.getX() == 0) {
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() + 1));
            adjacentCoordinates.add(new Coordinate(coord.getY() - 1, coord.getX()));
        } else if (coord.getX() == 0) {
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() + 1));
            adjacentCoordinates.add(new Coordinate(coord.getY() + 1, coord.getX()));
            adjacentCoordinates.add(new Coordinate(coord.getY() - 1, coord.getX()));
        } else if (coord.getY() == 0 && coord.getX() == 9) {
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() - 1));
            adjacentCoordinates.add(new Coordinate(coord.getY() + 1, coord.getX()));
        } else if (coord.getY() == 9 && coord.getX() == 9) {
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() - 1));
            adjacentCoordinates.add(new Coordinate(coord.getY() - 1, coord.getX()));
        } else if (coord.getX() == 9) {
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() - 1));
            adjacentCoordinates.add(new Coordinate(coord.getY() + 1, coord.getX()));
            adjacentCoordinates.add(new Coordinate(coord.getY() - 1, coord.getX()));
        } else if (coord.getY() == 0) {
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() + 1));
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() - 1));
            adjacentCoordinates.add(new Coordinate(coord.getY() + 1, coord.getX()));
        } else if (coord.getY() == 9) {
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() + 1));
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() - 1));
            adjacentCoordinates.add(new Coordinate(coord.getY() - 1, coord.getX()));
        } else {
            adjacentCoordinates.add(new Coordinate(coord.getY() + 1, coord.getX()));
            adjacentCoordinates.add(new Coordinate(coord.getY() - 1, coord.getX()));
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() + 1));
            adjacentCoordinates.add(new Coordinate(coord.getY(), coord.getX() - 1));
        }

        return adjacentCoordinates;

    }
    

}
