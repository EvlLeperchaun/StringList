package EntryPoint;

import Comparators.AlphabeticalSort;
import ListProject.CustomList;
import org.junit.Test;


import java.util.Arrays;
import java.util.stream.Collectors;


import static junit.framework.TestCase.assertEquals;

public class EntryPoint {
    public static void main(String args[]) {
        /*CustomList list1 = new CustomList();
        CustomList list2 = new CustomList(2);
        list1.add("4");
        list1.add("6");
        list1.add("2");
        String x="1";
        list1.add(x);
        list1.add("3");
        list1.add("5");
        list2.add("Josh");
        list2.add("Bryan");

        //test add
        System.out.printf("Add.\n");
        for (int i = 0; i < list1.length(); i++) {
            System.out.printf("Value:%s\n", list1.getValue(i));
        }
        for (int i = 0; i < list2.length(); i++) {
            System.out.printf("Value:%s\n", list2.getValue(i));
        }
        System.out.printf("Current size: %d\n",list1.size());

        //test remove
        System.out.printf("Remove Index 0.\n");
        list1.remove(0);
        for (int i = 0; i < list1.length(); i++) {
            System.out.printf("Value:%s\n", list1.getValue(i));
        }
        System.out.printf("Current size: %d\n",list1.size());

        //test add after remove
        System.out.printf("Add back after remove.\n");
        list1.add("test");
        for (int i = 0; i < list1.length(); i++) {
            System.out.printf("Value:%s\n", list1.getValue(i));
        }
        System.out.printf("Current size: %d\n",list1.size());

        //test index
        System.out.printf("The index of test is %d.\n",list1.indexOf("test"));

        //test no index found
        System.out.printf("Looking for index asdf: %d\n",list1.indexOf("asdf"));

        //get value out of bounds
        System.out.printf("Looking for index out of bounds: %s\n",list1.getValue(-1));
        */
        int numberOfEntries=50000;
        CustomList list1=new CustomList(numberOfEntries);
        for (int i = numberOfEntries; i > 0; i--) {
            list1.add(Integer.toString(i));
        }
        long startTime=System.currentTimeMillis();
        list1.sort(new AlphabeticalSort());
        long endTime=System.currentTimeMillis();
        System.out.println("Sorted:\n");
        for (int i = 0; i < list1.length(); i++) {
            System.out.printf("Value:%s\n", list1.getValue(i));
        }
        System.out.printf("Time: %d",endTime-startTime);
    }

    @Test
    public void test() {
        String[] someArray = new String[3];
        someArray[0] = "one11";
        someArray[1] = "one12";
        someArray[2] = "one13";

        String[] tempArray = new String[5];
        tempArray[0] = "one21";
        tempArray[1] = "one22";
        tempArray[2] = "one23";
        tempArray[3] = "one24";
        tempArray[4] = "one25";

        String[] tempArray2 = new String[1];
        tempArray2[0] = "one31";

        System.out.println(String.join(",", someArray));
        assertEquals(someArray.length, 3);

        someArray = tempArray;
        System.out.println(String.join(",", someArray));
        assertEquals(someArray.length, 5);

        someArray=tempArray2;
        System.out.println(String.join(",", someArray));
        assertEquals(someArray.length, 1);
    }
}
