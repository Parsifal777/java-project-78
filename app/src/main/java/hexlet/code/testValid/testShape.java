package hexlet.code.testValid;

import hexlet.code.Interface.BaseScheme;
import hexlet.code.Scheme.MapScheme;
import hexlet.code.Valid;

import java.util.HashMap;
import java.util.Map;

public class testShape {
    public static void main(String[] args) {
        Valid validator = new Valid();
        MapScheme schema = validator.map();

        // 1. Создаем схему для поля "name"
        Map<String, BaseScheme> shapeRules = new HashMap<>();
        shapeRules.put("name", validator.string().required());

        // 2. Применяем shape
        schema.shape(shapeRules);

        // 3. Тест 1: Валидные данные
        Map<String, String> validData = new HashMap<>();
        validData.put("name", "John");
        boolean result1 = schema.isValid(validData);
        System.out.println("Тест 1 (валидные данные): " + result1 + " (ожидается: true)");

        // 4. Тест 2: Невалидные данные (поле name = null)
        Map<String, String> invalidData = new HashMap<>();
        invalidData.put("name", null);
        boolean result2 = schema.isValid(invalidData);
        System.out.println("Тест 2 (name = null): " + result2 + " (ожидается: false)");

        // 5. Тест 3: Пустая мапа (поле name отсутствует)
        Map<String, String> emptyData = new HashMap<>();
        boolean result3 = schema.isValid(emptyData);
        System.out.println("Тест 3 (name отсутствует): " + result3 + " (ожидается: false)");
    }
}