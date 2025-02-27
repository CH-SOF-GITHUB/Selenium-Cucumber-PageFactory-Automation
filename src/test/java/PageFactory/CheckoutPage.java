package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

        // initialisation des tous les web élèments pour etre utilisable dans les autres classes
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cart_checkout1")
    WebElement CheckoutBtn;

    @FindBy(id = "checkout_btn")
    WebElement ConfirmBtn;

    public void clickCheckoutBtn() {
        CheckoutBtn.click();
    }

    public void clickConfirmBtn() {
        ConfirmBtn.click();
    }
}
