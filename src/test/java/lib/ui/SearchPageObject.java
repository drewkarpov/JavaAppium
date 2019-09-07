package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject {

    protected static   String
            SEARCH_INIT_ELEMENT ,
            SEARCH_INPUT ,
            SEARCH_CANCEL_BUTTON ,
            SEARCH_RESULT_WITH_SUBSTRING_TML ,
            SEARCH_RESULT_ELEMENT ,
            SEARCH_EMPTY_RESULT_ELEMENT ,
            SEARCH_ITEM_TITLE ,
            SEARCH_ITEM_TITLE_AND_DESCRIPTION_TML ,
            SEARCH_ITEM_TITLE_TEXT ,
            SEARCH_EMPTY_MESSAGE ;


    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_WITH_SUBSTRING_TML.replace("{SUBSTRING}", substring);
    }
    private static String getResultSearchElementByTitleAndDescription(String substring,String secondSubstring) {

        return SEARCH_ITEM_TITLE_AND_DESCRIPTION_TML.replace("{SUBSTRING}", substring).replace("{SECOND_SUBSTRING}",secondSubstring);
    }

    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search Wikipedia input after clicking search init element", 5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find search Wikipedia input after clicking search init element", 5);

    }

    public void typeSearchLine(String searchLine) {
        this.waitForElementAndClick(SEARCH_INPUT, "Cannot find and click search init element", 5);

        this.waitForElementAndSendKeys(SEARCH_INPUT, searchLine, "Cannot find and type into search", 5);

    }
    public String getTextFromSearchInput(){
      return   waitForElementAndGetText(SEARCH_INPUT, "Cannot find search input field",6);
    }
    public void waitForItemsBySearch(){
        this.waitForElementPresent(SEARCH_ITEM_TITLE, "Cannot find item in search list", 5);
    }
    public int getCountOfItemsByTitle(){
        this.waitForItemsBySearch();
      return   this.waitForElementAndgetItemListSize(SEARCH_ITEM_TITLE,"Cannot find item in search list",7);
    }
    public List<WebElement> listOfSearchItems(){
        return elementsList(SEARCH_ITEM_TITLE);
    }

    public void waitForSearchResult(String substing) {
        String searchResultXpath = getResultSearchElement(substing);
        this.waitForElementPresent(searchResultXpath, "Cannot find search result with substring " + substing);
    }
    public void waitForSearchResultByTitleAndDescription(String substing,String secondSubstring) {
        if (!Platform.getInstance().isMobileWeb()) {
            String searchResultXpath = getResultSearchElementByTitleAndDescription(substing, secondSubstring);
            this.waitForElementPresent(searchResultXpath, "Cannot find search result with title or description");
        }
    }


    public void clickByArticleWithSubstring(String substing) {
        String searchResultXpath = getResultSearchElement(substing);
        this.waitForElementAndClick(searchResultXpath, "Cannot find and click search result with substring " + substing, 5);
    }

    public void waitForCancelButtonAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find cancel search button", 5);
    }
    public void assertEmptyListItemAfterClickCloseButton() {
        this.waitForElementPresent(SEARCH_EMPTY_MESSAGE, "Cannot find empty message", 5);
        this.waitForElementNotPresent(SEARCH_ITEM_TITLE, "Cannot find empty message", 5);
    }

    public void waitForCancelButtonDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present    ", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find cancel button", 5);
    }
    public List<WebElement>  itemTitles (){
       return items(SEARCH_ITEM_TITLE,"Cannot find item title",5);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "cannot find anything by the request ",
                15
        );
        return this.getAmountOfElements(
                SEARCH_RESULT_ELEMENT);
    }
    public void waitForEmptyResultsLabel(){
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element.", 15);
    }
    public void assertThereIsNoResultOfSearch(){
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }

    public void assertExistTitle(){
        this.assertElementPresent(SEARCH_ITEM_TITLE_TEXT);
    }

    public  String getArticleText() {
      return  this.waitForElementAndGetText(SEARCH_ITEM_TITLE_TEXT,"",4);
    }
}
