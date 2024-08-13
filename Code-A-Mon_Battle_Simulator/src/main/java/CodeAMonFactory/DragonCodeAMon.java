package CodeAMonFactory;
/**
 * DragonCodeAMon.java
 * Description: File for making Dragon Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class DragonCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Dragon CodeAMon");
        this.Stats(name,Types.DRAGON);
        return this;
    }

}