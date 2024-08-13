package CodeAMonFactory;
/**
 * CodeAMonGenerator.java
 * Description: File for instantiating and starting the CodeAMonFactory and CodeAMons.
 *      This class is part of the Factory Design Pattern.
 * Author: nsands1@asu.edu
 * Created: 11/22/22
 * Modified: 11/23/22
 */
public class CodeAMonGenerator {

    public static CodeAMon makeACodeAMon(Types typeName, String name) {
        CodeAMonFactory codeAMonFactory = new CodeAMonFactory();
        return codeAMonFactory.createCodeAMon(name, typeName);
    }
}
