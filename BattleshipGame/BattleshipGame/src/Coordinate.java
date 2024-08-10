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
