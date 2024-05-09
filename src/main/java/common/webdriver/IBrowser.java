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
    ISelenideElement getElement(CustomBy customBy, CustomBy parent);
    List<ISelenideElement> getElements(CustomBy customBy);
    List<ISelenideElement> getElements(CustomBy customBy, CustomBy parent);

}
