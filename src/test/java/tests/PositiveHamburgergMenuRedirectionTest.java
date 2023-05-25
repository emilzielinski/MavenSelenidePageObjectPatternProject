package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.objects.ProductsPage;

import static com.codeborne.selenide.Selenide.$;

public class PositiveHamburgergMenuRedirectionTest extends PositiveLoginTest {

    @Test
    public void successfullSelectSectionFromHamburgerMenu(){

        successfulLoginWithGoodCredentials();

        ProductsPage productsPage = new ProductsPage();
        productsPage.hamburgerMenuButton.click();

        int size = productsPage.table.size();
        System.out.println(size);

        productsPage.aboutSection.click();

        /*Assertion*/
        $(By.xpath("//*[@src='/images/logo.svg']")).shouldBe(Condition.visible);


    }

}
