package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.factories.ArticlePageObjectFactrory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {
    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        if(Platform.getInstance().isMobileWeb()){
            return;
        }
        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        searchResultPage().clickByArticleWithSubstring("Object-oriented programming language");
        articlePage().getArticleTitle();
        String titleBeforeRotation = articlePage().getArticleTitle();
        this.rotateScreenLandscape();
        String titleAfterRotation = articlePage().getArticleTitle();
        assertEquals(
                "Article title have been change screen after rotation",
                titleBeforeRotation, titleAfterRotation
        );
        this.rotateScreenPortait();
        String titleAfterSecondRotation = articlePage().getArticleTitle();
        assertEquals(
                "Article title have been change screen after rotation",
                titleBeforeRotation, titleAfterSecondRotation
        );
    }
    @Test
    public void testCheckSearchArticleBackground() {
        if(Platform.getInstance().isMobileWeb()){
            return;
        }
        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        searchResultPage().waitForSearchResult("Object-oriented programming language");
    //    this.backgroundApp(4);
        searchResultPage().waitForSearchResult("Object-oriented programming language");
    }

}
