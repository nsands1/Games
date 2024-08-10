public class Coordinate {

    private int xCor; /* Number */
    private int yCor; /* Letter */

    public Coordinate() {
        yCor = 1;
        xCor = 1;
        
    }

    public Coordinate(int y, int x) {
        yCor = y;
        xCor = x;
    }

    public int getX() {
        return xCor;
    }

    public int getY() {
        return yCor;
    }

    public String toString() {
        return "(" + yCor + ", " + xCor + ")";
    }
    
}
