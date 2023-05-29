package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.ProductsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PositiveLoginTest {

    public void setUp() {
        Configuration.timeout = 6000;
    }

    @Test
    public void successfulLoginWithGoodCredentials() {
        open("https://www.saucedemo.com/");

        LandingPage landingPage = new LandingPage();
        ProductsPage productsPage = new ProductsPage();

        $(landingPage.loginField).setValue("standard_user");
        $(landingPage.passwordField).setValue("secret_sauce");
        $(landingPage.loginButton).click();

        /*Assertion*/
        $(productsPage.logoName).shouldBe(Condition.visible);
        $(productsPage.logoName).shouldHave(Condition.exactText("Swag Labs"));
        /*End of assertion*/

    }

}
