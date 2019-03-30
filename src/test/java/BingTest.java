import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

public class BingTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.bing.com");
    }

    @Test
    public void testSearch() throws InterruptedException {
        WebElement szukajka = driver.findElement(By.name("q"));
       szukajka.clear();
       szukajka.sendKeys("Mistrzostwa Świata w piłce nożnej 2018");
       szukajka.submit();

       Thread.sleep(5000);

       WebElement link = driver.findElement(By.xpath("/html/body/div[2]/main/ol/li[2]/div[1]/h2/a"));
        String textLinku = link.getText();
       String oczekiwanyText = "Mistrzostwa Świata w Piłce Nożnej 2018 – Wikipedia, …";
       System.out.println("Tekst linku:" + textLinku);
       assertTrue(textLinku.equals(oczekiwanyText));
    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
