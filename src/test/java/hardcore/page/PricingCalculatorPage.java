package hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculatorPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement firstFrame;

    @FindBy(id = "myFrame")
    private WebElement secondFrame;

    @FindBy(id = "input_60")
    private WebElement numberOfInstancesInput;

    @FindBy(id = "select_value_label_57")
    private WebElement machineTypeSelectButton;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement standart8option;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//*[@id='select_value_label_371']")
    private WebElement selectGPUType;

    @FindBy(xpath = "//*[@id='select_option_385']")
    private WebElement selectTESLAT4;

    @FindBy(xpath = "//*[@id='select_value_label_192']")
    private WebElement selectSSD;

    @FindBy(xpath = "//*[@id='select_option_257']")
    private WebElement select2x375GB;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement estimateButton;

    @FindBy(id = "email_quote")
    private WebElement emailEstimateButton;


    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FakeMailHomePage estimatePricing() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("input_60")));
        numberOfInstancesInput.sendKeys("4");
        jse.executeScript("scroll(0, 1050);");
        machineTypeSelectButton.click();
        jse.executeScript("scroll(0, 1050);");
        standart8option.click();
        jse.executeScript("scroll(0, 500);");
        addGPUsCheckbox.click();
        selectGPUType.click();
        selectTESLAT4.click();
        selectSSD.click();
        select2x375GB.click();
        jse.executeScript("scroll(0, 5000);");
        estimateButton.click();
        emailEstimateButton.click();

        return new FakeMailHomePage(driver);
    }
}
