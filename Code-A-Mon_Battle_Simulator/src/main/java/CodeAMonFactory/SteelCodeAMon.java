package CodeAMonFactory;
/**
 * SteelCodeAMon.java
 * Description: File for making Steel Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class SteelCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Steel CodeAMon");
        this.Stats(name,Types.STEEL);
        return this;
    }

}