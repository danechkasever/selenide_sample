package forms;

import common.by.ByEx;
import common.by.CustomBy;
import lombok.Data;

@Data
public class SubmitEmailForm {
    private final CustomBy emailInput = new CustomBy(ByEx.ID, "username");
    private final CustomBy continueWithEmailBtn = new CustomBy(ByEx.CSS, "button[type='submit']");
}
