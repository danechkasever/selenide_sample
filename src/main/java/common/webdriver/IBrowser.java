package common.webdriver;

import common.by.CustomBy;
import common.element.ISelenideElement;

import java.util.List;

public interface IBrowser {

    String getProviderName();

    void openPage();

    void openPage(String url);

    void refresh();

    void closeDriver();

    ISelenideElement getElement(CustomBy customBy);

    List<ISelenideElement> getElements(CustomBy customBy);

    ISelenideElement getChildElement(CustomBy parent, CustomBy child);

    List<ISelenideElement> getChildElements(CustomBy parent, CustomBy child);

}
