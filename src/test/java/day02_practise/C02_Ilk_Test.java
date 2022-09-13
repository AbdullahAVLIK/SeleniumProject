package day02_practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Ilk_Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/reseurces/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //1- https:www.amazon.com sayfasına gidin
        driver.get("https:www.amazon.com");
        //2- Baslıgın Amazon kelimesini içerdiğini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title testi passed");
        }else System.out.println("Title testi failed");
        //3- URL 'nin "https://www.amazon.com" a eşit olduğunu test edin
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.amazon.com";
        if (actualURL.equals(expectedURL)){
            System.out.println("url testi passed");
        }else System.out.println("url testi failed, actualURL "+actualURL);// sonun da / var farklı olarak

        driver.close();

    }
}
