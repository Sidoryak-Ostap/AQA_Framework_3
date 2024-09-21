package task_4.task_c;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Store store = new Store();


        store.addElement(5);
        store.addElement("Lviv");
        store.addElement('c');
        store.addElement(new Date());

        store.displayList();

    }
}