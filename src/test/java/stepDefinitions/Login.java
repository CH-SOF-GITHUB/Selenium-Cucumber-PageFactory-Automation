package stepDefinitions;

import PageFactory.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login {
    WebDriver driver = new ChromeDriver();

    // Appel de la classe LoginPage
    LoginPage loginPage = new LoginPage(driver);

    @Given("je suis sur la page home de site Automation Test Store")
    public void je_suis_sur_la_page_home_de_site_automation_test_store() {
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        // implicit wait de 10 s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur Login or Register")
    public void jeCliqueSurLoginOrRegister() {
        loginPage.clicLogin_page();
    }

    @And("je saisie username {string}")
    public void jeSaisieUsername(String username) {
        loginPage.setLoginName(username);
    }

    @And("je saisie password {string}")
    public void jeSaisiePassword(String password) {
        loginPage.setPassword(password);
    }

    @And("je clique sur le bouton de connexion")
    public void jeCliqueSurLeBoutonDeConnexion() {
        loginPage.clickLoginButton();
    }

    @Then("connexion avec succès pour données valides")
    public void connexionAvecSuccèsPourDonnéesValides() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://automationteststore.com/index.php?rt=account/account", url);
        System.out.println("connexion avec succès avec des données valides et redirection vers la page d'accueil");
        /*if (url.equals("https://automationteststore.com/index.php?rt=account/account")) {
            System.out.println("connexion avec succès avec des données valides");
        } else {
            System.out.println("échec de connexion avec des données valides et affichage d'un message d'erreur");
        }*/
    }

    @Then("échec de connexion et affichage un message d'erreur pour les données invalides")
    public void échecDeConnexionEtAffichageUnMessageDErreurPourLesDonnéesInvalides() {
        try {
            WebElement Error = driver.findElement(By.className("alert-error"));
            String errorMessage = Error.getText();
            Assert.assertTrue(errorMessage.contains("Error: Incorrect login or password provided."));
            System.out.println("échec de connexion et affichage d'un message d'erreur: 'Error: Incorrect login or password provided.'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
