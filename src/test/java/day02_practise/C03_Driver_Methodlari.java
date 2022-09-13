package day02_practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_Driver_Methodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/reseurces/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        //System.out.println("driver.getPageSource() = " + driver.getPageSource());
        // amazon sitesine gidip "spend less" yazdiğini test edin
        String actualPageSourse = driver.getPageSource();
        String expectedPageSource ="Gateway";
        if (actualPageSourse.contains(expectedPageSource)){
            System.out.println("PageSource testi passed");
        }else System.out.println("PageSource testi failed");

        driver.close();
    }
}
