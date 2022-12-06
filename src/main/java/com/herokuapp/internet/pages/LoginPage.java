package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
    By usernameErrorMessage = By.id("flash");
    By passwordErrorMessage = By.id("flash");
    public void sendTextToUsernameField(String username){
        sendTextToElement(usernameField,username);
    }
    public void sendTextToPasswordField(String password){
        sendTextToElement(passwordField,password);
    }
    public void clickLoginButton(){
        clickOnElement(loginButton);
    }
    public String getUsernameErrorMessage(){
        return getTextFromElement(usernameErrorMessage);
    }
    public String getPasswordErrorMessage(){
        return getTextFromElement(passwordErrorMessage);
    }
}
