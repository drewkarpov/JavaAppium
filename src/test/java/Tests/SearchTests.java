package Tests;

import lib.CoreTestCase;
import lib.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() {
        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        searchResultPage().waitForSearchResult("bject-oriented programming language");
    }
    @Test
    public void testSearchByTitleAndDescription() {
        String request = "Metallica";
        String title = "Metallica discography";
        String description = "Discography";
        searchPage().initSearchInput();
        searchPage().typeSearchLine(request);
        searchResultPage().waitForSearchResultByTitleAndDescription(
                title,
                description);
        int sizeSearchResultItem = searchResultPage().getCountOfItemsByTitle();
       assertTrue("Items count < 3",sizeSearchResultItem>= 3);
            for (WebElement element : searchResultPage().listOfSearchItems()){
                element.isDisplayed();
            }
        }



    @Test
    public void testCancelSearch() {
        searchPage().initSearchInput();
        searchPage().waitForCancelButtonAppear();
        searchPage().clickCancelSearch();
        searchPage().waitForCancelButtonDisappear();
    }
    @Test
    public void testAmountOfNotEmptySearch() {
        searchPage().initSearchInput();
        String searchLine = "Metallica discography";
        searchPage().typeSearchLine(searchLine);
        int amountOfSearchResults = searchResultPage().getAmountOfFoundArticles();
        assertTrue("we found too few results!",
                amountOfSearchResults > 0);
    }

    @Test
    public void testAmountOfEmptySearch() {
        searchPage().initSearchInput();
        String searchLine = "fewfijeo3";
        searchPage().typeSearchLine(searchLine);
        searchResultPage().waitForEmptyResultsLabel();
        searchResultPage().assertThereIsNoResultOfSearch();
    }
    // Ex2
    @Test
    public void testAssertionHintInSearchField() {
        searchPage().initSearchInput();
        String hintSearchField =searchPage().getTextFromSearchInput();
        assertEquals("Element has not text 'Search…'", hintSearchField, "Search…");
    }
    //Ex3
    @Test
    public void testSomeItemsInSearchResultPage() {
        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        int itemSize = searchResultPage().getCountOfItemsByTitle();
        assertTrue("count item in list not more 1", itemSize > 1);
        searchPage().clickCancelSearch();
        searchResultPage().assertEmptyListItemAfterClickCloseButton();
    }
    //ex4
    @Test
    public void testItemsHaveTextInSearchField() {
        String searchValue = "Java";
        searchPage().initSearchInput();
        searchPage().typeSearchLine(searchValue);
        List<WebElement> list = searchResultPage().itemTitles();
        for (WebElement element : list) {
            String name = element.getText();
            String default_name = name.toLowerCase();
            assertTrue("count item in list not more 1", default_name.contains(searchValue.toLowerCase()));
        }
    }
    //ex6
    @Test
    public void testAssertPresentTitle() {
        String searchValue = "Java";
        String searchResult = "Object-oriented programming language";
        searchPage().initSearchInput();
        searchPage().typeSearchLine(searchValue);
        searchResultPage().waitForSearchResult(searchResult);
        searchResultPage().clickByArticleWithSubstring(searchResult);
        searchResultPage().assertExistTitle();
    }
}
