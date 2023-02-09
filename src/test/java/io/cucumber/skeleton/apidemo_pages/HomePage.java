package io.cucumber.skeleton.apidemo_pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends BasePage {

    @AndroidFindBy(accessibility = "Accessibility")
    @iOSXCUITFindBy(accessibility = "Accessibility")
    private WebElement accessibility;
    public HomePage(AppiumDriver driver) {
        super(driver);
        // NOTE: Important line or BasePage.driver = null
        this.driver = driver;
    }

    public void clickAccessibility() {
        click(accessibility);
    }

}
