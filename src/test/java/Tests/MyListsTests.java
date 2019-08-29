package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.factories.ArticlePageObjectFactrory;
import lib.factories.MyListsPageObjectFactory;
import lib.factories.NavigationUIFactory;
import lib.factories.SearchPageObjectFactory;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {


    private static final String nameOfFolder = "Learning Programming";

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactrory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToMyList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        articlePageObject.closeArticle();
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickMyLists();
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()){
            myListsPageObject.openFoderByName(nameOfFolder);
        }
        myListsPageObject.swipeByArticleToDelete(articleTitle);
    }
    //ex5
    @Test
    public void testCompareTwoArticleTitleAndDelete() {
        String searchValue = "Java";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchValue);
        String firstArticleName = "Object-oriented programming language";
        String secondArticleName = "JavaScript";
        String secondArticleDescription = "Programming language";
        searchPageObject.clickByArticleWithSubstring(firstArticleName);
        ArticlePageObject articlePageObject = ArticlePageObjectFactrory.get(driver);
        articlePageObject.waitForTitleElement();
        String firstArticleTitle = articlePageObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToMyList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
            articlePageObject.closeHintUntilAddArticle();
        }
        articlePageObject.closeArticle();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchValue);
        searchPageObject.clickByArticleWithSubstring(secondArticleName);
        articlePageObject.waitForTitleElement();
        if(Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToMyList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        articlePageObject.closeArticle();
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickMyLists();
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()){
            myListsPageObject.openFoderByName(nameOfFolder);
        }
        myListsPageObject.swipeByArticleToDelete(firstArticleTitle);
        myListsPageObject.assertArticleIsExist(secondArticleDescription);
    }
}
