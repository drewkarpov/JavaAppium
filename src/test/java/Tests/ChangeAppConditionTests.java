package Tests;

import lib.CoreTestCase;
import lib.factories.ArticlePageObjectFactrory;
import lib.factories.SearchPageObjectFactory;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {
    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactrory.get(driver);
        articlePageObject.getArticleTitle();
        String titleBeforeRotation = articlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String titleAfterRotation = articlePageObject.getArticleTitle();
        assertEquals(
                "Article title have been change screen after rotation",
                titleBeforeRotation, titleAfterRotation
        );
        this.rotateScreenPortait();
        String titleAfterSecondRotation = articlePageObject.getArticleTitle();
        assertEquals(
                "Article title have been change screen after rotation",
                titleBeforeRotation, titleAfterSecondRotation
        );
    }
    @Test
    public void testCheckSearchArticleBackground() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Object-oriented programming language");
    //    this.backgroundApp(4);
        searchPageObject.waitForSearchResult("Object-oriented programming language");
    }

}
