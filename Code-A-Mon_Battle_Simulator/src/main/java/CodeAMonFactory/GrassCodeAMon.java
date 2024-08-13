package CodeAMonFactory;
/**
 * GrassCodeAMon.java
 * Description: File for making Grass Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class GrassCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Grass CodeAMon");
        this.Stats(name,Types.GRASS);
        return this;
    }
}