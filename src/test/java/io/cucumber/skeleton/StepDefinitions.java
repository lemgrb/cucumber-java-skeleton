package io.cucumber.skeleton;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    private AppiumDriver driver;

    @Before
    public void openApp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("C:/Users/kinab/Downloads/ApiDemos-debug.apk")
                .setFullReset(true)
                .eventTimings();
        driver = new AndroidDriver(new URL("http://localhost:4723"),options);
    }

    @Given("I tap on Accessibility")
    public void I_tap_on_accessibility() {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        element.click();

        // Assert
        List<WebElement> elementList = driver.findElements(AppiumBy.id("android:id/text1"));
        List<String> elementsListString = elementList.stream().map(e -> e.getText()).collect(Collectors.toList());

        assertTrue(elementsListString.size()==4, "Size is not equal to four (4)");
    }
    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        Belly belly = new Belly();
        belly.eat(cukes);
    }

    @When("I wait {int} hour")
    public void i_wait_hour(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("my belly should growl")
    public void my_belly_should_growl() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @After
    public void closeApp() {
        if (null != driver) {
            driver.quit();
        }
    }
}
