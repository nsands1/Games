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
public class ComputerTrainer extends Trainer {

    /**
     * make Trainer but a Computer Trainer, Factory DP.
     * @param trainerName name
     * @return the ComputerTrainer
     */
    public Trainer makeTrainer(String trainerName) {
        System.out.println("Generating new Computer Trainer");
        if (trainerName == null) {
            trainerName = "Bob";
        }
        this.TrainerInfo(trainerName);
        return this;
    }

}
