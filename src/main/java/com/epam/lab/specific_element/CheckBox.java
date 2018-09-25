package com.epam.lab.specific_element;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebElement;

public class CheckBox extends Element{

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public boolean isChecked() {
        return super.isSelected();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        throw new UnsupportedCommandException("Information can't be typed into checkbox.");
    }

    @Override
    public void clear() {
        throw new UnsupportedCommandException("Checkbox has no information to be cleared.");
    }
}
