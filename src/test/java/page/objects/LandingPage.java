package page.objects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LandingPage {

    public SelenideElement loginField = $(byXpath("//*[@data-test='username']"));
    public SelenideElement passwordField = $(byXpath("//*[@data-test='password']"));
    public SelenideElement loginButton = $(byXpath("//*[@data-test='login-button']"));
    public SelenideElement loginErrorToastMessage = $(byXpath("//*[@data-test='error']"));

}
