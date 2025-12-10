package hexlet.code.Scheme;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MapScheme {
    private boolean required = false;
    private Integer sizeof = null;

    public MapScheme required() {
        this.required = true;
        return this;
    }

    public MapScheme sizeof(Integer value) {
        this.sizeof = value;
        return this;
    }

    public <K, V> boolean isValid(Map<K, V> map) {
        if (!required && map == null) {
            return true;
        }

        if (required && map ==  null) {
            return false;
        }

        if (map.size() != sizeof) {
            return false;
        }

        return true;
    }
}
