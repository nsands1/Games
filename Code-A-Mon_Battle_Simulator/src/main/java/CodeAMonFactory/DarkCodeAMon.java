package CodeAMonFactory;
/**
 * DarkCodeAMon.java
 * Description: File for making Dark Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class DarkCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Dark CodeAMon");
        this.Stats(name,Types.DARK);
        return this;
    }

}