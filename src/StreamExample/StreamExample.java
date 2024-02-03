package StreamExample;//Cоздать коллекцию класса ArreyList наполнить ее элементами рандомными элементами типа Integer.
// -C помощью Stream'ов ,
// -Удалить дубликаты
// -Вывести все четные элементы в диапазоне от 7 до 17(включительно)
// -Каждый элемент умножить на 2
// -Отсортировать и вывести на экран первых 4 элемента
// -Вывести количество элементов в стриме
// -Bывести среднее арифметическое всех чисел в стриме
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StreamExample {
    public static void main(String[] args) {
        // Создаем коллекцию ArrayList для хранения элементов типа Integer
        ArrayList<Integer> integerList = new ArrayList<>();

        // Наполняем коллекцию случайными элементами
        int numberOfElements = 20; // количество элементов в коллекции
        for (int i = 0; i < numberOfElements; i++) {
            integerList.add((int) (Math.random() * 50)); // предполагаем, что элементы будут в диапазоне [0, 49]
        }

        System.out.println("Исходная коллекция: " + integerList);

        // Используем Stream для выполнения операций
        List<Integer> result = integerList.stream()
                .distinct() // удаление дубликатов
                .filter(e -> e >= 7 && e <= 17) // фильтрация четных элементов в диапазоне от 7 до 17 (включительно)
                .map(e -> e * 2) // умножение на 2
                .sorted() // сортировка
                .limit(4) // ограничение количества элементов до 4
                .peek(System.out::println) // вывод элементов на экран
                .collect(Collectors.toList()); // сбор результата в List

        // Выводим количество элементов в стриме
        System.out.println("Количество элементов в стриме: " + result.size());

        // Выводим среднее арифметическое всех чисел в стриме
        double average = integerList.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0); // значение по умолчанию, если стрим пустой

        System.out.println("Среднее арифметическое всех чисел в стриме: " + average);
    }
}