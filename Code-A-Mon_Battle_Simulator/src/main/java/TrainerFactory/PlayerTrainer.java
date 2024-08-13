package TrainerFactory;
import CodeAMonFactory.CodeAMon;
import java.util.List;
/**
 * ComputerTrainer.java
 * Description: File for making ComputerTrainers extends Trainer.java.
 *      This class is part of the Factory Design Pattern.
 * Author: nsands1@asu.edu
 * Created: 11/23/22
 * Modified: 11/23/22
 */
public class PlayerTrainer extends Trainer {

    /**
     * makes Trainer Factory DP.
     * @param trainerName name
     * @return Trainer to be returned.
     */
    public Trainer makeTrainer(String trainerName) {
        System.out.println("Generating new Player Trainer");
        this.TrainerInfo(trainerName);
        return this;
    }

}
