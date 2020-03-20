package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.MobileWeb.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {


    @Test
    public void testPassTroughWelcome(){
        if(Platform.getInstance().isAndroid() || Platform.getInstance().isMobileWeb()){
            return;
        }
        WelcomePageObject welcomPage = new WelcomePageObject(driver);
        welcomPage.waitForLearnMoreLink();
        welcomPage.clickNextButton();
        welcomPage.waitForNewWayToExploreText();
        welcomPage.clickNextButton();
        welcomPage.waitForAddOrEditPrefferedLangText();
        welcomPage.clickNextButton();
        welcomPage.waitForLearnMoreAboutDataCollectedText();
        welcomPage.clickGetStartedButton();
    }


}
