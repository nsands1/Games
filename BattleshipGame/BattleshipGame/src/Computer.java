/*************************************************************************************************
 * File: Computer.java
 * 
 * Description: This file contains the implementation of the Computer class
 *              for a Battleship game. It handles computer-controlled ship 
 *              placement, attack logic, and maintains the state of chosen 
 *              and next possible coordinates. It also manages the evaluation
 *              of game outcomes based on the computer's actions.
 *
 * Author: Neil S.
 * Date Created: August 2nd 2024
 * Date Last Edited: August 11th 2024
 ************************************************************************************************/

import java.util.ArrayList;
import java.util.Random;

public class Computer {

    Boards board = new Boards();
    ArrayList<Coordinate> coordsChosen = new ArrayList<Coordinate>();
    ArrayList<Coordinate> chooseNext = new ArrayList<Coordinate>();
    Coordinate initAttackHit = new Coordinate();
    Coordinate compAttack = new Coordinate();

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
        char result = board.resultHitMissPlay(attack, player);
        if (result == 'H') {
            if (chooseNext.isEmpty()) {
                initAttackHit = attack;
                chooseAdjacentLocations(compAttack);
                board.printResult(result);
                return;
            }
            chooseNext.removeAll(chooseNext);
            chooseAdjacentLocations(compAttack);
            board.printResult(result);
            return;
        }
        if (chooseNext.isEmpty()) {
            board.printResult(result);
            return;
        }
        chooseNext.remove(compAttack);
        chooseAdjacentLocations(initAttackHit);
        board.printResult(result);
        return;
    }

    private void removeDuplicates() {
        for (int i = 0; i < this.coordsChosen.size(); i++) {
            Coordinate coord = this.coordsChosen.get(i);
            for (int j = 0; j < this.chooseNext.size(); j++) {
                if (coord == this.chooseNext.get(j)) {
                    this.chooseNext.remove(coord);
                }
            }
        }
    }

    public char[][] getBoardA() {
        return board.getBoardA();
    }

    public char[][] getBoardB() {
        return board.getBoardB();
    }

    public Coordinate getPredictedCoord(Player player) {
        while (!chooseNext.isEmpty()) {
            int randNum = (int)(Math.random() * chooseNext.size());
            compAttack = chooseNext.get(randNum);

            if (board.isValidAttack(compAttack)) {
                coordsChosen.add(compAttack);
                return compAttack;
            } else {
                chooseNext.remove(randNum);
            }
        }

        do {
            compAttack = randomCoordinate();
        } while (!board.isValidAttack(compAttack));

        coordsChosen.add(compAttack);
        return compAttack;
    }

    public void printResult(char hitOrMiss) {
        if (hitOrMiss == 'H') {
            System.out.println("\n!!BANG!!\n\nAdmiral! The enemy has hit one of our ships!");
        } else {
            System.out.println("\n~~ SPLASH! ~~\n\nThe enemy missed.");
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
        Random r = new Random();
        char randYCoord = (char)(r.nextInt(10) + 'A');
        int randXCoord = (r.nextInt(10) + 1);
        return new Coordinate(randYCoord, randXCoord);
    }

    public boolean verifyCompWin() {
        if (board.getNumAircraftPlay() == 5 && board.getNumBattleshipPlay() == 4 && 
            board.getNumDestroyerPlay() == 3 && board.getNumSubmarinePlay() == 3 && 
            board.getNumPatrolBoatPlay() == 2) {
            return true;
        }
        return false;
    }

    public void chooseAdjacentLocations(Coordinate coord) {
        int yCor = coord.getY() - 64;
        int yCorToChar = coord.getY();
        int xCor = coord.getX();
        if (yCor == 1 && xCor == 1) {
            chooseNext.add(new Coordinate((char)yCor, xCor + 1));
            chooseNext.add(new Coordinate((char)(yCor + 1), xCor));
        } else if (yCor == 10 && xCor == 1) {
            chooseNext.add(new Coordinate((char)yCorToChar, xCor + 1));
            chooseNext.add(new Coordinate((char)(yCorToChar - 1), xCor));
        } else if (xCor == 1) {
            chooseNext.add(new Coordinate((char)yCorToChar, xCor + 1));
            chooseNext.add(new Coordinate((char)(yCorToChar + 1), xCor));
            chooseNext.add(new Coordinate((char)(yCorToChar - 1), xCor));
        } else if (yCor == 1 && xCor == 10) {
            chooseNext.add(new Coordinate((char)yCorToChar, xCor - 1));
            chooseNext.add(new Coordinate((char)(yCorToChar + 1), xCor));
        } else if (yCor == 10 && xCor == 10) {
            chooseNext.add(new Coordinate((char)yCorToChar, xCor - 1));
            chooseNext.add(new Coordinate((char)(yCorToChar - 1), xCor));
        } else if (xCor == 10) {
            chooseNext.add(new Coordinate((char)yCorToChar, xCor - 1));
            chooseNext.add(new Coordinate((char)(yCorToChar + 1), xCor));
            chooseNext.add(new Coordinate((char)(yCorToChar - 1), xCor));
        } else if (yCor == 1) {
            chooseNext.add(new Coordinate((char)yCorToChar, xCor + 1));
            chooseNext.add(new Coordinate((char)yCorToChar, xCor - 1));
            chooseNext.add(new Coordinate((char)(yCorToChar + 1), xCor));
        } else if (yCor == 10) {
            chooseNext.add(new Coordinate((char)yCorToChar, xCor + 1));
            chooseNext.add(new Coordinate((char)yCorToChar, xCor - 1));
            chooseNext.add(new Coordinate((char)(yCorToChar - 1), xCor));
        } else {
            chooseNext.add(new Coordinate((char)(yCorToChar + 1), xCor));
            chooseNext.add(new Coordinate((char)(yCorToChar - 1), xCor));
            chooseNext.add(new Coordinate((char)yCorToChar, xCor + 1));
            chooseNext.add(new Coordinate((char)yCorToChar, xCor - 1));
        }

        removeDuplicates();

    }

}
