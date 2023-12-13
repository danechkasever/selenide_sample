package common.webdriver;


import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ChromeSelenoidDriverProvider implements WebDriverProvider {


    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("disable-popup-blocking", true);
        chromePrefs.put("download.extensions_to_open", "");
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("browser.download.folderList", 2);
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
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create(System.getProperty("selenoid_url")).toURL(),
                    options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }
}
