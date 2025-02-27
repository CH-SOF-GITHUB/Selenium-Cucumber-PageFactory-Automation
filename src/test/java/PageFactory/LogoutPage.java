package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        // initialisation de tous les web élèments pour etre utilisable dans les autres classes
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[2]/div[1]/div/ul/li[10]/a")
    WebElement logooff;

    public void clickLogout() {
        logooff.click();
    }

}
