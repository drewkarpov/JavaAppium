package lib.ui.android;

import lib.ui.MainPageObject;
import lib.interfaces.ISearchMenuPageObject;

public class AndroidSearchPageObject implements ISearchMenuPageObject {
    private String
            SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]",
            SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_WITH_SUBSTRING_TML = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'{SUBSTRING}')]",
            SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
            SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']",
            SEARCH_ITEM_TITLE = "id:org.wikipedia:id/page_list_item_title",
            SEARCH_ITEM_TITLE_AND_DESCRIPTION_TML = "xpath://android.widget.TextView[contains(@text,'{SUBSTRING}')]/../android.widget.TextView[contains(@text,'{SECOND_SUBSTRING}')]",
            SEARCH_ITEM_TITLE_TEXT = "id:org.wikipedia:id/view_page_title_text",
            SEARCH_EMPTY_MESSAGE = "id:org.wikipedia:id/search_empty_message";
    private MainPageObject main;

    public AndroidSearchPageObject(MainPageObject mainPageObject) {
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
