package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

 public class AndroidSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
                SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]";
                SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
                SEARCH_RESULT_WITH_SUBSTRING_TML = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";
                SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
                SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
                SEARCH_ITEM_TITLE = "id:org.wikipedia:id/page_list_item_title";
                SEARCH_ITEM_TITLE_AND_DESCRIPTION_TML = "xpath://android.widget.TextView[contains(@text,'{SUBSTRING}')]/../android.widget.TextView[contains(@text,'{SECOND_SUBSTRING}')]";
                SEARCH_ITEM_TITLE_TEXT = "id:org.wikipedia:id/view_page_title_text";
                SEARCH_EMPTY_MESSAGE = "id:org.wikipedia:id/search_empty_message";
    }
    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
