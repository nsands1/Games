package CodeAMonFactory;
/**
 * NormalCodeAMon.java
 * Description: File for making Normal Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class NormalCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Normal CodeAMon");
        this.Stats(name,Types.NORMAL);
        return this;
    }

}
