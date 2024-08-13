package CodeAMonFactory;
/**
 * FlyingCodeAMon.java
 * Description: File for making Flying Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class FlyingCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Flying CodeAMon");
        this.Stats(name,Types.FLYING);
        return this;
    }

}