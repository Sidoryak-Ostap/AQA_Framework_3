package task_3;

public class Task3_Exception {
    public static void main(String[] args) {
        int num = 10;
        try {
            int result = num/0;
        } catch (ArithmeticException e){
            System.err.println("Can not divide by 0");
        }
    }
}