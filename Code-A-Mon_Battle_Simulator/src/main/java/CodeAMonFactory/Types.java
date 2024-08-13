package CodeAMonFactory;

/**
 * Enum file Types.java
 * Description: Types Enum file for the CodeAMon types available with attackBonus values.
 * Author: nsands1@asu.edu
 * Created: 11/21/22
 * Modified: 11/21/22
 */
public enum Types {

    NORMAL (1,1,1,1,1,1,1,1,1,1,1,1,0.5,0,1,1,0.5,1),
    FIRE (1,0.5,0.5,2,1,2,1,1,1,1,1,2,0.5,1,0.5,1,2,1),
    WATER (1,2,0.5,0.5,1,1,1,1,2,1,1,1,2,1,0.5,1,1,1),
    GRASS (1,0.5,2,0.5,1,1,1,0.5,2,0.5,1,0.5,2,1,0.5,1,0.5,1),
    ELECTRIC (1,1,2,0.5,0.5,1,1,1,0,2,1,1,1,1,0.5,1,1,1),
    ICE (1,0.5,0.5,2,1,0.5,1,1,2,2,1,1,1,1,2,1,0.5,1),
    FIGHTING (2,1,1,1,1,2,1,0.5,1,0.5,0.5,0.5,2,0,1,2,2,0.5),
    POISON (1,1,1,2,1,1,1,0.5,0.5,1,1,1,0.5,0.5,1,1,0,2),
    GROUND (1,2,1,0.5,2,1,1,2,1,0,1,0.5,2,1,1,1,2,1),
    FLYING (1,1,1,2,0.5,1,2,1,1,1,1,2,0.5,1,1,1,0.5,1),
    PSYCHIC (1,1,1,1,1,1,2,2,1,1,0.5,1,1,1,1,0,0.5,1),
    BUG (1,0.5,1,2,1,1,0.5,0.5,1,0.5,2,1,1,0.5,1,2,0.5,0.5),
    ROCK (1,2,1,1,1,2,0.5,1,0.5,2,1,2,1,1,1,1,0.5,1),
    GHOST (0,1,1,1,1,1,1,1,1,1,2,1,1,2,1,0.5,1,1),
    DRAGON (1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,0.5,0),
    DARK (1,1,1,1,1,1,0.5,1,1,1,2,1,1,2,1,0.5,1,0.5),
    STEEL (1,0.5,0.5,1,0.5,2,1,1,1,1,1,1,2,1,1,1,0.5,2),
    FAIRY (1,0.5,1,1,1,1,2,0.5,1,1,1,1,1,1,2,2,0.5,1);

    private final double normalAB;
    private final double fireAB;
    private final double waterAB;
    private final double grassAB;
    private final double electricAB;
    private final double iceAB;
    private final double fightingAB;
    private final double poisonAB;
    private final double groundAB;
    private final double flyingAB;
    private final double psychicAB;
    private final double bugAB;
    private final double rockAB;
    private final double ghostAB;
    private final double dragonAB;
    private final double darkAB;
    private final double steelAB;
    private final double fairyAB;

    /**
     * Method that generates a type with the attackingBonus value against the defending type.
     * @param normalAB Double : Attack Bonus
     * @param fireAB Double : Attack Bonus
     * @param waterAB Double : Attack Bonus
     * @param grassAB Double : Attack Bonus
     * @param electricAB Double : Attack Bonus
     * @param iceAB Double : Attack Bonus
     * @param fightingAB Double : Attack Bonus
     * @param poisonAB Double : Attack Bonus
     * @param groundAB Double : Attack Bonus
     * @param flyingAB Double : Attack Bonus
     * @param psychicAB Double : Attack Bonus
     * @param bugAB Double : Attack Bonus
     * @param rockAB Double : Attack Bonus
     * @param ghostAB Double : Attack Bonus
     * @param dragonAB Double : Attack Bonus
     * @param darkAB Double : Attack Bonus
     * @param steelAB Double : Attack Bonus
     * @param fairyAB Double : Attack Bonus
     */
    Types(double normalAB, double fireAB, double waterAB, double grassAB, double electricAB, double iceAB,
          double fightingAB, double poisonAB, double groundAB, double flyingAB, double psychicAB, double bugAB,
          double rockAB, double ghostAB, double dragonAB, double darkAB, double steelAB, double fairyAB) {
        this.normalAB = normalAB;
        this.fireAB = fireAB;
        this.waterAB = waterAB;
        this.grassAB = grassAB;
        this.electricAB = electricAB;
        this.iceAB = iceAB;
        this.fightingAB = fightingAB;
        this.poisonAB = poisonAB;
        this.groundAB = groundAB;
        this.flyingAB = flyingAB;
        this.psychicAB = psychicAB;
        this.bugAB = bugAB;
        this.rockAB = rockAB;
        this.ghostAB = ghostAB;
        this.dragonAB = dragonAB;
        this.darkAB = darkAB;
        this.steelAB = steelAB;
        this.fairyAB = fairyAB;
    }

    /**
     * gets the next type from the types available.
     * @param nextCodeAMon the value for the enum type to be returned
     * @return Types
     */
    public static Types getNextType(int nextCodeAMon) {
        return Types.values(nextCodeAMon);
    }

    private static Types values(int nextCodeAMon) {
        switch (nextCodeAMon) {
            case 0 -> {
                return NORMAL;
            }
            case 1 -> {
                return FIRE;
            }
            case 2 -> {
                return WATER;
            }
            case 3 -> {
                return GRASS;
            }
            case 4 -> {
                return ELECTRIC;
            }
            case 5 -> {
                return ICE;
            }
            case 6 -> {
                return FIGHTING;
            }
            case 7 -> {
                return POISON;
            }
            case 8 -> {
                return GROUND;
            }
            case 9 -> {
                return FLYING;
            }
            case 10 -> {
                return PSYCHIC;
            }
            case 11 -> {
                return BUG;
            }
            case 12 -> {
                return ROCK;
            }
            case 13 -> {
                return GHOST;
            }
            case 14 -> {
                return DRAGON;
            }
            case 15 -> {
                return DARK;
            }
            case 16 -> {
                return STEEL;
            }
            case 17 -> {
                return FAIRY;
            }
            default -> {
                return NORMAL;
            }
        }
    }

    double getNormalAB()    { return normalAB;  }
    double getFireAB()      { return fireAB;    }
    double getWaterAB()     { return waterAB;   }
    double getGrassAB()     { return grassAB;   }
    double getElectricAB()  { return electricAB;}
    double getIceAB()       { return iceAB;     }
    double getFightingAB()  { return fightingAB;}
    double getPoisonAB()    { return poisonAB;  }
    double getGroundAB()    { return groundAB;  }
    double getFlyingAB()    { return flyingAB;  }
    double getPsychicAB()   { return psychicAB; }
    double getBugAB()       { return bugAB;     }
    double getRockAB()      { return rockAB;    }
    double getGhostAB()     { return ghostAB;   }
    double getDragonAB()    { return dragonAB;  }
    double getDarkAB()      { return darkAB;    }
    double getSteelAB()     { return steelAB;   }
    double getFairyAB()     { return fairyAB;   }

}
