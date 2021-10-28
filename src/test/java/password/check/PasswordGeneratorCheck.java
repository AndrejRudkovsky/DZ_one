package password.check;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordGeneratorCheck {

    @Test
    void passwordGeneratorCheckForNull() {
        System.setProperty("webdriver.chrome.driver","libs/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://passwordsgenerator.net/ru/");

        driver.findElement(By.xpath("//div[contains(@class, 'button GenerateBtn')]")).click();

        //WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element =  driver.findElement(By.xpath("//input[@id='final_pass']"));
        String password = element.getAttribute("value");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[(@id, 'final_pass') and (.!,'')]")));



        System.out.println(password);

    }
}
