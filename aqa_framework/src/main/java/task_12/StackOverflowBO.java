package task_12;

import org.testng.Assert;

public class StackOverflowBO {


    private StackOverflowPO homePage;

    public StackOverflowBO openStackOvAboutTab(){
        homePage = new StackOverflowPO("https://stackoverflow.com/");
        homePage.getAboutTab().click();
        return this;
    }

    public StackOverflowBO verifyStackOvAboutHeader () {
        homePage.getAboutHeader().waitForHeaderToBeVisible();
        homePage.getAboutHeader().getText();


        Assert.assertTrue(homePage.getAboutHeader().verifyHeaderText("Empowering the world to develop technology through collective knowledge."));
        return this;
    }
}
