package common.webdriver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import common.by.CustomBy;
import common.element.ISelenideElement;

import java.util.List;

public interface IBrowser {

    SelenideConfig setConfigs();

    String getProviderName();

    SelenideDriver getDriver();

    void openPage();

    void openPage(String url);

    void refresh();

    void closeDriver();

    ISelenideElement getElement(CustomBy customBy);
    List<SelenideElement> getElements(CustomBy customBy);


}
