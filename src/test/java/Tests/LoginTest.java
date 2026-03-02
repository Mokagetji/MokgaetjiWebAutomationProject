package Tests;

import Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "testdata")
    public void loginWithValidDetails(String email, String password) throws InterruptedException {

        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.enrolledCoursesSection();
    }

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        return new Object[][]{
                {"testingmf@gmail.com", "Testing@2026"},
        };
    }
}