package day05_xpathText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    //1)https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresinegidin
    //2) Berlin’i 3 farkli relative locator ile locate edin
    //3 ) Relative locator’larin dogru calistigini testedin
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
    }

    @Test
    public void test1() throws InterruptedException {
        //<img id="pid2_thumb" src="bots/sl-toronto-bot.png" class="ui-li-thumb">
        WebElement toronto = driver.findElement(By.cssSelector("#pid2_thumb"));
        toronto.click();
        //<img id="pid5_thumb" src="bots/sl-london-bot.png" class="ui-li-thumb">
        Thread.sleep(2000);
        WebElement london = driver.findElement(By.cssSelector("#pid5_thumb"));
        london.click();
        //<img id="pid10_thumb" src="bots/sl-mountie-bot.png" class="ui-li-thumb">
        Thread.sleep(2000);
        WebElement mountie = driver.findElement(By.cssSelector("#pid10_thumb"));
        mountie.click();
        //<img id="pid7_thumb" src="bots/sl-berlin-bot.png" class="ui-li-thumb">
        Thread.sleep(2000);
        WebElement berlin = driver.findElement(By.cssSelector("#pid7_thumb"));
        berlin.click();
        //<img id="pid6_thumb" src="bots/sl-boston-bot.png" class="ui-li-thumb">
        Thread.sleep(2000);
        WebElement boston1 = driver.findElement(with(By.id("pid6_thumb")).toRightOf(london));
        boston1.click();

        Thread.sleep(2000);
        WebElement boston2 = driver.findElement(with(By.id("pid6_thumb")).toLeftOf(berlin));
        boston2.click();

        Thread.sleep(2000);
        WebElement boston3 = driver.findElement(with(By.id("pid6_thumb")).below(toronto));
        boston3.click();

        Thread.sleep(2000);
        WebElement boston4 = driver.findElement(with(By.id("pid6_thumb")).above(mountie));
        boston4.click();


    }
}
