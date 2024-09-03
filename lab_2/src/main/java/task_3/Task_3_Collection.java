package task_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task_3_Collection {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4,6,9,8,2,3));

        list.add(11);

        list.remove(3);
        list.remove(Integer.valueOf(9));

        list.set(4, 100);

        Collections.sort(list);

        System.out.println(list);


    }
}



