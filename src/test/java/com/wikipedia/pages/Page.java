package com.wikipedia.pages;

import com.wikipedia.utils.Values;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public abstract class Page {
    final WebDriver driver;
    final WebDriverWait wait;

    Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Values.wait));
    }

    public abstract void waitForElement(By locator);

    public abstract String getPageTitle();

    public abstract WebElement getWebElement(By locator);

    public abstract List<WebElement> getWebElements(By selector);

    public <T extends BasePage> T getInstance(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor(WebDriver.class)
                    .newInstance(this.driver);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}