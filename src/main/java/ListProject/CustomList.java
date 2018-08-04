package ListProject;

public class CustomList {
    private int size;
    private int hiddenSize;
    private String[] array;

    public CustomList() {
        this.size = 1;
        this.hiddenSize=2;
        this.array = new String[this.size];
    }

    public CustomList(int size) {
        this.size = size;
        this.hiddenSize=size+1;
        String[] array = new String[this.size];
    }


    public String print() {
        return "This list has " + this.size + " elements.";
    }

    public int size() {
        return this.size;
    }

    public void add(String newString) {
        try {
            //if current array is greater than 1
            if (this.array[0]!=null) {
                //creates temp array with new index
                String[] tempArray = new String[this.size+1];
                //iterates through current array and copies values
                for (int i = 0; i < this.size; i++) {
                    tempArray[i] = this.array[i];
                }
                //increase size and assigns the new value
                this.size++;
                tempArray[this.size-1] = newString;
                //overwrites old array with new size
                this.array = new String[this.size];
                for (int i = 0; i < this.size; i++) {
                    this.array[i] = tempArray[i];
                }
            }else{ //if the current array is equal to 1
                this.array[0]=newString;
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
