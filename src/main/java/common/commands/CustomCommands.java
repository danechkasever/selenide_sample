package common.commands;

import com.codeborne.selenide.Command;
import common.element.ISelenideElement;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class CustomCommands {

    public Command<ISelenideElement> clickWithLoadElement() {
        return (proxy, locator, args) -> {
            ISelenideElement element = (ISelenideElement) proxy;
            await().atMost(5, TimeUnit.SECONDS).until(element::isDisplayed);
            element.click();
            return (ISelenideElement) proxy;
        };
    }

    public Command<ISelenideElement> clickWithScrollElement() {
        return (proxy, locator, args) -> {
            ISelenideElement element = (ISelenideElement) proxy;
            await().atMost(5, TimeUnit.SECONDS).until(element::isEnabled);
            element.scrollTo();
            element.click();
            return (ISelenideElement) proxy;
        };
    }

    public Command<ISelenideElement> setTextAfterLoad() {
        return (proxy, locator, args) -> {
            ISelenideElement element = (ISelenideElement) proxy;
            await().atMost(5, TimeUnit.SECONDS).until(element::isDisplayed);
            assert args != null;
            String text = (String) args[0];
            element.setValue(text);
            return (ISelenideElement) proxy;
        };
    }

    public Command<ISelenideElement> setTextAfterScroll() {
        return (proxy, locator, args) -> {
            ISelenideElement element = (ISelenideElement) proxy;
            await().atMost(5, TimeUnit.SECONDS).until(element::isDisplayed);
            element.scrollTo();
            assert args != null;
            String text = (String) args[0];
            element.setValue(text);
            return (ISelenideElement) proxy;
        };
    }

    public Command<Boolean> isDisplayedElement() {
        return (proxy, locator, args) -> {
            ISelenideElement element = (ISelenideElement) proxy;
            await().atMost(5, TimeUnit.SECONDS).until(element::isDisplayed);
            return element.isDisplayed();
        };
    }

    public Command<Boolean> isEnabledElement() {
        return (proxy, locator, args) -> {
            ISelenideElement element = (ISelenideElement) proxy;
            await().atMost(5, TimeUnit.SECONDS).until(element::isEnabled);
            return element.isEnabled();
        };
    }

    public Command<Boolean> isExistsElement() {
        return (proxy, locator, args) -> {
            ISelenideElement element = (ISelenideElement) proxy;
            await().atMost(5, TimeUnit.SECONDS).until(element::exists);
            return element.exists();
        };
    }
}
