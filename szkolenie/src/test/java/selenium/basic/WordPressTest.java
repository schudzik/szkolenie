package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordPressTest {


    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chrome\\chromedriver.exe");


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void przesunieciescrolla(WebElement doelementu) {

        JavascriptExecutor je = (JavascriptExecutor) driver;

        je.executeScript("arguments[0].scrollIntoView(true);",doelementu);

    }
    @Test
    public void canFindBlog() {
        driver.get("https://automatyzacja.benedykt.net/");
        driver.findElement(By.cssSelector(".entry-title>a")).click();
        driver.findElement(By.id("comment")).sendKeys("test");
        driver.findElement(By.id("author")).sendKeys("test");
        driver.findElement(By.id("email")).sendKeys("test@pl.pl");
        przesunieciescrolla(driver.findElement(By.id("submit")));
        driver.findElement(By.id("submit")).click();
    }


    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}