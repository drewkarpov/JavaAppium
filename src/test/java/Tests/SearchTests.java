package Tests;

import lib.CoreTestCase;
import lib.factories.SearchPageObjectFactory;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Object-oriented programming language");
    }
    @Test
    public void testSearchByTitleAndDescription() {
        String request = "Metallica";
        String title = "Metallica discography";
        String description = "Discography";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(request);
        String kek = searchPageObject.getArticleText();
        searchPageObject.waitForSearchResultByTitleAndDescription(
                title,
                description);
        int sizeSearchResultItem = searchPageObject.getCountOfItemsByTitle();
       assertTrue("Items count < 3",sizeSearchResultItem>= 3);
            for (WebElement element : searchPageObject.listOfSearchItems()){
                element.isDisplayed();
            }
        }



    @Test
    public void testCancelSearch() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.waitForCancelButtonAppear();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelButtonDisappear();
    }
    @Test
    public void testAmountOfNotEmptySearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        String searchLine = "Metallica discography";
        searchPageObject.typeSearchLine(searchLine);
        int amountOfSearchResults = searchPageObject.getAmountOfFoundArticles();
        assertTrue("we found too few results!",
                amountOfSearchResults > 0);
    }

    @Test
    public void testAmountOfEmptySearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        String searchLine = "fewfijeo3";
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForEmptyResultsLabel();
        searchPageObject.assertThereIsNoResultOfSearch();
    }
    // Ex2
    @Test
    public void testAssertionHintInSearchField() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        String hintSearchField =searchPageObject.getTextFromSearchInput();
        assertEquals("Element has not text 'Search…'", hintSearchField, "Search…");
    }
    //Ex3
    @Test
    public void testSomeItemsInSearchResultPage() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        int itemSize = searchPageObject.getCountOfItemsByTitle();
        assertTrue("count item in list not more 1", itemSize > 1);
        searchPageObject.clickCancelSearch();
        searchPageObject.assertEmptyListItemAfterClickCloseButton();
    }
    //ex4
    @Test
    public void testItemsHaveTextInSearchField() {
        String searchValue = "Java";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchValue);
        List<WebElement> list = searchPageObject.itemTitles();
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
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchValue);
        searchPageObject.waitForSearchResult(searchResult);
        searchPageObject.clickByArticleWithSubstring(searchResult);
        searchPageObject.assertExistTitle();
    }
}
