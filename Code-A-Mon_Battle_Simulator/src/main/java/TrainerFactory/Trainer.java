package TrainerFactory;
import CodeAMonFactory.CodeAMon;
import java.util.ArrayList;
/**
 * Trainer.java
 * Description: File for making Trainers. Trainers have a name and may have 6 CodeAMon maximum.
 *      This class is part of the Factory Design Pattern.
 * Author: nsands1@asu.edu
 * Created: 11/23/22
 * Modified: 11/23/22
 */
public class Trainer {

    String trainerName = "";
    int MAX_CODEAMONS = 6;
    ArrayList<CodeAMon> codeAMonList = new ArrayList<>(MAX_CODEAMONS);


    public Trainer TrainerInfo() {
        this.trainerName = "Bob";
        System.out.println("Trainer " + this.trainerName + " has arrived!");
        return this;
    }

    public Trainer TrainerInfo(String trainerName) {
        this.trainerName = trainerName;
        System.out.println("Trainer " + this.trainerName + " has arrived!");
        return this;
    }

    public static String getTrainerName(Trainer trainer) {
        return trainer.trainerName;
    }

    public static void setTrainerName(Trainer trainer, String string) {
        trainer.trainerName = string;
    }

    /**
     * Adds a codeAMon to the list of CodeAMon to be handled.
     */
    public void addCodeAMon(CodeAMon codeAMon) {
        if (this.codeAMonList.size() <= 6) {
            this.codeAMonList.add(codeAMon);
            System.out.println("Successfully added "
                    + CodeAMon.getCodeAMonName(codeAMon)
                    + " to the party!");
        } else {
            System.out.println("You have too many CodeAMon in your party!\n" +
                    "You must remove a CodeAMon to take in a new CodeAMon!");
        }
    }

    public static int getNumCodeAMon(Trainer trainer) {
        return trainer.codeAMonList.size();
    }

    public String getPlayerName(Trainer trainer) { return trainer.trainerName; }

}
