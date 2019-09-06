package lib.ui.MobileWeb;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_WITH_SUBSTRING_TML = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        SEARCH_ITEM_TITLE = "xpath://XCUIElementTypeLink";
        SEARCH_ITEM_TITLE_AND_DESCRIPTION_TML = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]/../XCUIElementTypeLink[contains(@name,'{SECOND_SUBSTRING}')]";
        SEARCH_ITEM_TITLE_TEXT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_MESSAGE = "id:org.wikipedia:id/search_empty_message";
    }
}
