/*************************************************************************************************
 * File: Coordinate.java
 * 
 * Description: This file contains the Coordinate class which is used to 
 *              represent the coordinates on a Battleship game board. 
 *              Coordinates consist of a vertical component (yCor) represented
 *              by letters ('A' to 'J') and a horizontal component (xCor)
 *              represented by numbers (1 to 10). This class provides methods
 *              to access these properties and a method to convert them to 
 *              a string format for easy display.
 *
 * Author: Neil S.
 * Date Created: August 2nd 2024
 * Date Last Edited: August 11th 2024
 ************************************************************************************************/

public class Coordinate {

    private char yCor; /* Letter */
    private int xCor; /* Number */
    
    public Coordinate() {
        yCor = ' ';
        xCor = 0;
    }

    public Coordinate(char y, int x) {
        yCor = y;
        xCor = x;
    }

    public char getY() {
        return yCor;
    }    
    
    public int getX() {
        return xCor;
    }

    public String toString() {
        return "(" + yCor + ", " + xCor + ")";
    }
    
}
