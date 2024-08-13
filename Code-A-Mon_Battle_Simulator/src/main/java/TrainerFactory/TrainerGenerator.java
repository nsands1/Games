package TrainerFactory;
/**
 * TrainerGenerator.java
 * Description: File for instantiating and starting the TrainerFactory.
 *      This class is part of the Factory Design Pattern.
 * Author: nsands1@asu.edu
 * Created: 11/23/22
 * Modified: 11/23/22
 */
public class TrainerGenerator {

    /**
     * Trainer Generator part of the Factory DP.
     * @param trainerName name
     * @param isPlayer boolean
     * @return returns Trainer.
     */
    public static Trainer makeTrainer(String trainerName, Boolean isPlayer) {
        TrainerFactory trainerFactory = new TrainerFactory();
        return trainerFactory.createTrainer(trainerName, isPlayer);
    }
}
