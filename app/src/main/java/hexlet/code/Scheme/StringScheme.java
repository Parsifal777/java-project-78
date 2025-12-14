package hexlet.code.Scheme;
import hexlet.code.Interface.BaseScheme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StringScheme implements BaseScheme {
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

    @Override
    public boolean isValid(Object values) {
        // Если значение null
        if (values == null) {
            return !required;
        }

        // Если значение не String
        if (!(values instanceof String)) {
            return false;
        }

        String value = (String) values;

        // Если required и пустая строка - невалидно
        if (required && value.isEmpty()) {
            return false;
        }

        // Проверка minLength (только для непустых строк)
        if (minLength != null && value.length() < minLength) {
            return false;
        }

        // Проверка contains (только для непустых строк)
        if (contains != null && !value.contains(contains)) {
            return false;
        }

        return true;
    }
}
