package common.by;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

@Getter
@Accessors(fluent = true)
public class CustomBy {
    private final ByEx byEx;
    private final String locator;
    private By by;

    public CustomBy(ByEx byEx, String locator) {
        this.byEx = byEx;
        this.locator = locator;
        setByValue(byEx, locator);
    }

    private CustomBy setByValue(ByEx byEx, String locator) {
        switch (byEx) {
            case XPATH:
                by = new By.ByXPath(locator);
                break;
            case CSS:
                by = By.cssSelector(locator);
                break;
            case ID:
                by = new By.ById(locator);
                break;
            case CLASS_NAME:
                by = new By.ByClassName(locator);
                break;
            case NAME:
                by = new By.ByName(locator);
                break;
        }
        return this;
    }
}