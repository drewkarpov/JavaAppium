package lib.interfaces;


import org.openqa.selenium.WebElement;

import java.util.List;

public interface ISearchResultPageObject {

    String getResultSearchElement(String substring);

    String getResultSearchElementByTitleAndDescription(String substring,String secondSubstring);

    void waitForItemsBySearch();

    int getCountOfItemsByTitle();

    void waitForSearchResult(String substing);

    void waitForSearchResultByTitleAndDescription(String substing,String secondSubstring);

    void clickByArticleWithSubstring(String substing);

    List<WebElement> listOfSearchItems();

    void assertEmptyListItemAfterClickCloseButton();

    List<WebElement> itemTitles();

    int getAmountOfFoundArticles();

    void waitForEmptyResultsLabel();

    void assertThereIsNoResultOfSearch();

    void assertExistTitle();
}
