package ListProject;

public class CustomList {
    private int size;
    private String[] array;

    public CustomList(){
        String[] array =new String[1];
    }
    public CustomList(int size){
        this.size=size;
        String[] array=new String[this.size];
    }

    public String print(){
        return "This list has " + this.size+ " elements.";
    }

    public int size(){
        return size;
    }

   /* lspublic void add(String newString){

    }

    public String delete(int index){

    }

    public int indexOf(String value){

    }

    public String getValue(int index){

    }

    public String toString(){

    }*/

}
