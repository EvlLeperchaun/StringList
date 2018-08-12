package EntryPoint;

import Comparators.AlphabeticalSort;
import ListProject.CustomList;
import org.junit.Test;


import java.util.Arrays;
import java.util.stream.Collectors;


import static junit.framework.TestCase.assertEquals;

public class EntryPoint {
    public static void main(String args[]) {
        int numberOfEntries = 50000;
        CustomList list1 = new CustomList(numberOfEntries);
        for (int i = numberOfEntries; i > 0; i--) {
            list1.add(Integer.toString(i));
        }
        long startTime = System.currentTimeMillis();
        list1.sort(new AlphabeticalSort());
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted:\n");
        for (int i = 0; i < list1.length(); i++) {
            System.out.printf("Value:%s\n", list1.getValue(i));
        }
        System.out.printf("Time: %d", endTime - startTime);
    }
}
