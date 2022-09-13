package day02_practise;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class C06_manageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/reseurces/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com");
        System.out.println("maximize = " + driver.manage().window().getSize());
        System.out.println("maximize = " + driver.manage().window().getPosition());
        Thread.sleep(2000);
        driver.manage().window().minimize();
        System.out.println("minimize = " + driver.manage().window().getSize());
        System.out.println("minimize = " + driver.manage().window().getPosition());
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        System.out.println("fullscreen = " + driver.manage().window().getSize());
        System.out.println("fullscreen = " + driver.manage().window().getPosition());
        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(30,30));
        driver.manage().window().setSize(new Dimension(800,600));
        System.out.println("personal = " + driver.manage().window().getSize());
        System.out.println("personal = " + driver.manage().window().getPosition());
        Thread.sleep(2000);
        driver.close();
    }
}
