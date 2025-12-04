package hexlet.code;

import hexlet.code.Scheme.StringScheme;
import lombok.NoArgsConstructor;
import hexlet.code.Scheme.NumberScheme;

@NoArgsConstructor
public class Valid {
    public StringScheme string() {
        return new StringScheme();
    }

    public NumberScheme number() {
        return new NumberScheme();
    }
}
