public class Boards {

    private char[][] boardA = new char[11][11];
    private char[][] boardB = new char[11][11];

    private int numAircraftPlay = 0;
    private int numBattleshipPlay = 0;
    private int numDestroyerPlay = 0;
    private int numSubmarinePlay = 0;
    private int numPatrolBoatPlay = 0;

    private int numAircraftComp = 0;
    private int numBattleshipComp = 0;
    private int numDestroyerComp = 0;
    private int numSubmarineComp = 0;
    private int numPatrolBoatComp = 0;
    
    public Boards() {
        initBoardA();
        initBoardB();
    }

    public void initBoardA() {
        boardA[0][0] = ' ';
        int num = 1;
        /* Initialize First Column (char 48 = ASCII 1)*/
        for(int i = 65; i <= 74; i++) {
            boardA[num][0] = (char) i;
            num++;
        }

        /* Initialize First Row */
        num = 1;
        for(char i = 1; i <= 10; i++) {
            boardA[0][num] = i;
            num++;
        }

        /* Initialize The Remaining Board */
        for(int i = 1; i < boardA.length; i++) {
            for(int j = 1; j < boardA[0].length; j++) {
                boardA[i][j] = '~';
            }
        }
    }

    public void initBoardB() {
        boardB[0][0] = ' ';
        int num = 1;
        /* Initialize First Column */
        for(int i = 48; i <= 57; i++) {
            boardB[num][0] = (char) i;
            num++;
        }

        /* Initialize First Row */
        num = 1;
        for(char i = 48; i <= 57; i++) {
            boardB[0][num] = i;
            num++;
        }

        /* Initialize The Remaining Board */
        for(int i = 1; i < boardB.length; i++) {
            for(int j = 1; j < boardB[0].length; j++) {
                boardB[i][j] = '~';
            }
        }
    }

    public char[][] getBoardA() {
        return boardA;
    }

    public char[][] getBoardB() {
        return boardB;
    }

    public boolean isValidAttack(Coordinate coord) {
        int yCor = coord.getY() + 1;
        int xCor = coord.getX() + 1;

        if(xCor < 1 || xCor >= boardA[0].length) {
            return false;
        }
        if(yCor < 1 || yCor >= boardA.length) {
            return false;
        }
        return true;
    }

    public boolean isValidLocation(Coordinate coord, Ship ship) {
        int xCor = coord.getX() + 1;
        int yCor = coord.getY() + 1;

        if (xCor < 1 || xCor >= boardA[0].length) {
            return false;
        }

        if (yCor < 1 || yCor >= boardA.length) {
            return false;
        }

        switch (direction = ship.getDirection()) {
            case (direction == 'n'):
                if (yCor - (ship.getSize() + 1 ) < 1) {
                    return false;
                }
                for (int i = yCor; i > yCor - ship.getSize(); i--) {
                    if (boardA[i][xCor] != '~') {
                        return false;
                    }
                }
                break;
            case (direction == 's'):
                if (yCor + (ship.getSize() + 1 ) >= boardA.length) {
                    return false;
                }
                for (int i = yCor; i <= yCor + (ship.getSize() - 1); i++) {
                    if (boardA[i][xCor] != '~') {
                        return false;
                    }
                }
                break;
            case (direction == 'e'):
                if (xCor + (ship.getSize() - 1 ) >= boardA[0].length) {
                    return false;
                }
                for (int i = xCor; i <= xCor + (ship.getSize() - 1); i++) {
                    if (boardA[yCor][i] != '~') {
                        return false;
                    }
                }
                break;
            case (direction == 'w'):
                if (xCor - (ship.getSize() + 1 ) < 1) {
                    return false;
                }
                for (int i = xCor; i > xCor - ship.getSize(); i--) {
                    if (boardA[yCor][i] != '~') {
                        return false;
                    }
                }
                break;
            default : return true;
        }
    }
    /* North : n, South : s, East : e, West : w */
    public boolean placeShips(Coordinate coord, Ship ship) {
        int yCor = coord.getY() + 1;
        int xCor = coord.getX() + 1;

        boardA[yCor][xCor] = ship.getLetter();

        switch (direction = ship.getDirection()) {
            case (direction == 'n'):
                for (int i = yCor; i >= yCor - (ship.getSize() - 1); i--) {
                    boardA[i][xCor] = s.getLetter();
                }                
                break;
            case (direction == 's'):
                for (int i = yCor; i <= yCor + (ship.getSize() - 1); i++) {
                    boardA[i][xCor] = s.getLetter();
                }                
                break;
            case (direction == 'e'):
                for (int i = xCor; i >= xCor - (ship.getSize() - 1); i--) {
                    boardA[yCor][i] = s.getLetter();
                }                
                break;
            case (direction == 'w'):
                for (int i = xCor; i <= xCor + (ship.getSize() - 1); i++) {
                    boardA[yCor][i] = s.getLetter();
                }                
                break;
            default:
                break;
        }

    }

    public void printBoardA() {
        for (int i = 0; i < boardA.length; i++) {
            for (int j = 0; j < boardA.length; j++) {
                System.out.print(boardA[i][j] + "        ");
            }
            System.out.println();
        }
    }

    public void printBoardB() {
        for (int i = 0; i < boardB.length; i++) {
            for (int j = 0; j < boardB.length; j++) {
                System.out.print(boardB[i][j] + "        ");
            }
            System.out.println();
        }    
    }

    public void printResult(char result) {
        if (result == 'M') {
            System.out.println("~~ SPLASH! ~~\n");
        } 

    }
    /*
     * 
     * Aircraft Carrier is of size 5 represented by the letter "A"
     * 
     * Battleship is of size 4 represented by the letter "B"
     * 
     * Destroyer is of size 3 represented by the letter "D"
     * 
     * Submarine is of size 3 represented by the letter "S"
     * 
     * Patrol Boat is of size 2 represented by the letter "P"
     * 
     */
    public char resultHitMissComp(Coordinate coord, Computer opposition) {
        int yCor = coord.getY() + 1;
        int xCor = coord.getX() + 1;
        
        switch (target = opposition.getBoardA[yCor][xCor]) {
            case (target == 'A'):
                numAircraftComp++;
                if (numAircraftComp == 5) {
                    System.out.println("You sunk the enemy Aircraft Carrier!");
                }
                break;
            case (target == 'B'):
                numBattleshipComp++;
                if (numBattleshipComp == 4) {
                    System.out.println("You sunk the enemy Battleship!");
                }
                break;
            case (target == 'D'):
                numDestroyerComp++;
                if (numDestroyerComp == 3) {
                    System.out.println("You sunk the enemy Destroyer!");
                }
                break;
            case (target == 'S'):
                numSubmarineComp++;
                if (numSubmarineComp == 3) {
                    System.out.println("You sunk the enemy Submarine!");
                }
                break;
            case (target == 'P'):
                numPatrolBoatComp++;
                if (numSubmarineComp == 2) {
                    System.out.println("You sunk the enemy Patrol Boat!");
                }
                break;
            default:
                break;
        }

        if (opposition.getBoardA()[yCor][xCor] != '~') {
            this.getBoardB()[yCor][xCor] = 'H';
            opposition.getBoardA()[yCor][xCor] = 'X';
            return 'H';
        }

        this.getBoardB()[yCor][xCor] = 'M';
        return 'M';

    }

    public char resultHitMissPlay(Coordinate coord, Player opposition) {
        int yCor = coord.getY() + 1;
        int xCor = coord.getX() + 1;
        
        switch (target = opposition.getBoardA[yCor][xCor]) {
            case (target == 'A'):
                numAircraftPlay++;
                if (numAircraftPlay == 5) {
                    System.out.println("The enemey sunk the your Aircraft Carrier!");
                }
                break;
            case (target == 'B'):
                numBattleshipPlay++;
                if (numBattleshipPlay == 4) {
                    System.out.println("The enemey sunk the your Battleship!");
                }
                break;
            case (target == 'D'):
                numDestroyerPlay++;
                if (numDestroyerPlay == 3) {
                    System.out.println("The enemey sunk the your Destroyer!");
                }
                break;
            case (target == 'S'):
                numSubmarinePlay++;
                if (numSubmarinePlay == 3) {
                    System.out.println("The enemey sunk the your Submarine!");
                }
                break;
            case (target == 'P'):
                numPatrolBoatPlay++;
                if (numSubmarinePlay == 2) {
                    System.out.println("The enemey sunk the your Patrol Boat!");
                }
                break;
            default:
                break;
        }

        if (opposition.getBoardA()[yCor][xCor] != '~') {
            this.getBoardB()[yCor][xCor] = 'H';
            opposition.getBoardA()[yCor][xCor] = 'X';
            return 'H';
        }

        this.getBoardB()[yCor][xCor] = 'M';
        return 'M';

    }

}