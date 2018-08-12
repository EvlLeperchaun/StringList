package Comparators;

import Interfaces.CustomComparators;

public class AlphabeticalSort implements CustomComparators {
    public int compare(String one, String two) {
        return (one.compareTo(two) > 0) ? 1 : -1;
    }
}
