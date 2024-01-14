package common.webdriver;


import com.codeborne.selenide.SelenideDriver;
import com.google.inject.Inject;
import configs.Configurations;

public class WebDriverOperations {
    private final SelenideDriver selenideDriver;

    @Inject
    public WebDriverOperations(Browser driver) {
        this.selenideDriver = driver.getDriver();
    }

    public void openPage() {
        selenideDriver.open(Configurations.url);
    }

    public void openPage(String url) {
        selenideDriver.open(url);
    }

    public void refresh() {
        selenideDriver.refresh();
    }

    public void closeDriver() {
        selenideDriver.close();
    }
}
