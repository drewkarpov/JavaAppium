package lib.ui.ios;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.interfaces.ISearchResultPageObject;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IOSSearchResultPageObject implements ISearchResultPageObject {

    private String
            SEARCH_RESULT_WITH_SUBSTRING_TML = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]",
            SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink",
            SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@name='No results found']",
            SEARCH_ITEM_TITLE = "xpath://XCUIElementTypeLink",
            SEARCH_ITEM_TITLE_AND_DESCRIPTION_TML = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]/../XCUIElementTypeLink[contains(@name,'{SECOND_SUBSTRING}')]",
            SEARCH_ITEM_TITLE_TEXT = "xpath://XCUIElementTypeLink",
            SEARCH_EMPTY_MESSAGE = "id:org.wikipedia:id/search_empty_message";
    private MainPageObject main;

    public IOSSearchResultPageObject(MainPageObject mainPageObject){
        this.main = mainPageObject;
    }
    @Override
    public String getResultSearchElement(String substring) {
        return SEARCH_RESULT_WITH_SUBSTRING_TML.replace("{SUBSTRING}", substring);
    }

    @Override
    public String getResultSearchElementByTitleAndDescription(String substring, String secondSubstring) {
        return SEARCH_ITEM_TITLE_AND_DESCRIPTION_TML.replace("{SUBSTRING}", substring).replace("{SECOND_SUBSTRING}",secondSubstring);
    }

    @Override
    public void waitForItemsBySearch() {
        main.waitForElementPresent(SEARCH_ITEM_TITLE, "Cannot find item in search list", 5);

    }

    @Override
    public int getCountOfItemsByTitle() {
        this.waitForItemsBySearch();
        return   main.waitForElementAndgetItemListSize(SEARCH_ITEM_TITLE,"Cannot find item in search list",7);
    }

    @Override
    public void waitForSearchResult(String substing) {
        String searchResultXpath = getResultSearchElement(substing);
        main.waitForElementPresent(searchResultXpath, "Cannot find search result with substring " + substing);
    }

    @Override
    public void waitForSearchResultByTitleAndDescription(String substing, String secondSubstring) {
        if (!Platform.getInstance().isMobileWeb()) {
            String searchResultXpath = getResultSearchElementByTitleAndDescription(substing, secondSubstring);
            main.waitForElementPresent(searchResultXpath, "Cannot find search result with title or description");
        }
    }

    @Override
    public void clickByArticleWithSubstring(String substing) {
        String searchResultXpath = getResultSearchElement(substing);
        main.waitForElementAndClick(searchResultXpath, "Cannot find and click search result with substring " + substing, 5);
    }

    @Override
    public List<WebElement> listOfSearchItems() {
        return main.elementsList(SEARCH_ITEM_TITLE);
    }

    @Override
    public void assertEmptyListItemAfterClickCloseButton() {
        main.waitForElementPresent(SEARCH_EMPTY_MESSAGE, "Cannot find empty message", 5);
        main.waitForElementNotPresent(SEARCH_ITEM_TITLE, "Cannot find empty message", 5);
    }

    @Override
    public List<WebElement> itemTitles() {
        return main.items(SEARCH_ITEM_TITLE, "Cannot find item title", 5);
    }

    @Override
    public int getAmountOfFoundArticles() {
        main.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "cannot find anything by the request ",
                15
        );
        return main.getAmountOfElements(
                SEARCH_RESULT_ELEMENT);
    }

    @Override
    public void waitForEmptyResultsLabel() {
        main.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element.", 15);
    }
    @Override
    public void assertThereIsNoResultOfSearch() {
        main.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }

    @Override
    public void assertExistTitle() {
        main.assertElementPresent(SEARCH_ITEM_TITLE_TEXT);
    }
}
