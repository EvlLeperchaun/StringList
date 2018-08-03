package ListProject;

public class CustomList {
    private int size;
    private String[] array;

    public CustomList() {
        this.size=1;
        String[] array = new String[size];
    }

    public CustomList(int size) {
        this.size = size;
        String[] array = new String[this.size];
    }

    public String print() {
        return "This list has " + this.size + " elements.";
    }

    public int size() {
        return this.size;
    }

    public void add(String newString) {
        String[] tempArray = new String[this.size+1];
        for (int i=0;i<this.size;i++){
            tempArray[i]=this.array[i];
        }
        this.size++;
        tempArray[size-1]=newString;
        String[] array=new String[this.size];
        for (int i=0;i<this.size;i++){
            this.array[i]=tempArray[i];
        }

        }

    public String delete(int index) {
        return "String";
    }

    public int indexOf(String value) {
        return 1;
    }

    public String getValue(int index) {
        return "String";
    }

    public String toString() {
        return "String";
    }

}
