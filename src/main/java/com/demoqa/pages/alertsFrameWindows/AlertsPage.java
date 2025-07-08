package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "button#timerAlertButton")
    WebElement timerAlertBtn;

    public AlertsPage alertWithTimer() {
        click(timerAlertBtn);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent()).accept();


        return this;
    }


    @FindBy(id = "confirmButton")
    WebElement confirmBtn;

    public AlertsPage selectResult(String result) {
//        clickWithJS(confirmBtn, 0, 300);
        click(confirmBtn);
        if (result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }


    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage verifyResult(String text) {
        Assert.assertTrue(confirmResult.getText().contains(text));
        return this;
    }


    @FindBy(id = "promtButton")
    WebElement promtBtn;
    public AlertsPage sendMessageToAlert(String message) {
//        clickWithJS(promtBtn, 0, 100);
        click(promtBtn);
        if(message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promtResult;
    public AlertsPage verifyMessage(String text) {
        Assert.assertTrue(promtResult.getText().contains(text));
        return this;
    }
}
