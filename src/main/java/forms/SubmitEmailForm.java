package forms;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class SubmitEmailForm {
    private final By emailInput = By.id("username");
    private final By continueWithEmailBtn = By.cssSelector("button[type='submit']");
}
