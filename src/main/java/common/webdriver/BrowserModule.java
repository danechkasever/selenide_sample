package common.webdriver;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class BrowserModule extends AbstractModule {
    @Override
    public void configure() {
        bind(Browser.class).to(CustomBrowser.class).in(Scopes.SINGLETON);
    }
}
