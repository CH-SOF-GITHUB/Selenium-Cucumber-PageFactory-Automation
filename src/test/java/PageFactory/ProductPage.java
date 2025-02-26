package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    // déclaration d'un web driver
    WebDriver driver;

    // constructor de classe ProductPage
    public ProductPage(WebDriver driver) {
        this.driver = driver;

        // initialisation des tous les web élèments pour etre utilisable dans les autres classes
        PageFactory.initElements(driver, this);
    }

    //@FindBy(linkText = "")
    WebElement categoryLink;

    //@FindBy(linkText = "")
    WebElement productLink;

    @FindBy(className = "productpagecart")
    WebElement btnAddToCart;

    @FindBy(className = "product-list")
    WebElement table_product_list;

    public void clicCategory(String category) {
        categoryLink = driver.findElement(By.linkText(category));
        categoryLink.click();
    }

    public void clicProduct(String product) {
        productLink = driver.findElement(By.linkText(product));
        productLink.click();
    }

    public void clickAddToCart() {
        btnAddToCart.click();
    }

    public String getContainsTableProduct() {
        return table_product_list.getText();
    }

}
