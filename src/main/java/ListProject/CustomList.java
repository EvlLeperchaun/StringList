package ListProject;


import Comparators.AlphabeticalSort;
import Interfaces.CustomComparators;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;

public class CustomList<T> implements Iterable {
    private int capacity; //total number of items that can be held in array
    private int size; //current number of items in array
    private Object[] array;

    public CustomList() {
        this(1);
    }

    public CustomList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new Object[this.capacity];
    }

    public CustomList(String path) {
        this.capacity = 0;
        this.fileSort(path);
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.printf(this.array[i]+"\n");
        }
    }

    public int length() {
        //returns total capacity of array
        return this.capacity;
    }

    public void add(T newEntry) {
        //Index is not full
        if (this.size < this.capacity) {
            this.array[this.size] = newEntry;
            this.size++;
        } else {
            //Index is full.
            Object[] tempArray = new Object[this.capacity + 1];
            for (int i = 0; i < this.capacity; i++) {
                tempArray[i] = this.array[i];
            }
            tempArray[this.size] = newEntry;
            this.capacity++;
            this.size++;
            this.array = new Object[this.capacity];
            this.array = tempArray;
        }

    }

    public void remove(int index) {
        Object[] tempArray = new Object[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            if (i != index && i < index) {
                tempArray[i] = this.array[i];
            } else if (i != index) {
                tempArray[i - 1] = this.array[i];
            }
        }
        this.capacity--;
        this.size--;
        this.array = new Object[this.capacity];
        this.array = tempArray;
    }

    public int indexOf(T value) {
        //returns -1 if value not found
        for (int i = 0; i < this.capacity; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public T getValue(int index) {
        Objects.checkIndex(index, this.capacity);
        return (T) this.array[index];

    }


    public int size() {
        return this.size;
    }

    public void sort() {
        //default: sort alpha
        Object[] tempArray = this.array;
        Object current;
        CustomComparators c = new AlphabeticalSort();
        for (int i = 0; i < this.size; i++) {
            int j = i;
            current = this.array[i];
            while (j > 0 && c.compare(current.toString(), tempArray[j - 1].toString()) < 0) {
                tempArray[j] = tempArray[j - 1];
                tempArray[j - 1] = current;
                j--;
            }
        }

        this.array = tempArray;
    }

    public void sort(CustomComparators c) {
        Object[] tempArray = this.array;
        Object current;

        for (int i = 0; i < this.size; i++) {
            int j = i;
            current = this.array[i];
            while (j > 0 && c.compare(current.toString(), tempArray[j - 1].toString()) < 0) {
                tempArray[j] = tempArray[j - 1];
                tempArray[j - 1] = current;
                j--;
            }
        }

        this.array = tempArray;
    }

    public Iterator<T> iterator() {
        return new CustomIterator(this);
    }

    private class CustomIterator implements Iterator<T> {

        private CustomList customList;
        private int index;

        CustomIterator(CustomList l) {
            this.customList = l;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if (this.index == this.customList.size) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                this.index++;
                return (T) this.customList.getValue(this.customList.size - 1);
            } else {
                return null;
            }

        }
    }

    public void fileSort(String path) {
        BufferedWriter bw = null;

        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(new File("src/main/resources/sorted_list.txt"), false);
            bw = new BufferedWriter(fw);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String x = scan.nextLine();
                this.add((T) x);
            }
            scan.close();
            this.sort();

            for (int i = 0; i < this.capacity; i++) {
                bw.write(this.array[i].toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.printf("IO exception\n");
        } finally {
            if (!(bw == null)) {
                try {
                    bw.close();
                } catch (IOException e) {

                }
            }
        }
    }
}

