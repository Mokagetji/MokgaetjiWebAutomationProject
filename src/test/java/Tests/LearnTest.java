package Tests;

import Base.BaseTest;
import Pages.LearnPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LearnTest extends BaseTest {

    @Test
    public void navigateToInventoryForm() throws InterruptedException {

        // Step 1: Login (same as LoginTest)
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress("testingmf@gmail.com");
        loginPage.enterPassword("Testing@2026");
        loginPage.clickSubmitButton();

        // Step 2: Assert login success
        Assert.assertTrue(loginPage.enrolledCoursesSection(),
                "Login was successful");

        // Step 3: Create LearnPage object
        LearnPage learnPage = new LearnPage(driver);

        // Step 4: Navigate to Learn button
        learnPage.clickLearnButton();
        learnPage.clickLearningMaterialsButton();
        learnPage.clickWebAutomationAdvanceButton();

        //Step 5: Assert navigation to Inventory Form page
        Assert.assertTrue(learnPage.isInventoryFormDisplayed(),
                "Navigated to Inventory Form page");

        learnPage.selectDeviceType("phone");
        learnPage.selectDeviceBrand("apple");

        Assert.assertTrue(learnPage.isDeviceBrandDropdownDisplayed(),
                "Device brand dropdown is displayed");

        Assert.assertTrue(learnPage.isDevicePreviewDisplayed(),
                "Device preview is displayed");

        learnPage.selectStorageOption("128GB");

        Assert.assertTrue(learnPage.isUnitPriceDisplayed(),
                "Unit price is displayed");

        learnPage.selectColor("blue");

        //for(WebElement color : colorFields){
            //System.out.println(color.getText());
            //Assert.assertTrue(color.isDisplayed(),
                    //"Color option is displayed");
       // }

        learnPage.enterQuantity(2);

        String expectedSubtotal = "Subtotal R960.00";
        Assert.assertEquals(learnPage.getSubtotalText(), expectedSubtotal,
                "Subtotal is calculated correctly");




    }
}
