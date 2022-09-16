package day04_practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/reseurces/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2
        //Add Element butonuna basin
        //<button onclick="addElement()">Add Element</button>
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();
        //3
        //Delete butonu’nun gorunur oldugunu test edin
        //4

        //Delete tusuna basin
        //5

        //Delete butonunun gorunur olmadigini test edin

    }
}
