package CodeAMonFactory;

import java.util.ArrayList;

import static CodeAMonFactory.Moves.*;

/**
 * CodeAMon.java
 * Description: File for making CodeAMon including their Stats and Moves.
 * This class is part of the Factory Design Pattern.
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class CodeAMon {

    String name = "";   //Name of CodeAMon
    Types type;         //CodeAMon Type
    int hP = 25;        //Health Points
    int lvl = 1;        //Level
    int exp = 0;        //Experience
    int def = 0;        //Defense
    double spd = 0.0;   //Speed
    int pPL = 100;      //Points Per Level
    boolean evolved = false;
    public ArrayList<Moves> Moves_List = new ArrayList<>(4);

    //Default CodeAMon "Bob-o-Mon" is of Type NORMAL.
    public CodeAMon Stats() {
        this.name = "Bob-o-Mon";
        this.type = Types.NORMAL;
        this.hP = 30;
        this.lvl = 1;
        this.exp = 0;
        this.def = 10;
        this.spd = 5.5;
        this.pPL = 100;
        this.evolved = false;
        this.Moves_List.add(GROWL);
        this.Moves_List.add(SCRATCH);
        this.Moves_List.add(TACKLE);
        this.Moves_List.add(TYPEBEAM);
        return this;
    }

    public CodeAMon Stats(String name, Types typeName) {
        if (name == null) {
            name = "Null-A-Mon";
        }
        this.name = name;
        this.type = typeName;
        this.hP = 40;
        this.lvl = 1;
        this.exp = 10;
        this.def = 10;
        this.spd = 5;
        this.pPL = 100;
        this.evolved = false;
        this.Moves_List.add(GROWL);
        this.Moves_List.add(SCRATCH);
        this.Moves_List.add(TACKLE);
        this.Moves_List.add(TYPEBEAM);
        return this;
    }


    /**
     * Prints the CodeAMon Info if requested to the User.
     *
     * @param codeAMon The CodeAMon being assigned the stats.
     */
    public static void printInfo(CodeAMon codeAMon) {
        System.out.println("********************************");
        System.out.println("Name: " + getCodeAMonName(codeAMon));
        System.out.println("Type: " + getType(codeAMon));
        System.out.println("Level: " + getLvl(codeAMon));
        System.out.println("Health: " + getHP(codeAMon));
        System.out.println("Experience: " + getExp(codeAMon));
        System.out.println("Protection: " + getDef(codeAMon));
        System.out.println("Speed: " + getSpd(codeAMon));
        System.out.println("Points per Level: " + getPPL(codeAMon));
        System.out.print("Has the following moves to attack:\n" + getMovesList(codeAMon));
        System.out.println("\n********************************");
    }

    private static String getMovesList(CodeAMon codeAMon) {
        String MovesInString = "";
        for (int i = 0; i < 4; i++) {
            MovesInString = MovesInString + codeAMon.Moves_List.get(i) + "\n";
        }
        return MovesInString;
    }

    /**
     * The method to upgrade the stats of the leveled up codeAMon.
     * @param codeAMon The codeAMon that is leveling up.
     * @return codeAMon after leveling up.
     */
    public static CodeAMon levelUp(CodeAMon codeAMon) {
        setLvl(codeAMon, getLvl(codeAMon) + 1);
        System.out.println("\n" + getCodeAMonName(codeAMon) + " has leveled up!\n"
                + getCodeAMonName(codeAMon) + " is now level " + getLvl(codeAMon));
        int upgradeValue = getLvl(codeAMon);
        setHP(codeAMon, (int) Math.floor(getHP(codeAMon) + upgradeValue / 2));
        setExp(codeAMon, 0);
        setDef(codeAMon, (int) Math.floor(getDef(codeAMon) + upgradeValue));
        setSpd(codeAMon, (int) Math.floor(getSpd(codeAMon) + upgradeValue));
        setPPL(codeAMon, (int) Math.floor(getPPL(codeAMon) + (upgradeValue * 2)));
        return codeAMon;
    }

    /**
     * evolves the inputted CodeAMon by wrapping the object into codeAMon and changing its stats.
     * @param codeAMon evolving codeAMon before
     * @return evolved CodeAMon after
     */
    public static CodeAMon evolveCodeAMon(CodeAMon codeAMon) {
        String evolvedName = "Java" + getCodeAMonName(codeAMon);
        System.out.println("\n" + getCodeAMonName(codeAMon) + " is evolving into: " + evolvedName);
        setName(codeAMon, evolvedName);
        setHP(codeAMon, (int) Math.floor(getHP(codeAMon) * 1.3));
        setExp(codeAMon, 0);
        setDef(codeAMon, (int) Math.floor(getDef(codeAMon) * 1.3));
        setSpd(codeAMon, (int) Math.floor(getSpd(codeAMon) * 1.3));
        setPPL(codeAMon, (int) Math.floor(getPPL(codeAMon) * 2.6));
        codeAMon.Moves_List.remove(GROWL);
        codeAMon.Moves_List.remove(SCRATCH);
        codeAMon.Moves_List.remove(TACKLE);
        codeAMon.Moves_List.remove(TYPEBEAM);
        codeAMon.Moves_List.add(ROAR);
        codeAMon.Moves_List.add(SLAM);
        codeAMon.Moves_List.add(SLASH);
        codeAMon.Moves_List.add(HYPERBEAM);
        return codeAMon;
    }

    public static String getCodeAMonName(CodeAMon codeAMon) {
        return codeAMon.name;
    }

    public static void setName(CodeAMon codeAMon, String string) {
        codeAMon.name = string;
    }

    public static Types getType(CodeAMon codeAMon) {
        return codeAMon.type;
    }

    public static int getHP(CodeAMon codeAMon) {
        return codeAMon.hP;
    }

    public static void setHP(CodeAMon codeAMon, int hP) {
        codeAMon.hP = hP;
    }

    public static int getLvl(CodeAMon codeAMon) {
        return codeAMon.lvl;
    }

    public static void setLvl(CodeAMon codeAMon, int lvl) {
        codeAMon.lvl = lvl;
    }

    public static int getExp(CodeAMon codeAMon) {
        return codeAMon.exp;
    }

    public static void setExp(CodeAMon codeAMon, int exp) {
        codeAMon.exp = exp;
    }

    public static int getDef(CodeAMon codeAMon) {
        return codeAMon.def;
    }

    public static void setDef(CodeAMon codeAMon, int def) {
        codeAMon.def = def;
    }

    public static double getSpd(CodeAMon codeAMon) {
        return codeAMon.spd;
    }

    public static void setSpd(CodeAMon codeAMon, double spd) {
        codeAMon.spd = spd;
    }

    public static int getPPL(CodeAMon codeAMon) {
        return codeAMon.pPL;
    }

    public static void setPPL(CodeAMon codeAMon, int pPL) {
        codeAMon.pPL = pPL;
    }

    private static void setEvolved(CodeAMon codeAMon) {
        codeAMon.evolved = true;
    }

    public static boolean isEvolved(CodeAMon codeAMon) {
        return codeAMon.evolved;
    }

    /**
     * The codeAmon that is sent to evolve is first checked for its level requirement.
     * @param codeAMon codeAMon determined if it should evolve or not.
     */
    public static void evolve(CodeAMon codeAMon) {
        if (codeAMon.lvl >= 15 && codeAMon.evolved == false) {
            setEvolved(codeAMon);
            evolveCodeAMon(codeAMon);
        }
    }

}
