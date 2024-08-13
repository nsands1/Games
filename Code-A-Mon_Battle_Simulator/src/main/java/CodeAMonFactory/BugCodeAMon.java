package CodeAMonFactory;
/**
 * BugCodeAMon.java
 * Description: File for making Bug Type CodeAMon
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class BugCodeAMon extends CodeAMon {

    public CodeAMon makeCodeAMon(String name) {
        System.out.println("Generating new Bug CodeAMon");
        this.Stats(name,Types.BUG);
        return this;
    }
}