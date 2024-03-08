package com.wikipedia.tests;

import com.wikipedia.pages.DownloadPage;
import com.wikipedia.pages.HomePage;
import com.wikipedia.pages.QueryPage;
import com.wikipedia.utils.Config;
import com.wikipedia.utils.FileUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PdfDownloadTest extends BaseTest {
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
    public void goToDownloadPage(){
        QueryPage queryPage = page.getInstance(QueryPage.class);
        DownloadPage downloadPage = queryPage.clickToolsBtn().clickDownloadBtn();
    }
    @Test(priority = 4)
    public void downloadPdf(){
        DownloadPage downloadPage = page.getInstance(DownloadPage.class);
        downloadPage.getPdfName().clickDownloadBtn();
        File file = new File(config.getDownloadDir()+"/"+config.getPdfName());
        Assert.assertTrue(new FileUtility().doesFileExist(file),"File doesnt exist");
        new FileUtility().deleteFileIfExist(file);
    }







}
