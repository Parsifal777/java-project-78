package hexlet.code.testValid;

import hexlet.code.Interface.BaseScheme;
import hexlet.code.Scheme.MapScheme;
import hexlet.code.Valid;
import java.util.HashMap;
import java.util.Map;

public class DebugTest {
    public static void main(String[] args) {
        System.out.println("=== ДЕТАЛЬНАЯ ОТЛАДКА ===");

        // 1. Создаем валидатор
        Valid validator = new Valid();
        System.out.println("1. Valid создан: " + (validator != null));

        // 2. Создаем StringScheme
        BaseScheme stringSchema = validator.string().required();
        System.out.println("2. StringScheme создан: " + (stringSchema != null));

        // 3. Тестируем StringScheme отдельно
        System.out.println("\n3. Тест StringScheme:");
        System.out.println("   'John': " + stringSchema.isValid("John"));
        System.out.println("   null: " + stringSchema.isValid(null));
        System.out.println("   '': " + stringSchema.isValid(""));

        // 4. Создаем MapScheme
        MapScheme mapSchema = validator.map();
        System.out.println("\n4. MapScheme создан: " + (mapSchema != null));

        // 5. Создаем shape
        Map<String, BaseScheme> shape = new HashMap<>();
        shape.put("name", stringSchema);
        System.out.println("5. Shape создан, размер: " + shape.size());

        // 6. Применяем shape
        mapSchema.shape(shape);
        System.out.println("6. Shape применен, размер shapeScheme: " + mapSchema.getShapeScheme().size());

        // 7. Создаем тестовые данные
        Map<String, String> testData = new HashMap<>();
        testData.put("name", "John");
        System.out.println("\n7. Тестовые данные:");
        System.out.println("   Мапа: " + testData);
        System.out.println("   Ключ 'name' существует: " + testData.containsKey("name"));
        System.out.println("   Значение 'name': '" + testData.get("name") + "'");

        // 8. Проверяем значение через StringScheme напрямую
        String nameValue = testData.get("name");
        System.out.println("8. Прямая проверка StringScheme:");
        System.out.println("   stringSchema.isValid('" + nameValue + "'): " + stringSchema.isValid(nameValue));

        // 9. Проверяем через MapScheme
        System.out.println("\n9. Проверка через MapScheme:");
        boolean result = mapSchema.isValid(testData);
        System.out.println("   mapSchema.isValid(testData): " + result);

        // 10. Отладка внутри MapScheme (нужно добавить в код)
        System.out.println("\n10. Внутренняя отладка MapScheme:");
        System.out.println("   mapSchema.shapeScheme пустой?: " + mapSchema.getShapeScheme().isEmpty());
        System.out.println("   mapSchema.shapeScheme содержит 'name'?: " + mapSchema.getShapeScheme().containsKey("name"));

        if (!mapSchema.getShapeScheme().isEmpty()) {
            BaseScheme nameSchemaFromMap = mapSchema.getShapeScheme().get("name");
            System.out.println("   Схема для 'name' из MapScheme: " + nameSchemaFromMap);
            System.out.println("   nameSchemaFromMap.isValid('John'): " + nameSchemaFromMap.isValid("John"));
        }
    }
}