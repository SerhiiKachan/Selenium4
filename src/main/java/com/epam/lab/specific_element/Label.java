package com.epam.lab.specific_element;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebElement;

public class Label extends Element{

    public Label(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        throw new UnsupportedCommandException("Information can't be typed into label.");
    }

    @Override
    public void clear() {
        throw new UnsupportedCommandException("Text can't be erased.");
    }
}
