package CodeAMonFactory;

import java.util.Random;

/**
 * CodeAMonFactory.java
 * Description: File for making deciding which CodeAMon Type is to be made.
 *      Each class is the same currently available for change in later development.
 *      This class is part of the Factory Design Pattern.
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class CodeAMonFactory {

    /**
     * createCodeAMon is a function that takes in a name and type to Factory DP.
     * @param name The name of the codeAMon to be made.
     * @param newCodeAMon Type of newCodeAMon to be made.
     * @return codeAMon object
     */
    public CodeAMon createCodeAMon(String name, Types newCodeAMon) {
        if (newCodeAMon == null) {
            Random random = new Random();
            int nextCodeAMon = random.nextInt(0, 17);
            Types nextCodeAMonType = Types.getNextType(nextCodeAMon);
            return createCodeAMon(null, nextCodeAMonType);
        }
        switch (newCodeAMon) {
            case NORMAL -> {
                return new NormalCodeAMon().makeCodeAMon(name);
            }
            case FIRE -> {
                return new FireCodeAMon().makeCodeAMon(name);
            }
            case WATER -> {
                return new WaterCodeAMon().makeCodeAMon(name);
            }
            case GRASS -> {
                return new GrassCodeAMon().makeCodeAMon(name);
            }
            case ELECTRIC -> {
                return new ElectricCodeAMon().makeCodeAMon(name);
            }
            case ICE -> {
                return new IceCodeAMon().makeCodeAMon(name);
            }
            case FIGHTING -> {
                return new FightingCodeAMon().makeCodeAMon(name);
            }
            case POISON -> {
                return new PoisonCodeAMon().makeCodeAMon(name);
            }
            case GROUND -> {
                return new GroundCodeAMon().makeCodeAMon(name);
            }
            case FLYING -> {
                return new FlyingCodeAMon().makeCodeAMon(name);
            }
            case PSYCHIC -> {
                return new PsychicCodeAMon().makeCodeAMon(name);
            }
            case BUG -> {
                return new BugCodeAMon().makeCodeAMon(name);
            }
            case ROCK -> {
                return new RockCodeAMon().makeCodeAMon(name);
            }
            case GHOST -> {
                return new GhostCodeAMon().makeCodeAMon(name);
            }
            case DRAGON -> {
                return new DragonCodeAMon().makeCodeAMon(name);
            }
            case DARK -> {
                return new DarkCodeAMon().makeCodeAMon(name);
            }
            case STEEL -> {
                return new SteelCodeAMon().makeCodeAMon(name);
            }
            case FAIRY -> {
                return new FairyCodeAMon().makeCodeAMon(name);
            }
            default -> {
                throw new IllegalArgumentException("Unknown Type Entered");
            }
        }
    }
}
