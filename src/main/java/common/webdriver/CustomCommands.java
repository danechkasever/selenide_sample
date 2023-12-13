package common.webdriver;

import com.codeborne.selenide.SelenideElement;
import java.util.concurrent.TimeUnit;


import static org.awaitility.Awaitility.await;

public interface CustomCommands {
    default void setText(SelenideElement element, String text) {
        element.scrollTo().clear();
        element.sendKeys(text);
    }

    default void clickElement(SelenideElement element) {
        element.scrollTo().click();
    }

    default void waitElementTillVisible(SelenideElement element) {
        await().atMost(5, TimeUnit.SECONDS).until(element::isDisplayed);
    }
}
