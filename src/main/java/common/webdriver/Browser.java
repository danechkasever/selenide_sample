package common.webdriver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;

public interface Browser {

    SelenideConfig setConfigs();

    String getProviderName();

    SelenideDriver getDriver();

}
