package password.check;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.ThreadLocalRandom;


public class PasswordGeneratorCheck {

        WebDriver driver;

    @Test
    public void passwordGeneratorCheckForNull() {
        System.setProperty("webdriver.chrome.driver","libs/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://passwordsgenerator.net/ru/");

        driver.findElement(By.xpath("//div[@class='button GenerateBtn']")).click();

        String password =  driver.findElement(By.xpath("//input[@id='final_pass']")).getAttribute("value");

        if (password.equals("")) {
            System.out.println("в поле пароля пустое значение");
        }

        driver.findElement(By.xpath("//div[@class='button GenerateBtn']")).click();

        if (password.equals(driver.findElement(By.xpath("//input[@id='final_pass']")).getAttribute("value"))){
            System.out.println("Новый сгенерированный пароль совпадает с предыдущим");
        }

        driver.findElement(By.xpath("//input[@id='Symbols']")).click();

        int randomNum = ThreadLocalRandom.current().nextInt(6, 128);

        String randomLength= "//option[@value='" + randomNum + "']";

        driver.findElement(By.xpath(randomLength)).click();

        driver.findElement(By.xpath("//div[@class='button GenerateBtn']")).click();

        if (driver.findElement(By.xpath("//input[@id='final_pass']")).getAttribute("value").length() == randomNum) {
            System.out.println("Длина пароля: " + randomNum);
        }
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
