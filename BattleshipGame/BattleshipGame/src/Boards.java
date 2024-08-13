/*************************************************************************************************
 * File: Boards.java
 * 
 * Description: This file contains the implementation of the Boards class, 
 *              which is responsible for managing the game boards in the 
 *              Battleship game. The class includes methods for initializing 
 *              the boards, placing ships, verifying attacks, and tracking 
 *              hits and misses. It also manages the state of both the player's 
 *              and computer's fleets, keeping track of the number of ships 
 *              that have been hit or sunk.
 *
 * Author: Neil S.
 * Date Created: August 2nd 2024
 * Date Last Edited: August 11th 2024
 ************************************************************************************************/
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

    public int getNumAircraftPlay() {
        return numAircraftPlay;
    }

    public int getNumBattleshipPlay() {
        return numBattleshipPlay;
    }

    public int getNumDestroyerPlay() {
        return numDestroyerPlay;
    }

    public int getNumSubmarinePlay() {
        return numSubmarinePlay;
    }

    public int getNumPatrolBoatPlay() {
        return numPatrolBoatPlay;
    }

    public int getNumAircraftComp() {
        return numAircraftComp;
    }

    public int getNumBattleshipComp() {
        return numBattleshipComp;
    }

    public int getNumDestroyerComp() {
        return numDestroyerComp;
    }

    public int getNumSubmarineComp() {
        return numSubmarineComp;
    }

    public int getNumPatrolBoatComp() {
        return numPatrolBoatComp;
    }

    public void initBoardA() {
        boardA[0][0] = ' ';
        int num = 1;
        /* Initialize First Column (65 = ASCII A)*/
        for(int i = 65; i <= 74; i++) {
            boardA[num][0] = (char) i;
            num++;
        }

        /* Initialize First Row */
        num = 1;
        for(int i = 49; i <= 57; i++) {
            boardA[0][num] = (char) i;
            num++;
        }
        boardA[0][num] = (char)('A');


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
        for(int i = 65; i <= 74; i++) {
            boardB[num][0] = (char) i;
            num++;
        }

        /* Initialize First Row */
        num = 1;
        for(char i = 49; i <= 57; i++) {
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
        try {
            char yCor = coord.getY();
            int xCor = coord.getX();

            if(xCor < 1 || xCor > 10) {
                return false;
            }
            if(yCor < 'A' || yCor > 'J') {
                return false;
            }
            if (this.boardB[(yCor - 64)][xCor] == 'M') {
                return false;
            }
            if (this.boardB[(yCor - 64)][xCor] != '~') {
                return false;
            }
        } catch (Exception ArrayIndexOutOfBoundsException) {
            return false;
        }
        return true;
    }

    public boolean isValidLocation(Coordinate coord, Ship ship) {
        int yCor = coord.getY() - 64;
        int xCor = coord.getX();
        
        if (xCor < 1 || xCor > 10) {
            return false;
        }

        if (yCor < 1 || yCor > 10) {
            return false;
        }

        if (boardA[yCor][xCor] != '~') {
            return false;
        }

        int size = ship.getSize() - 1;
        char direction = ship.getDirection();

        switch (direction) {
            case ('n'):
                /* Check for enough space behind ship on the board */
                try {
                    if (yCor + size > 10) {
                        return false;
                    }
                    /* Check for '~' space behind ship on the board */
                    while (size != 0) {
                        if (boardA[yCor + size][xCor] != '~') {
                            return false;
                        }
                        size--;
                    }
                } catch (Exception ArrayIndexOutOfBoundsException) {
                    return false;
                }
                
                break;

            case ('s'):
                /* Check for enough space behind ship on the board */
                try {
                    if (yCor - size < 1) {
                        return false;
                    }
                    /* Check for '~' space behind ship on the board */
                    while (size != 0) {
                        if (boardA[yCor - size][xCor] != '~') {
                            return false;
                        }
                        size--;
                    }
                } catch (Exception ArrayIndexOutOfBoundsException) {
                    return false;
                }
            
                break;

            case ('e'):
                /* Check for enough space behind ship on the board */
                try {
                    if (xCor - size < 1) {
                        return false;
                    }
                    /* Check for '~' space behind ship on the board */
                    while (size != 0) {
                        if (boardA[yCor][xCor - size] != '~') {
                            return false;
                        }
                        size--;
                    }
                } catch (Exception ArrayIndexOutOfBoundsException) {
                    return false;
                }
            
                break;

            case ('w'):
                /* Check for enough space behind ship on the board */
                try {
                    if (xCor + size > 10) {
                        return false;
                    }
                    /* Check for '~' space behind ship on the board */
                    while (size != 0) {
                        if (boardA[yCor][xCor + size] != '~') {
                            return false;
                        }
                        size--;
                    }
                } catch (Exception ArrayIndexOutOfBoundsException) {
                    return false;
                }
            
                break;
            }
        return true;
    }

    public boolean placeShips(Coordinate coord, Ship ship) {
        int yCor = coord.getY() - 64;
        int xCor = coord.getX();

        boardA[yCor][xCor] = ship.getLetter();
        char direction = ship.getDirection();
        int size = ship.getSize() - 1;
        char letter = ship.getLetter();

        switch (direction) {
            case ('n'):
                while (size != 0) {
                    boardA[yCor + size][xCor] = letter;
                    size--;
                }           
                break;

            case ('s'):
                while (size != 0) {
                    boardA[yCor - size][xCor] = letter;
                    size--;
                }              
                break;

            case ('e'):
                while (size != 0) {
                    boardA[yCor][xCor - size] = letter;
                    size--;
                }              
                break;

            case ('w'):
                while (size != 0) {
                    boardA[yCor][xCor + size] = letter;
                    size--;
                }
        }
        return true;
    }

    public void printBoardA() {
        int counter = 0;
        for (int i = 0; i < boardA.length; i++) {
            for (int j = 0; j < boardA.length; j++) {
                if ((boardA[0][j]) == 'A' && counter == 0) {
                    System.out.print("10");
                    counter++;                    
                } else {
                    System.out.print(boardA[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public void printBoardB() {
        int counter = 0;
        for (int i = 0; i < boardB.length; i++) {
            for (int j = 0; j < boardB.length; j++) {
                if ((boardA[0][j]) == 'A' && counter == 0) {
                    System.out.print("10");
                    counter++;                    
                } else {
                    System.out.print(boardB[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public void printResult(char result) {
        if (result == 'M') {
            System.out.println("~~ SPLASH! ~~\n");
        }
        if (result == 'H') {
            System.out.println("~~ BANG! ~~\n");
        } 
    }

    public char resultHitMissComp(Coordinate coord, Computer opposition) {
        int yCor = coord.getY() - 64;
        int xCor = coord.getX();
        
        char target = opposition.getBoardA()[yCor][xCor];
        switch (target) {
            case ('A'):
                numAircraftComp++;
                if (numAircraftComp == 5) {
                    System.out.println("You sunk the enemy Aircraft Carrier!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            case ('B'):
                numBattleshipComp++;
                if (numBattleshipComp == 4) {
                    System.out.println("You sunk the enemy Battleship!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            case ('D'):
                numDestroyerComp++;
                if (numDestroyerComp == 3) {
                    System.out.println("You sunk the enemy Destroyer!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            case ('S'):
                numSubmarineComp++;
                if (numSubmarineComp == 3) {
                    System.out.println("You sunk the enemy Submarine!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            case ('P'):
                numPatrolBoatComp++;
                if (numPatrolBoatComp == 2) {
                    System.out.println("You sunk the enemy Patrol Boat!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            default:
                this.getBoardB()[yCor][xCor] = 'M';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'M';
        }

    }

    public char resultHitMissPlay(Coordinate coord, Player opposition) {
        int yCor = coord.getY() - 64;
        int xCor = coord.getX();

        char target = opposition.getBoardA()[yCor][xCor];
        switch (target) {
            case ('A'):
                numAircraftPlay++;
                if (numAircraftPlay == 5) {
                    System.out.println("The enemey sunk your Aircraft Carrier!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            case ('B'):
                numBattleshipPlay++;
                if (numBattleshipPlay == 4) {
                    System.out.println("The enemey sunk your Battleship!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            case ('D'):
                numDestroyerPlay++;
                if (numDestroyerPlay == 3) {
                    System.out.println("The enemey sunk your Destroyer!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            case ('S'):
                numSubmarinePlay++;
                if (numSubmarinePlay == 3) {
                    System.out.println("The enemey sunk your Submarine!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            case ('P'):
                numPatrolBoatPlay++;
                if (numPatrolBoatPlay == 2) {
                    System.out.println("The enemey sunk your Patrol Boat!");
                }
                this.getBoardB()[yCor][xCor] = 'H';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'H';
            default:
                this.getBoardB()[yCor][xCor] = 'M';
                opposition.getBoardA()[yCor][xCor] = 'X';
                return 'M';
        }
    }

}