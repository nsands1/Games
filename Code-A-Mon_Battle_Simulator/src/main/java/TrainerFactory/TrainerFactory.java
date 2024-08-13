package TrainerFactory;
/**
 * TrainerFactory.java
 * Description: File that makes the decision for making ComputerTrainers and PlayerTrainers.
 *      Trainers have a name and some Easter-Egg names exist.
 *      This class is part of the Factory Design Pattern.
 * Author: nsands1@asu.edu
 * Created: 11/23/22
 * Modified: 11/23/22
 */
public class TrainerFactory {

    /**
     * Creates a trainer using Factory DP.
     * @param trainerName name of trainer.
     * @param isPlayer Boolean if trainer is a player.
     * @return returns a Trainer to be added to the Trainer Lists.
     */
    public Trainer createTrainer(String trainerName, Boolean isPlayer) {
        if (isPlayer == true) {
            if (trainerName == null) {
                return new PlayerTrainer();
            }
            switch (trainerName) {
                case "Ash Ketchum" -> {
                    return new PlayerTrainer().makeTrainer("Ash Ketchum");
                }
                case "Brock" -> {
                    return new PlayerTrainer().makeTrainer("Brock");
                }
                case "Misty" -> {
                    return new PlayerTrainer().makeTrainer("Misty");
                }
                default -> {
                    throw new IllegalArgumentException("Unknown Name Entered");
                }
            }
        } else {
            if (trainerName == null) {
                return new ComputerTrainer().makeTrainer(null);
            }
            switch (trainerName) {
                case "Gary Oak" -> {
                    return new ComputerTrainer().makeTrainer("Gary Oak");
                }
                case "James" -> {
                    return new ComputerTrainer().makeTrainer("James");
                }
                case "Jessie" -> {
                    return new ComputerTrainer().makeTrainer("Jessie");
                }
                default -> {
                    throw new IllegalArgumentException("Unknown Name Entered");
                }
            }
        }
    }
}
