package Comparators;

import Interfaces.CustomComparators;

public class AlphabeticalSort implements CustomComparators {
    public int compare(String one, String two) {
        // type char can be treated as an integer - converts to ascii integer value
        return (one.compareTo(two)>0) ?  1: -1;
    }
}
