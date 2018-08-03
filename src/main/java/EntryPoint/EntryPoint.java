package EntryPoint;

import ListProject.CustomList;

public class EntryPoint {
    public static void main(String args[]){
        CustomList list1 = new CustomList();
        CustomList list2 = new CustomList(2);
        System.out.println(list1.print());
        System.out.println(list2.print());
        System.out.printf("list1 has %d elements\n", list1.size());
        System.out.printf("list2 has %d elements\n",list2.size());
        list1.add("test");
        list1.print();

    }
}
