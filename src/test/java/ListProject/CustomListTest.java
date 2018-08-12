package ListProject;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class CustomListTest {

    @Test
    public void testAddElement() {
        CustomList list = new CustomList();
        String sampleValue = "this is a test value";

        list.add(sampleValue);

        assertEquals(list.size(), 1);
        assertNotNull(list.getValue(0));
        assertEquals(list.getValue(0), sampleValue);
    }

    @Test
    public void testDeleteElement() {
        CustomList list = new CustomList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

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
    public void testAlphaSort() {
        CustomList list = new CustomList();
        list.add("b");
        list.add("d");
        list.add("z");
        list.add("1");
        list.add("e");
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
            return -1;
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
            return 1;
        });

        assertEquals(list.size(), size);
        assertEquals(list.getValue(0), "z");
        assertEquals(list.getValue(list.size() - 1), "1");
    }
}
