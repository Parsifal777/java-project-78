package hexlet.code.Scheme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StringScheme {
    private boolean required = false;
    private Integer minLength = null;
    private String contains = null;

    public StringScheme required() {
        this.required = true;
        return this;
    }

    public StringScheme minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringScheme contains(String subString) {
        this.contains = subString;
        return this;
    }

    public boolean isValid(String value) {
        if (!required && value == null) {
            return true;
        }

        if (required && value ==  null) {
            return false;
        }

        if (minLength != null && value.length() < minLength) {
            return false;
        }

        if (contains != null && !value.contains(contains)) {
            return false;
        }

        return true;
    }
}
