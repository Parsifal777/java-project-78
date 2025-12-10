package hexlet.code.testValid;

import hexlet.code.Scheme.MapScheme;
import hexlet.code.Valid;
import java.util.HashMap;
import java.util.Map;

public class testValidMap {
    public static void main(String[] args) {
        Valid object = new Valid();
        MapScheme scheme = object.map()
                .required()
                .sizeof(2);
        Map<Integer, String> test1 = new HashMap<>();
        test1.put(1, "Hey");
        test1.put(2, "Hy");
        System.out.println(scheme.isValid(test1)); //true

        Map<Integer, String> test2 = null;
        System.out.println(scheme.isValid(test2)); //false

        Map<Integer, String> test3 = new HashMap<>();
        test1.put(1, "A");
        test1.put(2, "B");
        test1.put(3, "C");
        System.out.println(scheme.isValid(test3)); //false
    }
}
