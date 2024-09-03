package task_3;

public class Task3_Array {

    public static void main(String[] args){
        int[] array = {5,9,6,3,4};

        System.out.println("Before reversing");
        print(array);

        System.out.println("After reversing");

        print(reverseArray(array));
    }


    public static int[] reverseArray(int[] arr){
        int[] newAray = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            newAray[i] = arr[arr.length-1-i];
        }

        return  newAray;
    }

     static void print(int[] arr){
        for(int e: arr){
            System.out.print(e);
        }
         System.out.println();
    }
}


