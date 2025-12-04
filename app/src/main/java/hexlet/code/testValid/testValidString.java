package hexlet.code.testValid;

import hexlet.code.Scheme.StringScheme;
import hexlet.code.Valid;

public class testValidString {
    public static void main(String[] args) {
        Valid object1 = new Valid();
        StringScheme scheme = object1.string()
                .required()
                .minLength(6)
                .contains("pr");
        System.out.println(scheme.isValid("hsdgfjhjgfds")); //false
        System.out.println(scheme.isValid("hsdgfprjgfds")); //true
        System.out.println(scheme.isValid("prsdf")); //false
        System.out.println(scheme.isValid(null)); //false
    }
}
