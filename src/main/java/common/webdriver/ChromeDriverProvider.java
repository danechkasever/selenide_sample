package common.webdriver;


import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.HashMap;

public class ChromeDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("pdfjs.disabled", true);
        chromePrefs.put("disable-popup-blocking", true);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\report");
        chromePrefs.put("browser.helperApps.neverAsk.saveToDisk", "text/csv");
        chromePrefs.put("w3c", false);
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
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }
}
