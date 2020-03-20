package lib.ui.MobileWeb;

import lib.ui.MainPageObject;
import lib.interfaces.INavigationUI;

public class MWNavigationUI implements INavigationUI {

    private String
        MY_LIST_BUTTON = "css:a[data-event-name='menu.watchlist']",
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
    private MainPageObject main;

    public MWNavigationUI(MainPageObject mainPageObject) {
        this.main = mainPageObject;
    }

    @Override
    public void openNavigation() {
        main.waitForElementAndClick(OPEN_NAVIGATION,"Cannot find and click navigation button",6);

    }
    @Override
    public void clickMyLists() {
        main.tryClickElementWithFewAttemts(MY_LIST_BUTTON,
                "Cannot find and click myList button", 6);
        main.waitForElementPresent(
                MY_LIST_BUTTON,
                "Cannot find navigation button to my lists",
                5
        );
        main.waitForElementAndClick(
                MY_LIST_BUTTON,
                "Cannot find navigation button to my lists",
                5
        );
    }
}
