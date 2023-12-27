package common.webdriver;


import com.codeborne.selenide.SelenideDriver;
import com.google.inject.Inject;
import configs.Configurations;

public class WebDriverOperations {
    private final SelenideDriver browser;

    @Inject
    public WebDriverOperations(Browser driver) {
        this.browser = driver.getDriver();
    }

    public void open() {
        browser.open(Configurations.url);
    }

    public void open(String url) {
        browser.open(url);
    }

    public void refresh() {
        browser.refresh();
    }

    public void close() {
        browser.close();
    }
}
