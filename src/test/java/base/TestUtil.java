package base;
import com.opencsv.CSVReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.internal.DataProviderLoader;
import java.io.*;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class TestUtil {
    public WebDriver driver;
    public String applicationUrl, browser;
    public int implicitWait;

    @BeforeMethod
    public void setup() {

        readConfig("src/test/resources/config.properties");
        setupBrowserDriver(browser);
        loadTestUrl(applicationUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    private void setupBrowserDriver(String browser) {
        switch (browser) {
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
        }
    }
    private void loadTestUrl(String url) {
        driver.get(url);
    }

    private WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private WebDriver setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private void readConfig(String filePath) {
        try {
            FileInputStream configFile = new FileInputStream(filePath);
            Properties config = new Properties();
            config.load(configFile);
            applicationUrl = config.getProperty("url");
            browser = config.getProperty("browser");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            System.out.println("WebHook enabled");//test
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}










