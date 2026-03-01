package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));// Initialize WebDriverWait with a timeout of 10 seconds
        PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
    }

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")
    WebElement loginButton;

    @FindBy(id = "login-email")
    WebElement loginEmailField;

    @FindBy(id = "login-password")
    WebElement loginPasswordField;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    @FindBy(xpath = "//div[contains(text(), \"Enrolled Courses\")]")
    WebElement dashboardFeature;

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)); // Wait until the login button is clickable
        loginButton.click();
    }

    public void enterEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOf(loginEmailField)); // Wait until the email field is visible
        loginEmailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPasswordField)); // Wait until the password field is visible
        loginPasswordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton)); // Wait until the submit button is clickable
        loginSubmitButton.click();
    }

    public boolean isLoginSuccessful() {
            wait.until(ExpectedConditions.visibilityOf(dashboardFeature)); // Wait until the dashboard feature is visible
            return dashboardFeature.isDisplayed();

    }
}