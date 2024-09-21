package task_8;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task_2.Day;
import task_2.Main;

public class Task8Test {

    Main main;

    @BeforeTest
    void init(){
        main = new Main();
    }

    @DataProvider
    public Object[][] isWeekendProvider() {
        return new Object[][] {
                { Day.FRIDAY, false },
                { Day.SUNDAY, true },
                { Day.WEDNESDAY, false }
        };
    }

    @Test(dataProvider = "isWeekendProvider")
    public void IsWeekendTest(Day day, boolean expectedResult){

        Boolean actualResult = main.isWeekend(day);
        Assert.assertEquals(expectedResult, actualResult, "Unexpected result");
    }

    @Test
    @Parameters({ "input" ,"result" })
    public void IsWeekendWithParameterTest(String input, boolean result){
        Day day = Day.valueOf(input);
        Boolean actualResult = main.isWeekend(day);
        Assert.assertEquals(result, actualResult, "Unexpected result");
    }



    @DataProvider
    public Object[][] DaysUntilWeekendProvider() {
        return new Object[][] {
                { Day.MONDAY, 5 },
                { Day.TUESDAY, 4 },
                { Day.FRIDAY, 1 }
        };
    }



    @Test()
    @Parameters({ "input", "result" })
    public void DaysUntilWeekendWithParameterTest(String input, int expectedResult){
        int actualResult = main.getDaysUntilWeekend(Day.valueOf(input));
        Assert.assertEquals(expectedResult, actualResult, "Unexpected result");
    }


    @Test(dataProvider = "DaysUntilWeekendProvider")
    public void DaysUntilWeekendTest(Day day, int expectedResult){

        int actualResult = main.getDaysUntilWeekend(day);
        Assert.assertEquals(expectedResult, actualResult, "Unexpected result");
    }



    @DataProvider
    public Object[][] GetNextDayProvider() {
        return new Object[][] {
                { Day.MONDAY, Day.TUESDAY },
                { Day.TUESDAY, Day.WEDNESDAY },
                { Day.FRIDAY, Day.SATURDAY }
        };
    }

    @Test(dataProvider = "GetNextDayProvider")
    public void testGetNextDay(Day input, Day expectedResult){
        Day actualResult = main.getNextDay(input);
        Assert.assertEquals(expectedResult, actualResult, "Unexpected result");

    }

    @Test()
    @Parameters({"input", "result"})
    public void GetNextDayWithParameterTest(String input, String result){
        Day actualResult = main.getNextDay(Day.valueOf(input));
        Assert.assertEquals(Day.valueOf(result), actualResult, "Unexpected result");

    }
}
