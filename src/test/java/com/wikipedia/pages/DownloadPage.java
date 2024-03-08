package com.wikipedia.pages;

import com.wikipedia.utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class DownloadPage extends BasePage{

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    private final By pdfName = By.xpath("//div[contains(@class,'mw-electronpdfservice-selection-label-desc')]");
private final By downloadBtn = By.xpath("//button[@type='submit']");

    public DownloadPage getPdfName(){
        Config config = new Config();
        WebElement elem =getWebElement(pdfName);
        String text = elem.getText();
        config.setProperty("pdf",text);
        return this;
    }
    public DownloadPage clickDownloadBtn(){
        getWebElement(downloadBtn).click();
        return this;
    }


}
