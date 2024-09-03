package task_4.task_c;

import java.util.ArrayList;
import java.util.List;

public class Store<T> {

    private List<T> list = new ArrayList<>();

    public void addElement(T element){
        this.list.add(element);
    }

    public void displayList(){
        System.out.println(this.list);
    }



}
