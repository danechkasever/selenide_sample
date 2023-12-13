package common.webdriver;

import com.codeborne.selenide.Configuration;
import com.google.inject.AbstractModule;
import configs.Configurations;

public class CustomWebDriver extends AbstractModule {
    private final String browserName;


    public CustomWebDriver() {
        this.browserName = Configurations.browser;
    }

    @Override
    public void configure() {
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.reopenBrowserOnFail = true;
        Configuration.pollingInterval = 6000;
        Configuration.browser = getProviderName();
    }

    private String getProviderName() {
        return switch (this.browserName.toLowerCase()) {
            case "chrome" -> ChromeDriverProvider.class.getCanonicalName();
            case "selenoid.chrome" -> ChromeSelenoidDriverProvider.class.getCanonicalName();
            default -> null;
        };
    }
}
