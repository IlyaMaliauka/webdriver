package bringItOn.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinMainPage {

    private static String HOMEPAGE_URL = "http:/pastebin.com";
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement pasteInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPasteButton;

    @FindBy(id = "select2-postform-format-container")
    private WebElement highlightSelectButton;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement selectBashHighlightingOption;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationSelectButton;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement selectPasteExpiration10minutesOption;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    public PastebinMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinMainPage createNewPaste(String paste, String pasteName) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        pasteInput.sendKeys(paste);
        highlightSelectButton.click();
        selectBashHighlightingOption.click();
        pasteExpirationSelectButton.click();
        selectPasteExpiration10minutesOption.click();
        pasteNameInput.sendKeys(pasteName);
        createNewPasteButton.click();

        return this;
    }

}
