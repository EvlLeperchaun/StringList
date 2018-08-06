package EntryPoint;

import ListProject.CustomList;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class EntryPoint {
    public static void main(String args[]) {
        CustomList list1 = new CustomList();
        CustomList list2 = new CustomList(2);
        list1.add("test");
        list1.add("test2");
        list1.add("test3");
        String x="test4";
        list1.add(x);
        list2.add("Josh");
        list2.add("Bryan");

        //test add
        System.out.printf("Add.\n");
        for (int i = 0; i < list1.size(); i++) {
            System.out.printf("Value:%s\n", list1.getValue(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            System.out.printf("Value:%s\n", list2.getValue(i));
        }

        //test remove
        System.out.printf("Remove Index 0.\n");
        list1.remove(0);
        for (int i = 0; i < list1.size(); i++) {
            System.out.printf("Value:%s\n", list1.getValue(i));
        }

        //test add after remove
        System.out.printf("Add back after remove.\n");
        list1.add("test");
        for (int i = 0; i < list1.size(); i++) {
            System.out.printf("Value:%s\n", list1.getValue(i));
        }
        //test index
        System.out.printf("The index of test is %d.\n",list1.indexOf("test"));
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

        System.out.println(Arrays.stream(someArray).collect(Collectors.joining(",")));
        assertEquals(someArray.length, 3);

        someArray = tempArray;
        System.out.println(Arrays.stream(someArray).collect(Collectors.joining(",")));
        assertEquals(someArray.length, 5);

        someArray=tempArray2;
        System.out.println(Arrays.stream(someArray).collect(Collectors.joining(",")));
        assertEquals(someArray.length, 1);
    }
}
