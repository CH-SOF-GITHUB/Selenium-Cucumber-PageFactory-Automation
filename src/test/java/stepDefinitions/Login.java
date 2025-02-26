package stepDefinitions;

import PageFactory.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
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

    @Then("connexion avec succès pour données valides et échec de connexion et affichage un message d'erreur pour les données invalides")
    public void connexionAvecSuccèsPourDonnéesValidesEtÉchecDeConnexionEtAffichageUnMessageDErreurPourLesDonnéesInvalides() {
        String url = driver.getCurrentUrl();
        if (url.equals("https://automationteststore.com/index.php?rt=account/account")) {
            System.out.println("connexion avec succès et redirection vers la page d'accueil");
        } else {
            System.out.println("échec de connexion et affichage d'un message d'erreur");
        }
    }
}
