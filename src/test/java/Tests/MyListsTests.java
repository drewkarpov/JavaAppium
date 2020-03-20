package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.factories.ArticlePageObjectFactrory;
import lib.factories.MyListsPageObjectFactory;
import lib.factories.NavigationUIFactory;
import lib.factories.SearchPageObjectFactory;
import lib.ui.*;
import lib.ui.interfaces.INavigationUI;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {


    private static final String nameOfFolder = "Learning Programming";
    private static final String
            login = "Drewkarp1992",
            password = "dgk152nord";

    @Test
    public void testSaveFirstArticleToMyList() {
        searchPage().initSearchInput();
        searchPage().typeSearchLine("Java");
        searchResultPage().clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactrory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addArticleToMyList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMobileWeb()) {
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            auth.submitForm();

            articlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login", articleTitle, articlePageObject.getArticleTitle());
            articlePageObject.addArticlesToMySaved();
        }
        articlePageObject.closeArticle();
        navigation().openNavigation();
        navigation().clickMyLists();
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openFoderByName(nameOfFolder);
        }
        myListsPageObject.swipeByArticleToDelete(articleTitle);
    }

    //ex5
    @Test
    public void testCompareTwoArticleTitleAndDelete() {
        String searchValue = "Java";
        String firstArticleDescription = "bject-oriented programming language";
        String secondArticleName = "JavaScript";
        String secondArticleDescription = "rogramming language";
        searchPage().initSearchInput();
        searchPage().typeSearchLine(searchValue);
        searchResultPage().clickByArticleWithSubstring(firstArticleDescription);
        ArticlePageObject articlePageObject = ArticlePageObjectFactrory.get(driver);
        articlePageObject.waitForTitleElement();
        String firstArticleTitle = articlePageObject.getArticleTitle();
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addArticleToMyList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMobileWeb()) {
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            auth.submitForm();

            articlePageObject.waitForTitleElement();
        //    assertEquals("We are not on the same page after login", firstArticleDescription, articlePageObject.getArticleTitle());
           articlePageObject.addArticlesToMySaved();
        }
        articlePageObject.closeArticle();
        searchPage().initSearchInput();
        searchPage().typeSearchLine(searchValue);
        searchResultPage().clickByArticleWithSubstring(secondArticleDescription);
        articlePageObject.waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addArticleToMyList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMobileWeb()) {

            articlePageObject.waitForTitleElement();
        //    assertEquals("We are not on the same page after login", firstArticleDescription, articlePageObject.getArticleTitle());
            articlePageObject.addArticlesToMySaved();
        }
        articlePageObject.closeArticle();
        navigation().openNavigation();
        navigation().clickMyLists();
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openFoderByName(nameOfFolder);
        }
        myListsPageObject.swipeByArticleToDelete(firstArticleTitle);
        myListsPageObject.assertArticleIsExist(secondArticleName);
    }
}
