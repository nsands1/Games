package CodeAMonFactory;
/**
 * GhostCodeAMon.java
 * Description: File for making Ghost Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class GhostCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Ghost CodeAMon");
        this.Stats(name,Types.GHOST);
        return this;
    }

}