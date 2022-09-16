package day05_xpathText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathText {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.trendyol.com/");

    }

    @Test
    public void test1() throws InterruptedException {
        //aşağıdaki işleri text xpath ile çözünüz
        //cerezler i kabul et
        Thread.sleep(2000);
        WebElement cerezler = driver.findElement(By.xpath("//button[text()='KABUL ET']"));
        cerezler.click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='search-box']"));
        searchBox.sendKeys("Adidas kadın spor ayakkabı"+ Keys.ENTER);


    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }


}
