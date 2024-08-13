package CodeAMonFactory;
/**
 * GroundCodeAMon.java
 * Description: File for making Ground Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class GroundCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Ground CodeAMon");
        this.Stats(name,Types.GROUND);
        return this;
    }

}