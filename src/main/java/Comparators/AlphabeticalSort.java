package Comparators;

import Interfaces.CustomComparators;

public class AlphabeticalSort implements CustomComparators {
    public int compare(String one, String two) {
        if ( one.compareTo(two)> 0) {
            return 1;
        }
        else if (one.compareTo(two) <0){
            return -1;
        }
        else{
            return 0;
        }

    }
}
