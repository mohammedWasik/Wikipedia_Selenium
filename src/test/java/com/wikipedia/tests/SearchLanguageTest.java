package com.wikipedia.tests;

import com.wikipedia.pages.HomePage;
import com.wikipedia.pages.QueryPage;
import com.wikipedia.utils.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchLanguageTest extends BaseTest {
    private final Config config = new Config();

    @Test(priority = 1)
    public void homePageIsAvailable() {
        HomePage homePage = page.getInstance(HomePage.class);
        Assert.assertTrue(homePage.ishomePageAvailable());
        Assert.assertEquals(homePage.getPageTitle(), "Wikipedia", "Titles don't match,so not the home page desired");
    }

    @Test(priority = 2)
    public void inputQuery() {
        HomePage homePage = page.getInstance(HomePage.class);
        System.out.println(config.getLanguage());
        QueryPage queryPage = homePage.searchQuery(config.getQuery()).selectLanguage(config.getLanguage()).clickSearchBtn();
        Assert.assertTrue(queryPage.isPageOpen(),"page is not open");
    }


}
