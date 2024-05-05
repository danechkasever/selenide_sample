package common.webdriver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
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

}
