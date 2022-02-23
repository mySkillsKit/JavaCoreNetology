package Lesson_1_LambdaExample;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    @FunctionalInterface
    interface ICalculate {
        int calculate(int a, int b);
    }

    public static void main(String[] args) {
        ICalculate multiply = new ICalculate() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };

        ICalculate multiplySecond = (a, b) -> a * b;

        System.out.println(multiply.calculate(10, 33));
        System.out.println(multiplySecond.calculate(10, 44));

        ICalculate mod = (a, b) -> a / b;
        System.out.println(mod.calculate(4, 7));

        ICalculate sum = Integer::sum;
        System.out.println(sum.calculate(1, 1));

        var minus = (ICalculate) (a, b) -> a - b;
        System.out.println(minus.calculate(1, 1));

        ICalculate div = (a, b) -> {
            System.out.printf("I calculate div fro a = %d, by b = %d%n", a, b);
            if (a == b) {
                System.out.println("Param a equals b");
            }
            return a % b;
        };

        System.out.println(div.calculate(10, 3));
        System.out.println(div.calculate(10, 10));

        var cities = Arrays.asList("Париж", "СПБ", "Лондон", "Берлин", "Волгоград");

        Comparator<String> comparatorIncrease = Comparator.reverseOrder();
        Comparator<String> comparatorDecrease = String::compareTo;
        Collections.sort(cities, comparatorIncrease);
        System.out.println(cities);
        Collections.sort(cities, comparatorDecrease);
        System.out.println(cities);

        sortList(cities, (o1, o2) -> {
            if (o1.equals("Париж"))
            System.out.println("bonjour de Paris");
            return o1.compareTo(o2);
        });

        var numbers = Arrays.asList(1, 2, 3, 4, 5);
        sortList(numbers, (o1, o2) -> o2.compareTo(o1));

        Predicate<Integer> isPositive = (test) -> test > 0;
        System.out.println(isPositive.test(-1));

        Consumer<String> greeting = (msg) -> System.out.println(msg);

        greeting.accept("Hello world");

        Supplier<Long> getNowTime = () -> System.currentTimeMillis();
        System.out.println(getNowTime.get());

        Function<Long, String> clock = (time) -> "At now a " + time;
        System.out.println(clock.apply(System.currentTimeMillis()));

        cities.forEach(Main::makeAction);

//        UnaryOperator<String> makeMsg =
    }

    public static void makeAction(String str) {
        System.out.println(str.toUpperCase(Locale.ROOT));
    }

    public static void sortListIncrease(List<String> list) {
        Collections.sort(list, ((o1, o2) -> o1.compareTo(o2)));
        System.out.println(list);
    }

    public static void sortListDecrease(List<String> list) {
        Collections.sort(list, ((o1, o2) -> o2.compareTo(o1)));
        System.out.println(list);
    }

    public static <T> void sortList(List<T> list, Comparator<T> comparator) {
        Collections.sort(list, comparator);
        System.out.println(list);
    }
}
