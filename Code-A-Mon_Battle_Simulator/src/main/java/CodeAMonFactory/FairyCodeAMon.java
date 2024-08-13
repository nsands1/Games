package CodeAMonFactory;
/**
 * FairyCodeAMon.java
 * Description: File for making Fairy Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class FairyCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Fairy CodeAMon");
        this.Stats(name,Types.FAIRY);
        return this;
    }

}