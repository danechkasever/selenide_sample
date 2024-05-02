package common.webdriver;


import com.codeborne.selenide.commands.Commands;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import common.commands.CustomCommands;

public class BrowserModule extends AbstractModule {
    @Override
    public void configure() {
        bind(IBrowser.class).to(Browser.class).in(Scopes.SINGLETON);

        Commands.getInstance().add("clickWithLoadElement", new CustomCommands().clickWithLoadElement());
        Commands.getInstance().add("clickWithScrollElement", new CustomCommands().clickWithScrollElement());
        Commands.getInstance().add("setTextAfterLoad", new CustomCommands().setTextAfterLoad());
        Commands.getInstance().add("setTextAfterScroll", new CustomCommands().setTextAfterScroll());
        Commands.getInstance().add("isDisplayedElement", new CustomCommands().isDisplayedElement());
        Commands.getInstance().add("isEnabledElement", new CustomCommands().isEnabledElement());
        Commands.getInstance().add("isExistsElement", new CustomCommands().isExistsElement());
    }
}
