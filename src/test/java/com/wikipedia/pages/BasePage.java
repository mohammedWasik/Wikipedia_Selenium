package com.wikipedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page{
    public BasePage(WebDriver driver){
        super(driver);

    }
    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
    @Override
    public WebElement getWebElement(By locator) {
        WebElement element =null;
        try {
            waitForElement(locator);
            element = driver.findElement(locator);
        }catch (Exception e){
            System.out.println(locator.toString()+" locator not found");
            e.printStackTrace();
        }
        return  element;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> elements =null;
        try{
            waitForElement(selector);
            elements=driver.findElements(selector);

        }catch (Exception e){
            System.out.println(selector.toString()+" selector not found");
            e.printStackTrace();
        }

        return elements;
    }

    @Override
    public void waitForElement(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(locator.toString()+" locator not found");
        }
    }
}
