package com.wikipedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationPage extends BasePage{


    public InformationPage(WebDriver driver) {
        super(driver);
    }


    private final By headerXpath = By.xpath("//*[@id='firstHeading']");

    public String getPageInformationHeaderText() {
        String input = getWebElement(headerXpath).getText();
        Pattern pattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            return  matcher.group(1).trim();
        }
        return "";
    }

}
