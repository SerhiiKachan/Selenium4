package com.epam.lab.specific_element;

import org.openqa.selenium.WebElement;

public class TextInput extends Element{

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void fillInputWith(CharSequence... charSequences) {
        super.clear();
        super.sendKeys(charSequences);
    }
}
