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
import java.util.UUID;
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
        String komentarz = UUID.randomUUID().toString();
        driver.get("https://automatyzacja.benedykt.net/");
        driver.findElement(By.cssSelector(".entry-title>a")).click();
        driver.findElement(By.id("comment")).sendKeys(komentarz);
        driver.findElement(By.id("author")).sendKeys("Sylwia");
        driver.findElement(By.id("email")).sendKeys("test@pl.pl");
        przesunieciescrolla(driver.findElement(By.id("submit")));
        driver.findElement(By.id("submit")).submit();

        List<WebElement> listOfNotes = driver.findElements(By.className("comment-body"));
        Stream<WebElement> streamOfNotes = listOfNotes.stream();
        Stream<WebElement> filteredStream = streamOfNotes
                .filter(n -> n.findElement(By.tagName("p")).getText().equals(komentarz));
        List<WebElement> filteredNotes = filteredStream.collect(Collectors.toList());
        Assertions.assertEquals(1, filteredNotes.size() , "Znaleziono ");

        //driver.findElement(By.xpath("//*[@class='comment-body']//a[text()='Sylwia']/../../../../div")).getText().equals("komentarz");

    }



    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}