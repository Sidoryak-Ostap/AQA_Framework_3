public class Main {
    public static void main(String[] args){

        Day day = Day.FRIDAY;
        switch (day){
            case  day.SUNDAY: {
                System.out.println("Today is Sunday");
                break;
            }
            case  day.MONDAY: {
                System.out.println("Today is Monday");
                break;
            }
            case  day.TUESDAY: {
                System.out.println("Today is Tuesday");
                break;
            }
            case  day.WEDNESDAY: {
                System.out.println("Today is Wednesday");
                break;
            }
            case  day.THURSDAY: {
                System.out.println("Today is Thursday");
                break;
            }
            case  day.FRIDAY: {
                System.out.println("Today is Friday");
                break;
            }
            case  day.SATURDAY: {
                System.out.println("Today is Saturday");
                break;
            }
            default:
                System.out.println("Incorect day");
        }
    }
}
