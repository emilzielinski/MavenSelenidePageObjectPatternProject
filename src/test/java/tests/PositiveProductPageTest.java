package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.objects.ProductsPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;

public class PositiveProductPageTest extends PositiveLoginTest {

    @Test
    public void successfulSelectSectionFromHamburgerMenu(){

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

    @Test
    public void successfulDescendingSorting() {

        successfulLoginWithGoodCredentials();

        ProductsPage productsPage = new ProductsPage();

        productsPage.sortContainer.selectOption(1);
//        System.out.println(productsPage.inventoryContainer.get(0).getText());

        /*Assertion*/
        $(productsPage.inventoryContainer.get(0)).shouldHave(Condition.exactText("Test.allTheThings() T-Shirt (Red)"));
        /*End of assertion*/

    }

    @Test
    public void successfulAscendingSorting() {

        successfulLoginWithGoodCredentials();

        ProductsPage productsPage = new ProductsPage();

        productsPage.sortContainer.selectOption(1);
        productsPage.sortContainer.selectOption(0);
//        System.out.println(productsPage.inventoryContainer.get(0).getText());

        /*Assertion*/
        $(productsPage.inventoryContainer.get(0)).shouldHave(Condition.exactText("Sauce Labs Backpack"));
        /*End of assertion*/

    }

}
