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

    @Parameters({ "input, result" })
    public void IsWeekendWithParameterTest(Day input, boolean result){

        Boolean actualResult = main.isWeekend(input);
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



    @Test(dataProvider = "DaysUntilWeekendProvider")
    public void DaysUntilWeekendTest(Day day, int expectedResult){

        int actualResult = main.getDaysUntilWeekend(day);
        Assert.assertEquals(expectedResult, actualResult, "Unexpected result");
    }




    @Test
    public void testGetNextDay(){
    Day day = Day.TUESDAY;

    Day expectedResult = Day.WEDNESDAY;
    Day actualResult = main.getNextDay(day);
    Assert.assertEquals(expectedResult, actualResult, "Unexpected result");

    }
}
