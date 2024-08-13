package CodeAMonFactory;
/**
 * WaterCodeAMon.java
 * Description: File for making Water Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class WaterCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Water CodeAMon");
        this.Stats(name,Types.WATER);
        return this;
    }

}