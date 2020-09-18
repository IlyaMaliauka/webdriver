package bringItOn.test;

import bringItOn.page.PastebinMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTest {

    private WebDriver driver;
    private String paste = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String pasteName = "how to get dominance among developers";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        PastebinMainPage page = new PastebinMainPage(driver);
        page.openPage();
        page.createNewPaste(paste, pasteName);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleIs(pasteName + " - Pastebin.com"));
    }

    @Test(description = "test1")
    public void testPageNameEqualsPasteName() {
        String checker = driver.getTitle();
        Assert.assertEquals(pasteName + " - Pastebin.com", checker);
    }

    @Test(description = "test2")
    public void testTextIsBashHighlighted() {
        WebElement bashButton = driver.findElement(By.xpath("//*[@href='/archive/bash']"));
        Assert.assertTrue(bashButton.isDisplayed());
    }

    @Test(description = "test3")
    public void testPasteTextIsCorrect() {
        WebElement textArea = driver.findElement(By.xpath("//div[@class='post-view']//textarea"));
        Assert.assertEquals(textArea.getText(), paste);
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
