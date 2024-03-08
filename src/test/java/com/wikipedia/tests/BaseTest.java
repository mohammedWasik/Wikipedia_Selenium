package com.wikipedia.tests;

import com.wikipedia.pages.BasePage;
import com.wikipedia.pages.Page;
import com.wikipedia.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseTest{
    protected WebDriver driver;
    static Page page;
    final Config config = new Config();

    @BeforeClass
    public void setupBrowser() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", config.getDownloadDir());
        prefs.put("savefile.default_directory", config.getDownloadDir());

        if(Objects.equals(config.getBrowserName(),"Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(config.getUrl());
        page = new BasePage(driver);
    }
    @AfterClass
    public void teardown() {
        driver.quit();
    }

}