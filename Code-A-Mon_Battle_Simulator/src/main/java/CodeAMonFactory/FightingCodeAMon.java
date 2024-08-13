package CodeAMonFactory;
/**
 * FightingCodeAMon.java
 * Description: File for making Fighting Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class FightingCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Fighting CodeAMon");
        this.Stats(name,Types.FIGHTING);
        return this;
    }

}