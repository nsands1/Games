/**
 * GamePlay.java
 * Description: File copied and modified from individual assignment.
 *      GamePlay
 * Author: Dr. Mehlhase
 * CoAuthor: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
import CodeAMonFactory.CodeAMon;
import CodeAMonFactory.Types;
import CodeAMonFactory.TypesChart;
import CycleMediator.Cycle;
import TrainerFactory.Trainer;
import java.util.ArrayList;
import java.util.List;

import static CodeAMonFactory.CodeAMon.*;
import static CodeAMonFactory.CodeAMonGenerator.makeACodeAMon;
import static TrainerFactory.Trainer.getNumCodeAMon;
import static TrainerFactory.Trainer.getTrainerName;
import static TrainerFactory.TrainerGenerator.makeTrainer;

/**
 * GamePlay Class implements CycleMediator.GamePlayInterface
 * Uses CodeAMons, player and opponent to battle for exp.
 * Contains methods required for Main.java to function.
 */
public class GamePlay {

    public static List<Trainer> ALL_TRAINERS_LIST = new ArrayList<>(); //List of all Trainers made.
    public static List<CodeAMon> PLAYER_CODEAMON_LIST = new ArrayList<>(); //Will hold all Player's CodeAMon.
    public static List<CodeAMon> OPP_CODEAMON_LIST = new ArrayList<>(); //Will hold all Opponents' CodeAMon.
    public static TypesChart TYPES_CHART = new TypesChart(); //Will hold list of Types
    boolean GAME_READY = false;
    boolean FIRST_ROUND = true;

    /**
     * default constructor.
     */
    public GamePlay() {
        TYPES_CHART.printTypesChartData();
        setUpGamePlay();
        runGamePlay();
    }

    /**
     * GAMEPLAY starts the game cycle as long as there are players available.
     */
    private void runGamePlay() {
        Cycle GameCycle = new Cycle();
        int i = 1;
        while (GAME_READY) {
            for (; i < ALL_TRAINERS_LIST.size(); i++) {
                // Print Battle Start Info
                printBattleStart();
                GameCycle.Cycle();
                GameCycle.RunCycle(ALL_TRAINERS_LIST.get(0), ALL_TRAINERS_LIST.get(i),
                        PLAYER_CODEAMON_LIST, OPP_CODEAMON_LIST);
                FIRST_ROUND = false;
                if (OPP_CODEAMON_LIST.isEmpty()) {
                    ALL_TRAINERS_LIST.remove(i);
                    addOppTrainer(i);
                    addOppCodeAMon(i);
                }
                continueGamePlaySetUp();
            }
            i--; //Remove if you want to end the game and not be in a simulated loop forever!
        }
    }

    /**
     * Generates new CodeAMon other than the defaulted codeAMon.
     * @param counter generator number for number of opponents to face.
     */
    private void addOppCodeAMon(int counter) {
        for (int i = 0; i < counter; i++) {
            CodeAMon wildCodeAMon = makeACodeAMon(null, null);
            OPP_CODEAMON_LIST.add(wildCodeAMon);
        }
    }

    private void addOppTrainer(int counter) {
        for (int i = 0; i < counter; i++) {
            Trainer wildTrainer = makeTrainer(null, false);
            ALL_TRAINERS_LIST.add(wildTrainer);

        }
    }

    /**
     * Default constructor for Game Play.
     * Will make 1 PlayerTrainer with 2 CodeAMon & 1 ComputerTrainer with 2 CodeAMon.
     */
    private void setUpGamePlay() {
        Trainer Ash = makeTrainer("Ash Ketchum", true);
        ALL_TRAINERS_LIST.add(Ash);
        Trainer Gary = makeTrainer("Gary Oak", false);
        ALL_TRAINERS_LIST.add(Gary);
        CodeAMon Squirtle = makeACodeAMon(Types.WATER, "Squirtle");
        PLAYER_CODEAMON_LIST.add(Squirtle);
        CodeAMon Pikachu = makeACodeAMon(Types.ELECTRIC, "Pikachu");
        OPP_CODEAMON_LIST.add(Pikachu);
        CodeAMon Charmander = makeACodeAMon(Types.FIRE, "Charmander");
        PLAYER_CODEAMON_LIST.add(Charmander);
        CodeAMon Bulbasaur = makeACodeAMon(Types.GRASS, "Bulbasaur");
        OPP_CODEAMON_LIST.add(Bulbasaur);
        //Testing setLvl(OPP_CODEAMON_LIST.get(0), 15);
        //Testing evolve(OPP_CODEAMON_LIST.get(0));
        continueGamePlaySetUp();
    }

    /**
     * ContinuesGamePlaySetUp is used after the first players and codeAMon were generated.
     * This method allows for the randomness generator to make random codeAMon to battle.
     */
    public void continueGamePlaySetUp() {
        System.out.println("\n********************************");
        System.out.println("Players and CodeAMon have been generated."
                + "\n********************************"
                + "\nAssigning CodeAMon to their Trainers..."
                + "\nTrainer List Size is: " + ALL_TRAINERS_LIST.size()
                + "\nPlayer CodeAMon List Size is: " + PLAYER_CODEAMON_LIST.size()
                + "\nOpponent CodeAMon List Size is: " + OPP_CODEAMON_LIST.size()
                + "\n********************************");

        for (int i = 0; i < ALL_TRAINERS_LIST.size(); i++) {
            if (i == 0) {
                if (FIRST_ROUND) {
                    System.out.println("Adding CodeAMon to Player Trainer "
                            + getTrainerName(ALL_TRAINERS_LIST.get(i))
                            + "\n********************************");
                    for (CodeAMon codeAMon : PLAYER_CODEAMON_LIST) {
                        ALL_TRAINERS_LIST.get(i).addCodeAMon(codeAMon);
                        CodeAMon.printInfo(codeAMon);
                    }
                }
            } else {
                System.out.println("Adding CodeAMon to Computer Trainer "
                        + getTrainerName(ALL_TRAINERS_LIST.get(i))
                        + "\n********************************");
                for (CodeAMon codeAMon : OPP_CODEAMON_LIST) {
                    ALL_TRAINERS_LIST.get(i).addCodeAMon(codeAMon);
                    CodeAMon.printInfo(codeAMon);
                }
            }
        }
        System.out.println("********************************\n");
        for (int i = 0; i < ALL_TRAINERS_LIST.size(); i++) {
            int size = getNumCodeAMon(ALL_TRAINERS_LIST.get(i));
            if (i == 0) {
                System.out.println("" + getTrainerName(ALL_TRAINERS_LIST.get(i))
                        + " has " + size + " CodeAMon: ");
                for (int j = 0; j < size; j++) {
                    System.out.println(getCodeAMonName(PLAYER_CODEAMON_LIST.get(j)) + " ");
                }
            } else {
                System.out.println("\n********************************\n");
                System.out.println("" + getTrainerName(ALL_TRAINERS_LIST.get(i))
                        + " has " + size + " CodeAMon: ");
                for (int j = 0; j < size; j++) {
                    System.out.println(getCodeAMonName(OPP_CODEAMON_LIST.get(j))+ " ");
                    //TODO change when additional opponents are made to battle.
                }
            }
        }
        GAME_READY = true;
    }

    /**
     * prints battle start information to console.
     */
    public void printBattleStart() {
        System.out.println("\n********************************\n"
                + "********************************\n\n"
                + "Number of Trainers to Battle: "
                + (ALL_TRAINERS_LIST.size() - 1)
                + "\n********************************"
                + "\nNext To Battle!\n"
                + "Trainer " + getTrainerName(ALL_TRAINERS_LIST.get(0))
                + "\n vs. \n"
                + "Trainer " + getTrainerName(ALL_TRAINERS_LIST.get(1))
                + "\n********************************\n");

    }

}