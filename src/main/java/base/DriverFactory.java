package base;

import org.openqa.selenium.WebDriver;


public class DriverFactory {


    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    public void setDriver(WebDriver driverParam){
        driver.set(driverParam);
    }

    public WebDriver getDriver(){
        return driver.get();
    }

}
