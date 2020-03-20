package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.factories.ArticlePageObjectFactrory;
import lib.factories.MyListsPageObjectFactory;
import lib.ui.*;
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
        articlePage().waitForTitleElement();
        String articleTitle = articlePage().getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            articlePage().addArticleToMyList(nameOfFolder);
        } else {
            articlePage().addArticlesToMySaved();
        }
        if (Platform.getInstance().isMobileWeb()) {
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            auth.submitForm();

            articlePage().waitForTitleElement();
            assertEquals("We are not on the same page after login", articleTitle, articlePage().getArticleTitle());
            articlePage().addArticlesToMySaved();
        }
        articlePage().closeArticle();
        navigation().openNavigation();
        navigation().clickMyLists();
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openFolderByName(nameOfFolder);
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
        articlePage().waitForTitleElement();
        String firstArticleTitle = articlePage().getArticleTitle();
        if (Platform.getInstance().isAndroid()) {
            articlePage().addArticleToMyList(nameOfFolder);
        } else {
            articlePage().addArticlesToMySaved();
        }
        if (Platform.getInstance().isMobileWeb()) {
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            auth.submitForm();

            articlePage().waitForTitleElement();
        //    assertEquals("We are not on the same page after login", firstArticleDescription, articlePageObject.getArticleTitle());
            articlePage().addArticlesToMySaved();
        }
        articlePage().closeArticle();
        searchPage().initSearchInput();
        searchPage().typeSearchLine(searchValue);
        searchResultPage().clickByArticleWithSubstring(secondArticleDescription);
        articlePage().waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            articlePage().addArticleToMyList(nameOfFolder);
        } else {
            articlePage().addArticlesToMySaved();
        }
        if (Platform.getInstance().isMobileWeb()) {

            articlePage().waitForTitleElement();
        //    assertEquals("We are not on the same page after login", firstArticleDescription, articlePageObject.getArticleTitle());
            articlePage().addArticlesToMySaved();
        }
        articlePage().closeArticle();
        navigation().openNavigation();
        navigation().clickMyLists();
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openFolderByName(nameOfFolder);
        }
        myListsPageObject.swipeByArticleToDelete(firstArticleTitle);
        myListsPageObject.assertArticleIsExist(secondArticleName);
    }
}
