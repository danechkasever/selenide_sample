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
        return getISelenideElement(null, customBy, 0);
    }

    @Override
    public ISelenideElement getElement(CustomBy customBy, CustomBy parent) {
        return getISelenideElement(new ElementFinder(selenideDriver.driver(), null, parent.by(), 0, null), customBy, 0);
    }

    @Override
    public List<ISelenideElement> getElements(CustomBy customBy) {
        int size = selenideDriver.$$(customBy.by()).size();
        return getISelenideElements(size, null, customBy);
    }

    @Override
    public List<ISelenideElement> getElements(CustomBy customBy, CustomBy parent) {
        int size = selenideDriver.$(parent.by()).$$( customBy.by()).size();
        return getISelenideElements(size, new ElementFinder(selenideDriver.driver(), null, parent.by(), 0, null), customBy);
    }

    private ISelenideElement getISelenideElement(ElementFinder parent, CustomBy customBy, int i) {
        return ElementFinder.wrap(selenideDriver.driver(), ISelenideElement.class, parent, customBy.by(), i);
    }

    private List<ISelenideElement> getISelenideElements(int size, ElementFinder parent, CustomBy customBy) {
        List<ISelenideElement> iSelenideElementList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            iSelenideElementList.add(getISelenideElement(parent, customBy, i));
        }
        return iSelenideElementList;
    }

}
