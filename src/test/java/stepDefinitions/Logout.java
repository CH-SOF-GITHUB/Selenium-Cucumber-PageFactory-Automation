package stepDefinitions;

import PageFactory.LoginPage;
import PageFactory.LogoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Logout {
    WebDriver driver = new ChromeDriver();

    // Appel de la classe LoginPage
    LoginPage loginPage = new LoginPage(driver);

    // Appel de la classe LoginPage
    LogoutPage logoutPage = new LogoutPage(driver);

    @Given("je suis sur Automation Test Store")
    public void je_suis_sur_automation_test_store() {
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        // implicit wait de 10 s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur login page")
    public void jeCliqueSurLoginPage() {
        loginPage.clicLogin_page();
    }

    @And("je saisie un login name {string}")
    public void jeSaisieUnLoginName(String name) {
        loginPage.setLoginName(name);
    }

    @And("je saisie un password {string}")
    public void jeSaisieUnPassword(String password) {
        loginPage.setPassword(password);
    }

    @And("je clique sur bouton Login")
    public void jeCliqueSurBoutonLogin() {
        loginPage.clickLoginButton();
    }

    @And("je clique sur logoff en sidebar")
    public void jeCliqueSurLogoffEnSidebar() {
        logoutPage.clickLogout();
    }

    @Then("déconnexion avec succès et affichage un message de confirmation")
    public void déconnexionAvecSuccèsEtAffichageUnMessageDeConfirmation() {
        String msg = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/section/p[2]")).getText();
        if (msg.equals("You have been logged off your account. It is now safe to leave the computer.")) {
            System.out.println("déconnexion et redirection vers la page confirmation logout");
        } else {
            System.out.println("échec de déconnexion");
        }
    }

}
