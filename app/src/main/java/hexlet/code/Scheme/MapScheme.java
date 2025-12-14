package hexlet.code.Scheme;

import hexlet.code.Interface.BaseScheme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MapScheme implements BaseScheme {
    private boolean required = false;
    private Integer sizeof = null;
    private Map<String, BaseScheme> shapeScheme = new HashMap<>();

    public MapScheme required() {
        this.required = true;
        return this;
    }

    public MapScheme sizeof(Integer value) {
        this.sizeof = value;
        return this;
    }

    public MapScheme shape(Map<String, BaseScheme> schemas) {
        this.shapeScheme = new HashMap<>(schemas);
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        // Проверка required
        if (value == null) {
            return !required;
        }

        // Проверка типа
        if (!(value instanceof Map)) {
            return false;
        }

        Map<?, ?> map = (Map<?, ?>) value;

        // Проверка sizeof
        if (sizeof != null && map.size() != sizeof) {
            return false;
        }

        // ВАЖНО: Добавляем проверку shapeScheme!
        // Если есть схемы для проверки, проверяем каждую
        if (!shapeScheme.isEmpty()) {
            for (Map.Entry<String, BaseScheme> entry : shapeScheme.entrySet()) {
                String key = entry.getKey();
                BaseScheme schema = entry.getValue();

                // Получаем значение из мапы по ключу
                Object mapValue = map.get(key);

                // Проверяем значение по соответствующей схеме
                // Если схема говорит, что значение невалидно - возвращаем false
                if (!schema.isValid(mapValue)) {
                    return false;
                }
            }
        }

        return true;
    }
}
