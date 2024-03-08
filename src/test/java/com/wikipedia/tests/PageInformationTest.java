package com.wikipedia.tests;

import com.wikipedia.pages.DownloadPage;
import com.wikipedia.pages.HomePage;
import com.wikipedia.pages.InformationPage;
import com.wikipedia.pages.QueryPage;
import com.wikipedia.utils.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageInformationTest extends BaseTest{
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
        QueryPage queryPage = homePage.searchQuery(config.getQuery()).clickSearchBtn();
    }
    @Test(priority = 3)
    public void goToInformationPage(){
        QueryPage queryPage = page.getInstance(QueryPage.class);
        InformationPage informationPage=queryPage.clickToolsBtn().clickPageInformation();
    }
    @Test(priority = 4)
    public void checkCorrectPageIsDisplayed(){
        InformationPage informationPage = page.getInstance(InformationPage.class);
        String name = informationPage.getPageInformationHeaderText().trim();
        Assert.assertEquals(name,config.getQuery().trim());
    }



}
