package task_12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StackOverflowPO {

    @FindBy(xpath = "//a[text()='About']\n")
    WebElement stackOvAboutTab;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/header/div/h1")
    HeaderElement stackOvAboutHeader;

    public StackOverflowPO(String pageUrl) {
        PageFactory.initElements(new FieldDecorator(DriverProvider.getDriver()), this);
        DriverProvider.getDriver().get(pageUrl);
    }

    public WebElement getAboutTab(){
        return stackOvAboutTab;
    }

    public HeaderElement getAboutHeader(){
        return stackOvAboutHeader;
    }
}
