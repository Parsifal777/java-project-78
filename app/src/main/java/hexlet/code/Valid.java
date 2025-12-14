package hexlet.code;

import hexlet.code.Scheme.MapScheme;
import hexlet.code.Scheme.StringScheme;
import hexlet.code.Scheme.NumberScheme;

public class Valid {

    public StringScheme string() {
        return new StringScheme();  // Простой экземпляр, не анонимный класс
    }

    public NumberScheme number() {
        return new NumberScheme();  // Простой экземпляр, не анонимный класс
    }

    public MapScheme map() {
        return new MapScheme();  // Простой экземпляр
    }
}
