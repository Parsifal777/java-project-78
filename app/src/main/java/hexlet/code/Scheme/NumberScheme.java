package hexlet.code.Scheme;

import hexlet.code.Interface.BaseScheme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NumberScheme implements BaseScheme {
    private boolean required = false;
    private boolean positive = false;
    private Integer maxValue = null;
    private Integer minValue = null;

    public NumberScheme required() {
        this.required = true;
        return this;
    }

    public NumberScheme positive() {
        this.positive = true;
        return this;
    }

    public NumberScheme maxValue(int value) {
        this.maxValue = value;
        return this;
    }

    public NumberScheme minValue(int value) {
        this.minValue = value;
        return this;
    }

    public boolean isValid(Object values) {
        Integer value = (Integer) values;
        if (!required && value == null) {
            return true;
        }

        if (required && value == null) {
            return false;
        }

        if (positive && value < 0) {
            return false;
        }

        if (minValue != null && value < minValue) {
            return false;
        }

        if (maxValue != null && value > maxValue) {
            return false;
        }

        return true;
    }
}
