package stepDefinitions;

import PageFactory.LoginPage;
import PageFactory.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddProduct {
    // controle et ouverture d'un navigateur Chrome
    WebDriver driver = new ChromeDriver();
    // créer une instance de la classe LoginPage
    LoginPage loginPage = new LoginPage(driver);
    // créer une instance de la classe ProductPage
    ProductPage productPage = new ProductPage(driver);
    // Liste des noms des produits
    List<String> names = new ArrayList<>();

    @Given("je suis sur le site e-commerce Automation Test Store")
    public void je_suis_sur_le_site_e_commerce_automation_test_store() {
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        // implicit wait de 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur la page login")
    public void jeCliqueSurLaPageLogin() {
        loginPage.clicLogin_page();
    }

    @And("je saisie login name {string}")
    public void jeSaisieLoginName(String name) {
        loginPage.setLoginName(name);
    }

    @And("je saisie mot de passe {string}")
    public void jeSaisieMotDePasse(String password) {
        loginPage.setPassword(password);
    }

    @And("je clique sur le bouton Login")
    public void jeCliqueSurLeBoutonLogin() {
        loginPage.clickLoginButton();
    }

    @And("je clique sur une catégorie du produit {string}")
    public void jeCliqueSurUneCatégorieDuProduit(String categorie) {
        productPage.clicCategory(categorie.toUpperCase());
    }

    @And("je clique sur un produit {string}")
    public void jeCliqueSurUnProduit(String produit) {
        productPage.clicProduct(produit.toUpperCase());
        names.add(produit);
    }

    @And("je clique sur le bouton add to chart")
    public void jeCliqueSurLeBoutonAddToChart() {
        productPage.clickAddToCart();
    }

    @And("je clique autre fois sur la catégorie du produit {string}")
    public void jeCliqueAutreFoisSurLaCatégorieDuProduit(String categorie) {
        productPage.clicCategory(categorie.toUpperCase());
    }

    @And("je clique sur le produit {string}")
    public void jeCliqueSurLeProduit(String produit) {
        productPage.clicProduct(produit.toUpperCase());
        names.add(produit);
    }

    @And("je clique sur un bouton add to chart")
    public void jeCliqueSurUnBoutonAddToChart() {
        productPage.clickAddToCart();
    }

    @Then("ajout des produits au panier")
    public void ajoutDesProduitsAuPanier() {
        String table = productPage.getContainsTableProduct();

        // vérifier que les produits sont ajoutés au panier
        for (int i = 0; i < names.size(); i++) {
            if (table.contains(names.get(i))) {
                System.out.println("le produit " + names.get(i) + " est ajout avec succès");
            } else {
                System.out.println("échec d'ajout le produit " + names.get(i));
            }

        }
    }
}
