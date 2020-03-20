package lib.ui.interfaces;

public interface ISearchMenuPageObject {

    void initSearchInput();

    void typeSearchLine(String searchLine);

    String getTextFromSearchInput();

    void waitForCancelButtonAppear();

    void waitForCancelButtonDisappear();

    void clickCancelSearch();
}
