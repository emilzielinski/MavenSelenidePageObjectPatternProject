package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import page.objects.LandingPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NegativeLoginTest {

    @Test
    public void unsuccessfulLoginWithBadCredentials(){

        LandingPage landingPage = new LandingPage();

        open("https://www.saucedemo.com/");
        $(landingPage.loginField).setValue("login");
        $(landingPage.passwordField).setValue("password");
        $(landingPage.loginButton).click();

        /*Assertion*/
        $(landingPage.loginErrorToastMessage).shouldHave(Condition.exactText("Epic sadface: Username and password do not match any user in this service"));

    }

    @Test
    public void unsuccessfulLoginWithOnlyLoginCredential(){

        LandingPage landingPage = new LandingPage();

        open("https://www.saucedemo.com/");
        $(landingPage.loginField).setValue("login");
        $(landingPage.loginButton).click();

        /*Assertion*/
        $(landingPage.loginErrorToastMessage).shouldHave(Condition.exactText("Epic sadface: Password is required"));

    }

    @Test
    public void unsuccessfulLoginWithOnlyPasswordCredential(){

        LandingPage landingPage = new LandingPage();

        open("https://www.saucedemo.com/");
        $(landingPage.passwordField).setValue("password");
        $(landingPage.loginButton).click();

        /*Assertion*/
        $(landingPage.loginErrorToastMessage).shouldHave(Condition.exactText("Epic sadface: Username is required"));

    }

    @Test
    public void unsuccessfulLoginWithoutCredentials(){

        LandingPage landingPage = new LandingPage();

        open("https://www.saucedemo.com/");
        $(landingPage.loginButton).click();

        /*Assertion*/
        $(landingPage.loginErrorToastMessage).shouldHave(Condition.exactText("Epic sadface: Username is required"));

    }

}
