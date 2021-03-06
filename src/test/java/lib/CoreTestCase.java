package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.factories.*;
import lib.ui.MainPageObject;
import lib.ui.MobileWeb.WelcomePageObject;
import lib.interfaces.*;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;


public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;
    private INavigationUI navigation;
    private ISearchResultPageObject searchResult;
    private ISearchMenuPageObject searchMenu;
    private IArticlePageObject articlePage;
    private IMyListPageObject myListPage;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        MainPageObject mainPageObject = new MainPageObject(driver);
        navigation = NavigationUIFactory.get(mainPageObject);
        searchMenu = SearchPageObjectFactory.get(mainPageObject);
        searchResult = SearchResultPageObjectFactory.get(mainPageObject);
        articlePage = ArticlePageObjectFactrory.get(mainPageObject);
        myListPage = MyListsPageObjectFactory.get(mainPageObject);
        this.rotateScreenPortait();
        this.skipWelcomePageForIOSApp();
        this.openWikiWebPageForMobileWeb();
    }

    @Override
    protected void tearDown() throws Exception {

        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortait() {
      if (driver instanceof AppiumDriver){
          AppiumDriver driver = (AppiumDriver) this.driver;
          driver.rotate(ScreenOrientation.PORTRAIT);
      } else {
          System.out.println("Method rotateScreenPortrait() dose nothing to platform"+Platform.getInstance().getPlatformVar());
      }
    }

    protected void rotateScreenLandscape() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenPortrait() dose nothing to platform" + Platform.getInstance().getPlatformVar());
        }
    }

    protected void backgroundApp(long seconds) {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            System.out.println("Method rotateScreenPortrait() dose nothing to platform"+Platform.getInstance().getPlatformVar());
        }
    }
    protected void openWikiWebPageForMobileWeb(){
        if(Platform.getInstance().isMobileWeb()){
            driver.get("https://en.m.wikipedia.org");
        } else{
            System.out.println("Method openWikiWebPageForMobileWeb() dose nothing to platform" + Platform.getInstance().getPlatformVar());
        }
    }

    private void skipWelcomePageForIOSApp(){
        if(Platform.getInstance().isIOS()){
            WelcomePageObject welcomePage =new WelcomePageObject(driver);
            welcomePage.clickSkip();
        }
    }
    protected INavigationUI navigation(){
        return navigation;
    }
    protected ISearchMenuPageObject searchPage(){
        return searchMenu;
    }
    protected ISearchResultPageObject searchResultPage(){
        return searchResult;
    }
    protected IArticlePageObject articlePage(){return articlePage;}
    protected IMyListPageObject myListPage(){return myListPage;}

}