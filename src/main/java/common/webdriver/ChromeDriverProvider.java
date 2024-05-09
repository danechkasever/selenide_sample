package common.webdriver;


import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.HashMap;

public class ChromeDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("disable-popup-blocking", true);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\report");
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
        desiredcapabilities.setBrowserName("chrome");
        desiredcapabilities.setCapability("platform", System.getProperty("os"));
        desiredcapabilities.setCapability("enableVNC", true);
        desiredcapabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "normal");
        desiredcapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.merge(capabilities);
        options.merge(desiredcapabilities);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
}
