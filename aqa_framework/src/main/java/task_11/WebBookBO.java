package task_11;


import org.openqa.selenium.WebElement;


public class WebBookBO {

    private WebBookPO webBookPO = new WebBookPO();
    public WebBookBO goToBookStore() {
        DriverProvider.getDriver().get("https://demoqa.com/books");
        return this;
    }

    public WebBookBO focusInput(){

        webBookPO.getSearchInput().isDisplayed();
        webBookPO.getSearchInput().click();
        return this;
    }

    public WebBookBO fillInput(String inputValue) {
        webBookPO.getSearchInput().sendKeys(inputValue);
        return this;
    }

    public WebBookBO clickSearchButton(){
        webBookPO.getSearchButton().click();
        return this;
    }

    public WebBookBO verifyResult() {
        if(webBookPO.getFoundBook().isDisplayed()) {
            System.out.println("Book was found with text" + " " + webBookPO.getFoundBook().getText());
        }
        return this;

    }
}
