package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.MainPage;

public class Search extends Main{

    @Test
    public void searchWithKeyboard() {
        String expectedUrl = "http://www.seleniumhq.org/";
        MainPage mainPage = new MainPage();
        mainPage.activateKeyboard()
                .enterSearchCriteria()
                .performSearch()
                .clickOnSearchResultLink("Selenium - Web Browser Automation");
        Assert.assertEquals(getPageUrl(), expectedUrl, "Correct Site was opened");
    }
}