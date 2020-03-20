package Tests;

import lib.CoreTestCase;
import lib.factories.ArticlePageObjectFactrory;
import lib.factories.SearchPageObjectFactory;
import lib.ui.ArticlePageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitle() {

        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        searchResultPage().clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactrory.get(driver);
        articlePageObject.waitForTitleElement();
        String article_title = articlePageObject.getArticleTitle();
        assertEquals("We see unexpected title", "Java (programming language)", article_title);
    }
    @Test
    public void testSwipeArticle() {

        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        searchResultPage().clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactrory.get(driver);
        articlePageObject.waitForTitleElement();
        articlePageObject.swipeToFooter();
    }

}
