package ListProject;

public class CustomList {
    private int size;
    private int currentIndex;
    private String[] array;

    public CustomList() {
        // TODO: Note (just to make it yellow)
//        this.size = 1;
//        this.currentIndex = 0;
//        this.array = new String[this.size];

        // Why not just call the other constructor you already created?
        // Reduces redundancy
        this(1);
    }

    public CustomList(int size) {
        this.size = size;
        this.currentIndex = 0;
        this.array = new String[this.size];
    }

    public String print() {
        return "This list has " + this.size + " elements.";
    }

    public int size() {
        // TODO: Note
        // Is this correct? If you were using this list, what would you want this method
        // to tell you?
        return this.size;
    }

    public void add(String newString) {
        //Index is not full
        if (this.currentIndex < this.size) {
            this.array[this.currentIndex] = newString;
            this.currentIndex++;
        } else {
            //Index is full.
            // creates temp array with new index
            //iterates through current array and copies values
            String[] tempArray = new String[this.size + 1];
            for (int i = 0; i < this.size; i++) {
                tempArray[i] = this.array[i];
            }
            //increase size and index and assigns the new value
            tempArray[this.currentIndex] = newString;
            this.size++;
            this.currentIndex++;

            // TODO: Note
            // You should not iterate over the array again
            // It is increasing time unnecessarily.
            // Just assign it to your temporary one.
            // this.array = tempArray;

            //reiterates old array with new size
            this.array = new String[this.size];
            for (int i = 0; i < this.size; i++) {
                this.array[i] = tempArray[i];
            }
        }
    }

    public void remove(int index) {
        String[] tempArray = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            if (i != index && i < index) {
                tempArray[i] = this.array[i];
            } else if (i != index && i > index) {
                tempArray[i - 1] = this.array[i];
            }
        }
        this.size--;
        this.currentIndex--;
        this.array = new String[this.size];
        this.array = tempArray;
    }

    public int indexOf(String value) {

        // TODO: Note
        // There is a design principle a lot of software people use (me included)
        // called "early return". The idea is that if you satisfy your condition,
        // there's no need to do the rest of the stuff.


        // In this case, since we want to know the _first_ index of a value,
        // if you find it you can simply return inside the for loop.

        // TODO: Note
        // Returning null is generally a very bad practice. Nulls break
        // everything and cause programs to crash unexpectedly.

        Integer index = null;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                index = i;
            }
        }
        return index;
    }

    public String getValue(int index) {
        // TODO: Note
        // You want to avoid exceptions (especially uncaught ones) whenever possible
        // So you should "bounds check" the input index before trying to get it
        // so you don't throw array out of bounds exception
        return this.array[index];
    }

    public String toString() {
        return "String";
    }

}
