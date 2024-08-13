package CodeAMonFactory;
/**
 * PsychicCodeAMon.java
 * Description: File for making Psychic Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class PsychicCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Psychic CodeAMon");
        this.Stats(name,Types.PSYCHIC);
        return this;
    }

}