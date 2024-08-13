package CodeAMonFactory;
/**
 * FireCodeAMon.java
 * Description: File for making Fire Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class FireCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Fire CodeAMon");
        this.Stats(name,Types.FIRE);
        return this;
    }

}
