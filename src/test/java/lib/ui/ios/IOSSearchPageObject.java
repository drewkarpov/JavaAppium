package lib.ui.ios;

import lib.ui.MainPageObject;
import lib.ui.interfaces.ISearchMenuPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject implements ISearchMenuPageObject {

    private String
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']",
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[1]",
        SEARCH_CANCEL_BUTTON = "xpath://*[@name='Close']";
    private MainPageObject main;

    public IOSSearchPageObject(MainPageObject mainPageObject) {
        this.main = mainPageObject;
    }


    @Override
    public void initSearchInput() {
        main.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search Wikipedia input after clicking search init element", 5);
        main.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find search Wikipedia input after clicking search init element", 5);
    }

    @Override
    public void typeSearchLine(String searchLine) {
        main.waitForElementAndClick(SEARCH_INPUT, "Cannot find and click search init element", 5);
        main.waitForElementAndSendKeys(SEARCH_INPUT, searchLine, "Cannot find and type into search", 5);
    }

    @Override
    public String getTextFromSearchInput() {
        return main.waitForElementAndGetText(SEARCH_INPUT, "Cannot find search input field", 6);

    }

    @Override
    public void waitForCancelButtonAppear() {
        main.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find cancel search button", 5);
    }

    @Override
    public void waitForCancelButtonDisappear() {
        main.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present    ", 5);
    }

    @Override
    public void clickCancelSearch() {
        main.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find cancel button", 5);
    }
}
