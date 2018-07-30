package ListProject;

public class CustomList {
    private int size;

    public CustomList(){

    }
    public CustomList(int size){
        this.size=size;
    }

    public String print(){
        return "This list has " + this.size+ " elements.";
    }

    public int size(){
        return size;
    }
}
