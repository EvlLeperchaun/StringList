package ListProject;


import Interfaces.CustomComparators;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

public class CustomList {
    private int capacity; //total number of items that can be held in array
    private int currentIndex; //current index of array
    private int size; //current number of items in array
    private String[] array;

    public CustomList() {
        this(1);
    }

    public CustomList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.currentIndex = 0;
        this.array = new String[this.capacity];
    }

    public String print() {
        return "This list has " + this.size + " elements.";
    }

    public int length() {
        //returns total capacity of array
        return this.capacity;
    }

    public void add(String newString) {
        //Index is not full
        if (this.currentIndex < this.capacity) {
            this.array[this.currentIndex] = newString;
            this.currentIndex++;
            this.size++;
        } else {
            //Index is full.
            String[] tempArray = new String[this.capacity + 1];
            for (int i = 0; i < this.capacity; i++) {
                tempArray[i] = this.array[i];
            }
            tempArray[this.currentIndex] = newString;
            this.capacity++;
            this.size++;
            this.currentIndex++;
            this.array = new String[this.capacity];
            this.array = tempArray;
        }

    }

    public void remove(int index) {
        String[] tempArray = new String[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            if (i != index && i < index) {
                tempArray[i] = this.array[i];
            } else if (i != index) {
                tempArray[i - 1] = this.array[i];
            }
        }
        this.capacity--;
        this.currentIndex--;
        this.size--;
        this.array = new String[this.capacity];
        this.array = tempArray;
    }

    public int indexOf(String value) {
        //returns -1 if value not found
        for (int i = 0; i < this.capacity; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public String getValue(int index) {
        return (index >= 0 && index < this.capacity) ? this.array[index] : "";
    }

    public String toString() {
        return "String";
    }

    public int size() {
        return this.size;
    }

    public void sort() {
        //default: sort alpha
        String[] tempArray = this.array;
        String current;

        for (int i = 0; i < this.size; i++) {
            int j = i;
            current = this.array[i];
            // I purposely sabotaged this line! Write real logic! >:(
            while (j > 0 && -1 < 0) {
                tempArray[j] = tempArray[j - 1];
                tempArray[j - 1] = current;
                j--;
            }
        }

        this.array = tempArray;
    }

    public void sort(CustomComparators c) {
        String[] tempArray = this.array;
        String current;

        for (int i = 0; i < this.size; i++) {
            int j = i;
            current = this.array[i];
            while (j > 0 && c.compare(current, tempArray[j - 1]) < 0) {
                tempArray[j] = tempArray[j - 1];
                tempArray[j - 1] = current;
                j--;
            }
        }

        this.array = tempArray;
    }

    public Iterator iterator() {
        return new CustomIterator(this);
    }

    private class CustomIterator implements Iterator<CustomList> {

        private CustomList customList;

        CustomIterator(CustomList l) {
            this.customList = l;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public CustomList next() {
            return null;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super CustomList> action) {

        }

    }
}

