package common.webdriver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.impl.ElementFinder;
import common.by.CustomBy;
import common.element.ISelenideElement;
import configs.Configurations;

import java.util.ArrayList;
import java.util.List;

public class Browser implements IBrowser {
    public final SelenideDriver selenideDriver;

    public Browser() {
        selenideDriver = new SelenideDriver(setConfigs());
    }

    private SelenideConfig setConfigs() {
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
            default -> throw new RuntimeException(String.format("Incorrect %s IBrowser", Configurations.browser));
        };
    }

    @Override
    public void openPage() {
        selenideDriver.open(Configurations.url);
    }

    @Override
    public void openPage(String url) {
        selenideDriver.open(url);
    }

    @Override
    public void refresh() {
        selenideDriver.refresh();
    }

    @Override
    public void closeDriver() {
        selenideDriver.close();
    }


    @Override
    public ISelenideElement getElement(CustomBy customBy) {
        return ElementFinder.wrap(selenideDriver.driver(), ISelenideElement.class, null, customBy.by(), 0);
    }

    @Override
    public List<ISelenideElement> getElements(CustomBy customBy) {
        int size = selenideDriver.$$(customBy.by()).size();
        List<ISelenideElement> iSelenideElementList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            iSelenideElementList.add(ElementFinder.wrap(selenideDriver.driver(), ISelenideElement.class, null, customBy.by(), i));
        }
        return iSelenideElementList;
    }
}
