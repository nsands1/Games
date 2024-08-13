package CodeAMonFactory;
/**
 * RockCodeAMon.java
 * Description: File for making Rock Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class RockCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Rock CodeAMon");
        this.Stats(name,Types.ROCK);
        return this;
    }

}