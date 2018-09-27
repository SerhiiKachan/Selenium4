package com.epam.lab.specific_element;

import org.openqa.selenium.WebElement;

public class TextInput extends IElement.Element {

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void fillInputWith(CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
    }
}
