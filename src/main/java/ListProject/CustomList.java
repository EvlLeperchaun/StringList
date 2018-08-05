package ListProject;

public class CustomList {
    private int size;
    private String[] array;
    private boolean isEmpty;

    public CustomList() {
        this.size = 1;
        this.array = new String[this.size];
        isEmpty = true;
    }

    public CustomList(int size) {
        this.size = size;
        this.array = new String[this.size];
        isEmpty = true;
    }


    public String print() {
        return "This list has " + this.size + " elements.";
    }

    public int size() {
        return this.size;
    }

    public void add(String newString) {
        boolean stop = false;
        try {
            //if current array is empty
            if (this.isEmpty == true) {
                for (int i = 0; i < this.size; i++) {
                    //replaces first null with new string
                    if (this.array[i] == null && stop == false) {
                        this.array[i] = newString;
                        stop = true;
                    }
                    //checks if current i is last entry and isn't null
                    if (i+1==this.size && this.array[i] != null) {
                        this.isEmpty = false;
                    }

                }
                //if current array is full
            } else if (this.isEmpty == false) {
                //creates temp array with new index
                String[] tempArray = new String[this.size + 1];
                //iterates through current array and copies values
                for (int i = 0; i < this.size; i++) {
                    tempArray[i] = this.array[i];
                }
                //increase size and assigns the new value
                this.size++;
                tempArray[this.size - 1] = newString;
                //overwrites old array with new size
                this.array = new String[this.size];
                for (int i = 0; i < this.size; i++) {
                    this.array[i] = tempArray[i];
                }
            }


        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
        } catch (Exception e) {
            System.out.println("Other Exception thrown.");
        }

    }

    public String delete(int index) {
        return "String";
    }

    public int indexOf(String value) {
        return 1;
    }

    public String getValue(int index) {
        return this.array[index];
    }

    public String toString() {
        return "String";
    }

}
