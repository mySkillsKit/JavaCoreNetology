package Task2_1_WorkingWithNumbersStream;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> intListSort = new ArrayList<>();


        for (int i = 0; i < intList.size(); i++) {

            int x = intList.get(i);
            if (x > 0 && x % 2 == 0) {
                //only positive numbers and only even numbers
                intListSort.add(x);

            }
        }

        intListSort.sort(Comparator.naturalOrder()); //numbers in ascending order

        //print ArrayList on the Display
        for (int i = 0; i < intListSort.size(); i++) {
            System.out.print(intListSort.get(i) + " ");
        }

    }
}
