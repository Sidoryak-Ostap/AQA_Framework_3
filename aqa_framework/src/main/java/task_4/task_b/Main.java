package task_4.task_b;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Person person = new Person(25, "Peter", "Parker", "Lviv");

        List<Field> fields = Arrays.asList(Person.class.getDeclaredFields());

        for(Field field: fields){
            System.out.println("Field name: " + field.getName() + ", Type: " + field.getType());
        }

        System.out.println();


        System.out.println("Before changing");
        person.displayInfo();
        System.out.println("");


        for(Field field: fields){
            if(field.getName() == "name"){
                try {
                    field.setAccessible(true);
                    field.set(person, "Andrew");
                    field.setAccessible(false);
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }

            }
        }

        System.out.println("After changing");
        person.displayInfo();

    }
}