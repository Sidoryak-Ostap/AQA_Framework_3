package task_2;

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



    public Day getNextDay(Day day) {
        switch (day) {
            case SUNDAY:
                return Day.MONDAY;
            case MONDAY:
                return Day.TUESDAY;
            case TUESDAY:
                return Day.WEDNESDAY;
            case WEDNESDAY:
                return Day.THURSDAY;
            case THURSDAY:
                return Day.FRIDAY;
            case FRIDAY:
                return Day.SATURDAY;
            case SATURDAY:
                return Day.SUNDAY;
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    public boolean isWeekend(Day day) {
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }

    public int getDaysUntilWeekend(Day day) {
        switch (day) {
            case MONDAY:
                return 5;
            case TUESDAY:
                return 4;
            case WEDNESDAY:
                return 3;
            case THURSDAY:
                return 2;
            case FRIDAY:
                return 1;
            case SATURDAY:
            case SUNDAY:
                return 0;
            default:
                return -1;
        }
    }
}
