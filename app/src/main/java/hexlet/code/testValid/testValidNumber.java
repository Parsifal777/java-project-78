package hexlet.code.testValid;

import hexlet.code.Scheme.NumberScheme;
import hexlet.code.Valid;

public class testValidNumber {
    public static void main(String[] args) {
        Valid object1 = new Valid();
        NumberScheme scheme1 = object1.number()
                .required()
                .positive()
                .maxValue(10);
        System.out.println(scheme1.isValid(0)); //true
        System.out.println(scheme1.isValid(null)); //false
        System.out.println(scheme1.isValid(-2)); //false
        System.out.println(scheme1.isValid(11)); //false
        System.out.println(scheme1.isValid(10)); //true
        System.out.println("End Valid\n");

        Valid object2 = new Valid();
        NumberScheme scheme2 = object2.number()
                .required()
                .positive()
                .minValue(2)
                .maxValue(10);
        System.out.println(scheme2.isValid(0)); //false
        System.out.println(scheme2.isValid(null)); //false
        System.out.println(scheme2.isValid(-2)); //false
        System.out.println(scheme2.isValid(2)); //true
        System.out.println(scheme2.isValid(1)); //false
        System.out.println("End Valid\n");
    }
}
