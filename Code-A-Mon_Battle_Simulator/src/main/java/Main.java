import CodeAMonFactory.CodeAMon;
import CodeAMonFactory.Types;
import CodeAMonFactory.TypesChart;
import TrainerFactory.Trainer;
import java.util.ArrayList;

import static CodeAMonFactory.CodeAMonGenerator.makeACodeAMon;
import static TrainerFactory.TrainerGenerator.makeTrainer;

/**
 * Java file Main.java
 * Description: Main java file for entry into CodeAMon Battles.
 * Author: nsands1@asu.edu
 * Created: 11/21/22
 * Modified: 11/23/22
 */
public class Main {

    /**
     * Main method that will interact the designed code to the user.
     * the following are pre-programmed rounds of Game A, B, C, & D.
     * @param args String[]
     */
    public static void main(String[] args) {

        GamePlay newWorld = new GamePlay();
        printGameStats(newWorld);

    } // end main method

    private static void printGameStats(GamePlay newWorld) {
        //TODO Print post game information and statistics.
    }

} // end main class