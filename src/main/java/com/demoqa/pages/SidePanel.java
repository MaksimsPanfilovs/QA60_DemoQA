package com.demoqa.pages;

import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.bookStore.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage slectLogin() {
//        clickWithJS(login, 0, 600);
        click(login);
        return new LoginPage(driver);
    }


    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }


    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;
    public SidePanel selectFrame() {
        click(frames);
        return new SidePanel(driver);
    }
}
