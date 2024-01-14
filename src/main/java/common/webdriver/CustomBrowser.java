package common.webdriver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import configs.Configurations;


public class CustomBrowser implements Browser {
    public final SelenideDriver browser;

    public CustomBrowser() {
        browser = new SelenideDriver(setConfigs());
    }


    @Override
    public SelenideConfig setConfigs() {
        SelenideConfig selenideConfig = new SelenideConfig();
        return selenideConfig
                .screenshots(true)
                .savePageSource(false)
                .reopenBrowserOnFail(true)
                .pollingInterval(3000)
                .browser(getProviderName());
    }

    @Override
    public String getProviderName() {
        return switch (Configurations.browser) {
            case "chrome" -> ChromeDriverProvider.class.getCanonicalName();
            case "selenoid.chrome" -> ChromeSelenoidDriverProvider.class.getCanonicalName();
            default -> throw new RuntimeException(String.format("Incorrect %s browser", Configurations.browser));
        };
    }

    @Override
    public SelenideDriver getDriver() {
        return browser;
    }
}
