package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {
    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[1]";
        SEARCH_CANCEL_BUTTON = "xpath://*[@name='Close']";
        SEARCH_RESULT_WITH_SUBSTRING_TML = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@name='No results found']";
        SEARCH_ITEM_TITLE = "xpath://XCUIElementTypeLink";
        SEARCH_ITEM_TITLE_AND_DESCRIPTION_TML = "xpath://XCUIElementTypeLink[contains(@text,'{SUBSTRING}')]/../xpath://XCUIElementTypeLink[contains(@text,'{SECOND_SUBSTRING}')]";
        SEARCH_ITEM_TITLE_TEXT = "id:org.wikipedia:id/view_page_title_text";
        SEARCH_EMPTY_MESSAGE = "id:org.wikipedia:id/search_empty_message";
    }
}
