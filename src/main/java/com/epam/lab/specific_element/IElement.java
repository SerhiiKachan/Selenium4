package com.epam.lab.specific_element;

import org.openqa.selenium.*;

public interface IElement {

    class Element implements IElement {

        WebElement webElement;

        Element(WebElement webElement) {
            this.webElement = webElement;
        }

        public void click() {
            webElement.click();
        }

        public String getAttribute(String name){
            return webElement.getAttribute(name);
        }
    }
}
