package Tests;

import Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "testdata")
    public void loginWithValidDetails(String email, String password) throws InterruptedException {

        loginPage.clickLoginButton();
        Thread.sleep(2000);
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        Thread.sleep(2000);
        loginPage.clickSubmitButton();
        Thread.sleep(5000);
        loginPage.isLoginSuccessful();
    }

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        return new Object[][]{
                {"testingmf@gmail.com", "Testing@2026"},
        };
    }
}