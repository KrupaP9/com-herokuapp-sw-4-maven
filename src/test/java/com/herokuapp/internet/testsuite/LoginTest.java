package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.pages.HomePage;
import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.propertyreader.PropertyReader;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    //method to login with valid credentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //send valid username
        loginPage.sendTextToUsernameField(PropertyReader.getInstance().getProperty("validUsername"));
        //send valid password
        loginPage.sendTextToPasswordField(PropertyReader.getInstance().getProperty("validPassword"));
        //click login
        loginPage.clickLoginButton();
        String expectedSecureAreaMessage = "Secure Area";
        String actualSecureAreaMessage = homePage.getSecureAreaText();
        //verify secure area
        Assert.assertEquals(actualSecureAreaMessage,expectedSecureAreaMessage,"Secure Area Message Not Displayed");
    }
    //method to attempt login with invalid username
    @Test
    public void verifyTheUsernameErrorMessage(){
        //send invalid username
        loginPage.sendTextToUsernameField(PropertyReader.getInstance().getProperty("invalidUsername"));
        //send valid password
        loginPage.sendTextToPasswordField(PropertyReader.getInstance().getProperty("validPassword"));
        loginPage.clickLoginButton();
        String expectedUsernameError = "Your username is invalid!"+"\n×";
        String actualUsernameError = loginPage.getUsernameErrorMessage();
        //verify username error
        Assert.assertEquals(actualUsernameError,expectedUsernameError,"Error Not Displayed");
    }
    //method to attempt login with invalid username
    @Test
    public void verifyThePasswordErrorMessage(){
        //send valid username
        loginPage.sendTextToUsernameField(PropertyReader.getInstance().getProperty("validUsername"));
        //send invalid password
        loginPage.sendTextToPasswordField(PropertyReader.getInstance().getProperty("invalidPassword"));
        //click login
        loginPage.clickLoginButton();
        String expectedPasswordErrorMessage = "Your password is invalid!"+"\n×";
        String actualPasswordErrorMessage = loginPage.getPasswordErrorMessage();
        //verify error
        Assert.assertEquals(actualPasswordErrorMessage,expectedPasswordErrorMessage,"Password Error Message Not Displayed");
    }
}
