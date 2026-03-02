package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LearnPage {

    WebDriver driver;
    WebDriverWait wait;

    public LearnPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[normalize-space()='Learn']")
    WebElement learnButton;

    @FindBy(xpath = "//span[normalize-space()='Learning Materials']")
    WebElement learningMaterialsButton;


    @FindBy(xpath = "//span[normalize-space()='Web Automation Advance']")
    WebElement webAutomationAdvanceButton;

    @FindBy(id = "inventory-title")
    WebElement InventoryTitle;

    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    @FindBy(id = "brand")
    WebElement deviceBrandDropdown;

    @FindBy(id= "device-preview")
    WebElement devicePreview;

    @FindBy(id  = "storage-128GB")
    WebElement selectedStorage;

    @FindBy(id = "unit-price-label")
    WebElement unitPriceDisplayed;

    @FindBy(id = "color")
    WebElement colorDropdown;

   // @FindBy(xpath = "//div[@id='device-preview']//div[contains(@class,'color')]")
   // List<WebElement> colorFields;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "subtotal-label")
    WebElement subtotalDisplayed;


public void clickLearnButton() {
    wait.until(ExpectedConditions.elementToBeClickable(learnButton));
    learnButton.click();
}

public void clickLearningMaterialsButton() {
    wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsButton));
    learningMaterialsButton.click();

}

public void clickWebAutomationAdvanceButton() {
    wait.until(ExpectedConditions.elementToBeClickable(webAutomationAdvanceButton));
    webAutomationAdvanceButton.click();
}
    public boolean isInventoryFormDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(InventoryTitle));
        return InventoryTitle.isDisplayed();
    }

    public void selectDeviceType(String deviceType) {
        wait.until(ExpectedConditions.visibilityOf(deviceTypeDropdown));
        Select select = new Select(deviceTypeDropdown);
        select.selectByValue("phone");
    }

    public boolean isDeviceBrandDropdownDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(deviceBrandDropdown));
        return deviceBrandDropdown.isDisplayed();
    }

    public void selectDeviceBrand(String deviceBrand) {
        wait.until(ExpectedConditions.visibilityOf(deviceBrandDropdown));
        Select select = new Select(deviceBrandDropdown);
        select.selectByValue("apple");
    }

    public boolean isDevicePreviewDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(devicePreview));
        return devicePreview.isDisplayed();
    }

    public void selectStorageOption(String storageOption) {
        wait.until(ExpectedConditions.visibilityOf(selectedStorage));
        selectedStorage.click();
    }

    public boolean isUnitPriceDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(unitPriceDisplayed));
        return unitPriceDisplayed.isDisplayed();
    }

    public void selectColor(String color) {
        wait.until(ExpectedConditions.visibilityOf(colorDropdown));
        Select select = new Select(colorDropdown);
        select.selectByValue("blue");
    }

    //public boolean isColorOptionDisplayed(String color) {
        //wait.until(ExpectedConditions.visibilityOf(colorDropdown));
        //for (WebElement colorField : colorFields) {
            //if (colorField.getAttribute("blue").equalsIgnoreCase(color)) {
               // return true;
           //}
        //}
        //return false;

    //}

    public void enterQuantity(int quantity) {
        wait.until(ExpectedConditions.visibilityOf(quantityInput));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }
    public String getSubtotalText() {
        wait.until(ExpectedConditions.visibilityOf(subtotalDisplayed));
    return subtotalDisplayed.getText().trim();

}
}


