package Base;

import Pages.LoginPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

BrowserFactory browserFactory = new BrowserFactory(); //creates an object of the BrowserFactory class

    public final String url = "https://ndosisimplifiedautomation.vercel.app/"; //Stores the test environment URL as a constant
    public final String browserChoice = "edge"; //Stores which browser you want to run tests in

    public WebDriver driver;
    public LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = browserFactory.startBrowser(browserChoice, url); //Starts the browser and navigates to the URL
        loginPage = new LoginPage(driver); //Initializes the LoginPage object with the WebDriver instance
    }

    @AfterMethod
    public void tearDown() {
        browserFactory.closeBrowser(); //Closes the browser after each test method
    }






}
