package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    Properties prop;
    FileInputStream fin;

    public TestBase() {
        try {
            fin = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//config.properties");
            prop = new Properties();
            prop.load(fin);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Parameters({"browser","URL"})
    @BeforeClass
    public static void Init(String browser, String URL) {
        if (browser.equalsIgnoreCase("chrome")) {
            DriverFactory.getInstance().setDriver(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless");
            DriverFactory.getInstance().setDriver(new EdgeDriver(edgeOptions));
        }
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverFactory.getInstance().getDriver().get(URL);
    }

}
