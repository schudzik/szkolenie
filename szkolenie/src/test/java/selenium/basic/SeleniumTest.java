package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
       driver = new ChromeDriver();
    }


    @Test
    public void canFindCodeSprintersOnGoogle() {
   System.setProperty("webdriver.chrome.driver","c:\\drivers\\chrome\\chromedriver.exe");
        driver.get("https://google.com");
      WebElement searchBox = driver.findElement(By.name("q"));
      searchBox.sendKeys("code sprinters");
      searchBox.submit();
        Stream<WebElement> searchResults = driver.findElements(By.cssSelector("div.rc")).stream();
        Stream<WebElement> resultFiltered  = searchResults.filter(r -> r.findElement(By.cssSelector("div.r > a")).getAttribute("href").equals("http://agileszkolenia.pl/"));
        List<WebElement> resultList  = resultFiltered.collect(Collectors.toList());
        Assertions.assertEquals(1 , resultList.size());
        WebElement result  = resultList.get(0);
        Assertions.assertEquals("agileszkolenia.pl/" , driver.findElement(By.tagName("cite")).getText());

    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}

