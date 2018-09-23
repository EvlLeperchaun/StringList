package ListProject;

import ListProject.CustomList;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class CustomListTest {

    @Test
    public void testAddElement() {
        CustomList list = new CustomList();
        int sampleValue = 1;

        list.add(sampleValue);

        assertEquals(list.size(), 1);
        assertNotNull(list.getValue(0));
        assertEquals(list.getValue(0), sampleValue);
    }

    @Test
    public void testDeleteElement() {
        CustomList list = new CustomList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add("five");
        list.print();

        list.remove(2);

        assertEquals(list.size(), 4);
        for (int i = 0; i < list.size(); i++) {
            assertNotEquals(list.getValue(i), "three");
        }

        list.remove(2);

        assertEquals(list.size(), 3);
        for (int i = 0; i < list.size(); i++) {
            assertNotEquals(list.getValue(i), "four");
        }
    }

    @Test
    public void testSize() {
        CustomList list = new CustomList(5);
        assertEquals(list.size(), 0);

        list.add("whatever");
        assertEquals(list.size(), 1);
    }

    @Test
    public void testIterator() {
        CustomList list = new CustomList();
        list.add("one");
        list.add("two");
        list.add("three");

        int count = 0;
        Iterator<String> i = list.iterator();
        while(i.hasNext()) {
            String s = i.next();
            count++;
            assertNotNull(s);
        }

        assertEquals(count, list.size());
    }

    @Test
    public void testAlphaSort() {
        CustomList list = new CustomList();
        list.add("b");
        list.add("d");
        list.add("z");
        list.add("1");
        list.add("e");
        list.add("E");
        list.add("g");
        list.add("f");
        list.add("t");
        list.add("a");
        list.add("y");
        list.add("c");

        int size = list.size();

        list.sort((first, second) -> {
            int shorterLength = (first.length() > second.length()) ? second.length() : first.length();
            for (int i = 0; i < shorterLength; i++) {
                char f = first.toLowerCase().charAt(i);
                char s = second.toLowerCase().charAt(i);
                if (f != s) {
                    return f - s;
                }
            }
            return second.length()-first.length();
        });

        assertEquals(list.size(), size);
        assertEquals(list.getValue(0), "1");
        assertEquals(list.getValue(list.size() - 1), "z");
    }

    @Test
    public void testReverseAlphaSort() {
        CustomList list = new CustomList();
        list.add("b");
        list.add("d");
        list.add("z");
        list.add("e");
        list.add("E");
        list.add("g");
        list.add("f");
        list.add("1");
        list.add("t");
        list.add("a");
        list.add("y");
        list.add("c");

        int size = list.size();

        list.sort((first, second) -> {
            int shorterLength = (first.length() > second.length()) ? second.length() : first.length();
            for (int i = 0; i < shorterLength; i++) {
                char f = first.toLowerCase().charAt(i);
                char s = second.toLowerCase().charAt(i);
                if (f != s) {
                    return s - f;
                }
            }
            return second.length()-first.length();
        });

        assertEquals(list.size(), size);
        assertEquals(list.getValue(0), "z");
        assertEquals(list.getValue(list.size() - 1), "1");
    }

    @Test
    public void testWordSort() {
        CustomList list = new CustomList();
        list.add("bryan");
        list.add("davis");
        list.add("zeb");
        list.add("zebra");
        list.add("elephant");
        list.add("Elephant");
        list.add("giant");
        list.add("freud");
        list.add("lesbians");
        list.add("tests");
        list.add("alphabet");
        list.add("alphabetical");
        list.add("josh");
        list.add("yesplz");
        list.add("chris");
        list.add("cone");

        int size = list.size();

        list.sort((first, second) -> {
            int shorterLength = (first.length() > second.length()) ? second.length() : first.length();
            for (int i = 0; i < shorterLength; i++) {
                char f = first.toLowerCase().charAt(i);
                char s = second.toLowerCase().charAt(i);
                if (f != s) {
                    return s - f;
                }
            }
            return second.length()-first.length();
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getValue(i));
        }

        assertEquals(list.size(), size);
        assertEquals(list.getValue(0), "zebra");
        assertEquals(list.getValue(list.size() - 1), "alphabet");
    }
}
