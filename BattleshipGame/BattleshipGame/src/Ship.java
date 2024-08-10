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
        this.setLetter(letter);
        this.setDirection(direction);
        this.setCoordinate(coord);
        this.setSize(letter);
        return;
    }

    public int getSize() {
        return size;
    }
    private void setSize(char letter) {
        switch (letter) {
            case ('A'): this.size = 5;                
                break;

            case ('B'): this.size = 4;
                break;

            case ('D'): this.size = 3;                
                break;

            case ('S'): this.size = 3;
                break;

            case ('P'): this.size = 2;
                break;

            default:
                break;
        }
    }

    public char getLetter() {
        return letter;
    }

    private void setLetter(char letter) {
        this.letter = letter;
    }

    public char getDirection() {
        return direction;
    }

    private void setDirection(char direction) {
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coord;
    }

    private void setCoordinate(Coordinate coord) {
        this.coord = coord;
    }
}
