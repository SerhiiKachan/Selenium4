package com.epam.lab.specific_element;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebElement;

public class Button extends IElement.Element {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(CharSequence... charSequences) {
        throw new UnsupportedCommandException("Information can't be typed into button.");
    }

    public void clear() {
        throw new UnsupportedCommandException("Text can't be erased.");
    }

    public boolean isSelected() {
        throw new UnsupportedCommandException("Button can't be checked or unchecked.");
    }

}
