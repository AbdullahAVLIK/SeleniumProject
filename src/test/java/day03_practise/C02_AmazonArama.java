package day03_practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_AmazonArama {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/reseurces/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazon web sayfasına gidin;
        driver.navigate().to("https://www.amazon.com");

        //java için arama yapın:

        //<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"placeholder=
        // "" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
        String sonucstring = sonuc.getText();
        String[] arr = sonucstring.split(" ");
        for (String each : arr){
            System.out.print(each+" ");        }
        String sayısaldeger = arr[3];
        System.out.println("sayısaldeger = " + sayısaldeger);



    }
}
