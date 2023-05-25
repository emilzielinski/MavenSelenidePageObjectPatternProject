package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.objects.ProductsPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;

public class PositiveHamburgergMenuRedirectionTest extends PositiveLoginTest {

    @Test
    public void successfullSelectSectionFromHamburgerMenu(){

        successfulLoginWithGoodCredentials();

        ProductsPage productsPage = new ProductsPage();
        productsPage.hamburgerMenuButton.click();

        /*Assertion*/
        productsPage.table.shouldHave(size(4));
        /*End of assertion*/

        productsPage.aboutSection.click();

        /*Assertion*/
        $(By.xpath("//*[@src='/images/logo.svg']")).shouldBe(Condition.visible);
        /*End of assertion*/


    }

}
