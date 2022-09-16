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

public class CssSelector {
    //1. Bir class oluşturun : Locators_css
    //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    //a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
    //b. Locate email textbox
    //c. Locate password textbox ve
    //d. Locate signin button
    //e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini
    //tıklayın
    //i. Username : testtechproed@gmail.com
    //ii. Password : Test1234!

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
    }
    @Test
    public void test1() throws InterruptedException {
        //b. Locate email textbox
        //c. Locate password textbox ve
        //d. Locate signin button

        //<input type="email" class="form-control" placeholder="Email" data-test="email"
        // name="session[email]" id="session_email">

        WebElement email = driver.findElement(By.cssSelector(".form-control"));//class yerine . işareti
        //<input class="form-control" placeholder="Password" data-test="password"
        // type="password" name="session[password]" id="session_password">

        WebElement password = driver.findElement(By.cssSelector("#session_password"));//id yerine # işareti
        //<input type="submit" name="commit" value="Sign in" class="btn btn-primary"
        // data-test="submit" data-disable-with="Sign in">

        WebElement signIn = driver.findElement(By.cssSelector("input[type='submit']"));// açıkca yazdık

        //e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini
        //tıklayın
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!

        email.sendKeys("testtechproed@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("Test1234!");
        Thread.sleep(2000);
        signIn.submit();
    }
    @AfterClass
    public static void tearDown(){
      driver.quit();
    }
}
