package task_4.task_b;

public class Person {

    private int age;
    private String name;
    private String surname;
    private String address;

    public Person(int age, String name, String surname, String address){
        this.address = address;
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public void displayInfo(){
        System.out.println("Name - "+ this.name);
        System.out.println("Surname - "+ this.surname);
        System.out.println("Age - "+ this.age);
        System.out.println("Address - "+ this.address);
    }
}
