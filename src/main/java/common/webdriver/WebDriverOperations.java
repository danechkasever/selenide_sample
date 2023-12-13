package common.webdriver;

import com.codeborne.selenide.Selenide;
import configs.Configurations;

public class WebDriverOperations {

    public void open() {
        Selenide.open(Configurations.url);
    }

    public void open(String url) {
        Selenide.open(url);
    }

    public void refresh() {
        Selenide.refresh();
    }

    public void close() {
        Selenide.closeWebDriver();
    }
}
