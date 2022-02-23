package Task2_1_WorkingWithNumbersStream;

import java.util.*;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        System.out.println(intList);

        Stream<Integer> stream = intList.stream();

        intList.stream()
                .filter(x -> x > 0)  //only positive numbers
                .filter(x -> x % 2 == 0) //only even numbers
                .sorted(Comparator.naturalOrder()) //numbers in ascending order
                .forEach(numbers -> System.out.print(numbers + " "));

    }

}
