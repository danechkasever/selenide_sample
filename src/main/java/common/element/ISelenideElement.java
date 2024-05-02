package common.element;

import com.codeborne.selenide.SelenideElement;

public interface ISelenideElement extends SelenideElement {
    ISelenideElement clickWithLoadElement();
    ISelenideElement clickWithScrollElement();
    ISelenideElement setTextAfterLoad(String text);
    ISelenideElement setTextAfterScroll(String text);
    Boolean isDisplayedElement();
    Boolean isEnabledElement();
    Boolean isExistsElement();
}
