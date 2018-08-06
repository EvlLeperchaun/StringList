package ListProject;

public class CustomList {
    private int size;
    private int currentIndex;
    private String[] array;

    public CustomList() {
        this.size = 1;
        this.currentIndex = 0;
        this.array = new String[this.size];
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
        return this.size;
    }

    public void add(String newString) {
        //Index is not full
        if (this.currentIndex < this.size) {
            this.array[this.currentIndex] = newString;
            this.currentIndex++;
        } else {
            //Index is full.
            String[] tempArray = new String[this.size + 1];
            for (int i = 0; i < this.size; i++) {
                tempArray[i] = this.array[i];
            }
            //increase size and index and assigns the new value
            tempArray[this.currentIndex] = newString;
            this.size++;
            this.currentIndex++;
            //reiterates old array with new size
            this.array = new String[this.size];
            this.array=tempArray;
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
        Integer index = null;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(value)) {
                index = i;
            }
        }
        return index;
    }

    public String getValue(int index) {
        return this.array[index];
    }

    public String toString() {
        return "String";
    }

}
