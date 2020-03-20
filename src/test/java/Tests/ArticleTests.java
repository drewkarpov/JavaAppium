package Tests;

import lib.CoreTestCase;
import lib.factories.ArticlePageObjectFactrory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitle() {

        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        searchResultPage().clickByArticleWithSubstring("bject-oriented programming language");
        articlePage().waitForTitleElement();
        String article_title = articlePage().getArticleTitle();
        assertEquals("We see unexpected title", "Java (programming language)", article_title);
    }
    @Test
    public void testSwipeArticle() {

        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        searchResultPage().clickByArticleWithSubstring("bject-oriented programming language");
        articlePage().waitForTitleElement();
        articlePage().swipeToFooter();
    }

}
