package CodeAMonFactory;
/**
 * ElectricCodeAMon.java
 * Description: File for making Electric Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class ElectricCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Electric CodeAMon");
        this.Stats(name,Types.ELECTRIC);
        return this;
    }

}