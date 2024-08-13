package CodeAMonFactory;
/**
 * IceCodeAMon.java
 * Description: File for making Ice Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class IceCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Ice CodeAMon");
        this.Stats(name,Types.ICE);
        return this;
    }

}