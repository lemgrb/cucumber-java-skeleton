package io.cucumber.skeleton.apidemo_pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * In Java client 8, use WebElement instead of MobileElement.
 * See https://github.com/appium/java-client/blob/master/docs/v7-to-v8-migration-guide.md#mobileelement
 *
 * Known issues:
 *
 * [8.0.0 Beta 2] PageFactory still not working with Java 17 #1619
 * https://github.com/appium/java-client/issues/1619
 */
public class BasePage {

    AppiumDriver driver;
    public static final long WAIT = 10;

    public BasePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(WebElement element){
        waitForVisibility(element);
        element.clear();
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void enterText(WebElement element, String text){
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public String getAttribute(WebElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    // TODO: tap(), scroll(), swipe()

}
