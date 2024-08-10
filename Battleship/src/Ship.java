public class Ship {
    
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

    private int size;
    private char letter;
    private char direction;
    private Coordinate coord;

    public Ship (char letter, char direction, Coordinate coord) {
        switch (letter) {
            case ('A'): size = 5;                
                break;

            case ('B'): size = 4;
                break;

            case ('D'): size = 3;                
                break;

            case ('S'): size = 3;
                break;

            case ('P'): size = 2;
                break;

            default:
                break;
        }
    }

    public int getSize() {
        return size;
    }

    public char getLetter() {
        return letter;
    }

    public char getDirection() {
        return direction;
    }

    public Coordinate getCoordinate() {
        return coord;
    }
}
