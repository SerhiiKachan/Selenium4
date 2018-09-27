package com.epam.lab.page_object;

import com.epam.lab.specific_element.Button;
import com.epam.lab.specific_element.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.rmi.runtime.Log;

public class AuthorizationPage {

    private WebDriver driver;
    private final Logger LOG = Logger.getLogger(AuthorizationPage.class);

    @FindBy(xpath = "//input[@id='identifierId']")
    private TextInput email;

    @FindBy(id = "identifierNext")
    private Button emailNextButton;

    @FindBy(name = "password")
    private TextInput password;

    public AuthorizationPage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    private void enterEmail(String mail) {
        LOG.info("Entering email...");
        email.fillInputWith(mail);
        LOG.info("Completed");
        LOG.info("Submitting email...");
        emailNextButton.click();
        LOG.info("Completed");
    }

    private void enterPassword(String pass) {
        LOG.info("Entering password...");
        password.fillInputWith(pass);
        LOG.info("Completed");
        LOG.info("Submitting password...");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById('passwordNext').click();");
        LOG.info("Completed");
    }

    public void logIn(String mail, String pass) {
        LOG.info("Inside sign in form");
        enterEmail(mail);
        enterPassword(pass);
    }
}
