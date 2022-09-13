package day03_practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/reseurces/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
        //email kutusunun HTML kodları:
        //<input type="text" class="inputtext _55r1 _6luy" name="email" id="email"
        // data-testid="royal_email" placeholder="E-posta veya Telefon Numarası"
        // autofocus="1" aria-label="E-posta veya Telefon Numarası">

        WebElement mailTextBox = driver.findElement(By.id("email"));
        mailTextBox.sendKeys("aliselenium@gmail.com");
        Thread.sleep(2000);
        mailTextBox.clear();

        /*WebElement mailKutusuTagNameIle = driver.findElement(By.tagName("input"));
        mailKutusuTagNameIle.sendKeys("veliselenium@gmail.com");
        Thread.sleep(2000);
        mailTextBox.clear();*/          // TagName unique olmadığı için bulamadı

        /*WebElement yanlisElement = driver.findElement(By.id("emailyanlis"));
        yanlisElement.sendKeys("aliselenium@gmail.com");
        WebElement byLinkText = driver.findElement(By.linkText(""));*/
        //webelements yoksa nosuchelementexeption verir.

        /*WebElement classNameIle = driver.findElement(By.className("inputtext _55r1 _6luy"));
        classNameIle.sendKeys("aliselenium@gmail.com");*/

        WebElement nameIle = driver.findElement(By.name("email"));
        nameIle.sendKeys("veliselenium@gmail.com");// bunu kabul etti
        Thread.sleep(2000);
        mailTextBox.clear();

        //<a href="https://www.facebook.com/recover/initiate/?privacy_mutation_token=
        // eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjYzMDU4NzkzLCJjYWxsc2l0ZV9pZCI6MzgxMjI5
        // MDc5NTc1OTQ2fQ%3D%3D&amp;ars=facebook_login">Forgotten password?</a>

        WebElement linkTestIle = driver.findElement(By.linkText("Forgotten password?"));
        System.out.println("linkTestIle.getText() = " + linkTestIle.getText());

        WebElement partialinkTesxt = driver.findElement(By.partialLinkText("otten password?"));
        System.out.println("partialinkTesxt.getText() = " + partialinkTesxt.getText());
        partialinkTesxt.click();

        WebElement logIn = driver.findElement(By.tagName("button"));
        System.out.println("logIn.isEnabled() = " + logIn.isEnabled());
        System.out.println("logIn.isDisplayed() = " + logIn.isDisplayed());
        System.out.println("logIn.isSelected() = " + logIn.isSelected());
        logIn.submit();
        driver.navigate().back();


    }
}
