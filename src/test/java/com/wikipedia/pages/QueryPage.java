package com.wikipedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QueryPage extends BasePage{
    public QueryPage(WebDriver driver) {
        super(driver);
    }

    private final By toolsBtn = By.id("vector-page-tools-dropdown-checkbox");
    private final By downloadBtn = By.id("coll-download-as-rl");
    private final By pageInformationXpath = By.xpath("//*[@id='t-info']");
    private final By pageHeaderXpath = By.xpath("//span[contains(@class,'mw-page-title-main')]");

    public QueryPage clickToolsBtn(){
        getWebElement(toolsBtn).click();
        return this;
    }
    public DownloadPage clickDownloadBtn(){
        getWebElement(downloadBtn).click();
        return getInstance(DownloadPage.class);
    }
    public InformationPage clickPageInformation(){
        getWebElement(pageInformationXpath).click();
        return getInstance(InformationPage.class);
    }
    public boolean isPageOpen(){
        return getWebElement(pageHeaderXpath).isDisplayed();
    }



}
