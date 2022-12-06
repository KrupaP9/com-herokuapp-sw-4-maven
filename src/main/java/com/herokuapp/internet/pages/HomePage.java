package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By secureAreaText = By.xpath("//div[@class='example']/h2");
    public String getSecureAreaText(){
        return getTextFromElement(secureAreaText);
    }
}
