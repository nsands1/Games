package CodeAMonFactory;

public enum Moves {

    // Default Moves
    GROWL("Growl", 0),
    SCRATCH("Scratch", 5),
    TACKLE("Tackle", 7),
    TYPEBEAM("TypeBeam", 10),

    // Evolved Moves
    ROAR("Roar", 5),
    SLASH("Slash", 11),
    SLAM("Slam", 12),
    HYPERBEAM("HyperBeam", 15);

    private final String moveName;
    private final double moveDMG;

    Moves(String moveName, double moveDMG) {
        this.moveName = moveName;
        this.moveDMG = moveDMG;
    }

    public static double getMoveDamage(Moves attackMove) {
        return attackMove.moveDMG;
    }

    public static String getMoveName(Moves attackMove) {
        return attackMove.moveName;
    }

}
