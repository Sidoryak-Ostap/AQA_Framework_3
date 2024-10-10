package task_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static task_11.DriverProvider.getDriver;

public class WebBookPO {


    @FindBy(id = "searchBox")
    WebElement seacrhBox;
    @FindBy(id = "basic-addon2")
    WebElement searchButton;

    @FindBy(id = "see-book-Learning JavaScript Design Patterns")
    WebElement foundBook;

    public WebBookPO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getSearchInput() {
        return seacrhBox;
    }
    public WebElement getSearchButton(){
        return searchButton;
    }

    public WebElement getFoundBook() {
        return foundBook;
    }
}
