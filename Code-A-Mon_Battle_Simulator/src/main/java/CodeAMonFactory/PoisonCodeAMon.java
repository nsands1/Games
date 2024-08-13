package CodeAMonFactory;
/**
 * PoisonCodeAMon.java
 * Description: File for making Poison Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class PoisonCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Poison CodeAMon");
        this.Stats(name,Types.POISON);
        return this;
    }

}