package hexlet.code;

import hexlet.code.Scheme.MapScheme;
import hexlet.code.Scheme.StringScheme;
import lombok.NoArgsConstructor;
import hexlet.code.Scheme.NumberScheme;

import java.util.Map;

@NoArgsConstructor
public class Valid {
    public StringScheme string() {
        return new StringScheme() {
            @Override
            public boolean isValid(Object value) {
                return false;
            }
        };
    }

    public NumberScheme number() {
        return new NumberScheme() {
            @Override
            public boolean isValid(Object value) {
                return false;
            }
        };
    }

    public MapScheme map() {
        return new MapScheme() {
            @Override
            public boolean isValid(Object value) {
                return false;
            }
        };
    }
}
