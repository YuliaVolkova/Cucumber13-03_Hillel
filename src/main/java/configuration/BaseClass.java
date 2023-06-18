package configuration;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class BaseClass {
    public static WebDriver driver;

    public static void create(){
        driver= DriverFactory.greateDriver(WEBDRIVERS.CHROMECLEAN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }




    public static void end() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}

