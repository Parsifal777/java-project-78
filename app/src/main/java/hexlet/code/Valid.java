package hexlet.code;

import hexlet.code.Scheme.MapScheme;
import hexlet.code.Scheme.StringScheme;
import lombok.NoArgsConstructor;
import hexlet.code.Scheme.NumberScheme;

import java.util.Map;

@NoArgsConstructor
public class Valid {
    public StringScheme string() {
        return new StringScheme();
    }

    public NumberScheme number() {
        return new NumberScheme();
    }

    public MapScheme map() {
        return new MapScheme();
    }
}
