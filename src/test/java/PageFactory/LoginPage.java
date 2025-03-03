package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    // déclaration d'un Web Driver
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // initialisation de tous les web élèments pour etre utilisable dans les autres classes
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer_menu_top")
    WebElement Login_or_register;

    @FindBy(id = "loginFrm_loginname")
    WebElement LoginName;

    @FindBy(id = "loginFrm_password")
    WebElement Password;

    @FindBy(xpath = "//button[@title=\"Login\"]")
    WebElement LoginButton;

    public void clicLogin_page() {
        Login_or_register.click();
    }

    public void setLoginName(String name) {
        LoginName.sendKeys(name);
    }

    public void setPassword(String password) {
        Password.sendKeys(password);
    }

    public void clickLoginButton() {
        LoginButton.click();
    }

    public void verifyResultat(WebElement element, String someText, String message) {
        assertTrue(element.getText().contains(someText), message);
    }
}
