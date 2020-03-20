package lib.ui.android;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.ui.interfaces.INavigationUI;


public class AndroidNavigationUI implements INavigationUI {

  public static String MY_LIST_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
  private MainPageObject main;

  public AndroidNavigationUI(MainPageObject mainPageObject){
      this.main = mainPageObject;
  }

    @Override
    public void openNavigation() {
      System.out.println("Method openNavigation() dose nothing to platform"+ Platform.getInstance().getPlatformVar());
    }

    @Override
    public void clickMyLists() {
      main.waitForElementPresent(
              MY_LIST_BUTTON,
              "Cannot find navigation button to my lists",
              5
      );
      main.waitForElementAndClick(
              MY_LIST_BUTTON,
              "Cannot find navigation button to my lists",
              5
      );
    }
}
