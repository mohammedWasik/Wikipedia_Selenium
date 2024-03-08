package com.wikipedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By homeId = By.id("www-wikipedia-org");
    private final By inputId = By.id("searchInput");
    private final By searchBtn = By.xpath("(//button[@type='submit'])[1]");
    private final By languageSelect=By.id("searchLanguage");

    public boolean ishomePageAvailable(){
        return getWebElement(homeId).isDisplayed();
    }
    public HomePage searchQuery(String query){
        getWebElement(inputId).sendKeys(query);
        return this;
    }
    public QueryPage clickSearchBtn(){
        getWebElement(searchBtn).click();
        return getInstance(QueryPage.class);
    }
    public HomePage selectLanguage(String language){
        WebElement element =getWebElement(languageSelect);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(language);
        return this;
    }
}
