package hardcore.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open('https://www.google.com');");
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.switchTo().window(tabs2.get(0));
    }
}
