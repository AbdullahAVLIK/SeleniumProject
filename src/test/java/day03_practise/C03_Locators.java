package day03_practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/reseurces/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. http://a.testaddressbook.com adresine gidiniz.

        driver.get("http://a.testaddressbook.com");
        //b. Sign in butonuna basin
        //<a id="sign-in" class="nav-item nav-link" data-test="sign-in" href="/sign_in">Sign in</a>
        WebElement signIn = driver.findElement(By.id("sign-in"));
        signIn.click();
        //c email textbox,password textbox, and signin button elementlerini locate
        //<input type="email" class="form-control" placeholder="Email"
        // data-test="email" name="session[email]" id="session_email">
        WebElement email = driver.findElement(By.id("session_email"));
        //<input class="form-control" placeholder="Password"
        // data-test="password" type="password" name="session[password]" id="session_password">
        WebElement password = driver.findElement(By.id("session_password"));

        //. Kullanıcı adını ve şifreyi aşağıya girin
        //i. Username :
        //testtechproed@gmail.com
        //ii. Password : Test1234!
        email.sendKeys("testtechproed@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("Test1234!");
        Thread.sleep(2000);

        //oturum aç (sign i n)buttonunu tıklayın:
        //<input type="submit" name="commit" value="Sign in"
        // class="btn btn-primary" data-test="submit" data-disable-with="Sign in">
        WebElement oturumAc = driver.findElement(By.name("commit"));
        oturumAc.click();
        //e. Expected user id nin
        //testtechproed@gmail.com oldugunu dogrulayin(verify).
        //<span class="navbar-text" data-test="current-user">testtechproed@gmail.com</span>
        WebElement userId = driver.findElement(By.className("navbar-text"));
        String actuelUserId =userId.getText();
        String expectedUserId ="testtechproed@gmail.com";
        if (actuelUserId.equals(expectedUserId)){
            System.out.println("userId testi passed");
        }else System.out.println("userId testi failed");
        //. “Addresses”
        //<a class="nav-item nav-link" data-test="addresses" href="/addresses">Addresses</a>
        WebElement addresses = driver.findElement(By.linkText("Addresses"));
        System.out.println("addresses.isDisplayed() = " + addresses.isDisplayed());
        //"qq ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        //<a class="nav-item nav-link" data-test="sign-out" rel="nofollow"
        // data-method="delete" href="/sign_out">Sign out</a>
        WebElement signOut = driver.findElement(By.linkText("Sign out"));
        System.out.println("signOut.isDisplayed() = " + signOut.isDisplayed());
        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("linklerListesi.size() = " + linklerListesi.size());
        //4. linkleri yazdirin;
        int sira =1;
        for (WebElement each : linklerListesi){
            System.out.println("linkler listesi"+sira+" :"+each.getText()+" ");
            sira++;
        }
        System.out.println();
        //Lambda ile yazdırın:
        linklerListesi.stream().forEach(t-> System.out.println("linkler listesi :"+t.getText()+" "));
        driver.quit();



    }
}
