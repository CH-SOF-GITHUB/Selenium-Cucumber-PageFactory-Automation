package stepDefinitions;

import PageFactory.CheckoutPage;
import PageFactory.LoginPage;
import PageFactory.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Checkout {
    // déclaration d'un web driver: controle et ouverture d'un navigateur chrome
    WebDriver driver = new ChromeDriver();
    // déclaration d'une instance de classe LoginPage
    LoginPage loginPage = new LoginPage(driver);
    // déclaration d'une instance de classe ProductPage
    ProductPage productPage = new ProductPage(driver);
    // déclaration d'une instance de classe CheckoutPage
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("je suis sur un site e-commerce Automation Test Store")
    public void je_suis_sur_un_site_e_commerce_automation_test_store() {
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        // implicit wait de 10 s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur un lien login page")
    public void jeCliqueSurUnLienLoginPage() {
        loginPage.clicLogin_page();
    }

    @And("je saisie un loginname {string}")
    public void jeSaisieUnLoginname(String name) {
        loginPage.setLoginName(name);
    }

    @And("je saisie un mot de passe {string}")
    public void jeSaisieUnMotDePasse(String password) {
        loginPage.setPassword(password);
    }

    @And("je clique sur un bouton Login")
    public void jeCliqueSurUnBoutonLogin() {
        loginPage.clickLoginButton();
    }

    @And("je clique sur une categorie {string}")
    public void jeCliqueSurUneCategorie(String categorie) {
        productPage.clicCategory(categorie.toUpperCase());
    }

    @And("je clique sur produit {string}")
    public void jeCliqueSurProduit(String produit) {
        productPage.clicProduct(produit.toUpperCase());
    }

    @And("je clique sur add to chart du produit {string}")
    public void jeCliqueSurAddToChartDuProduit(String produit) {
        productPage.clickAddToCart();
        System.out.println("je clique sur le bouton add to chart du produit: " + produit);
    }

    @And("je clique sur un bouton Checkout")
    public void jeCliqueSurUnBoutonCheckout() {
        checkoutPage.clickCheckoutBtn();
    }

    @And("je clique sur un bouton Confirm Order")
    public void jeCliqueSurUnBoutonConfirmOrder() {
        checkoutPage.clickConfirmBtn();
    }

    @Then("la confirmation et le paiement des produits avec succès")
    public void laConfirmationEtLePaiementDesProduitsAvecSuccès() throws InterruptedException {
        // blocage le programme et attendre un temps de 3s
        Thread.sleep(3000);
        String msg_confirm = driver.findElement(By.className("maintext")).getText();
        System.out.println(msg_confirm);
        if (msg_confirm.equals("YOUR ORDER HAS BEEN PROCESSED!")) {
            System.out.println("confirmation Checkout avec succès");
        } else {
            System.out.println("échec confirmation Checkout");
        }
    }
}
