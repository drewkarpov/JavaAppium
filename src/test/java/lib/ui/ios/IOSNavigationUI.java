package lib.ui.ios;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.ui.interfaces.INavigationUI;

public class IOSNavigationUI implements INavigationUI {

    private String MY_LIST_BUTTON = "id:Saved";
    private MainPageObject main;

    public IOSNavigationUI(MainPageObject mainPageObject) {
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
