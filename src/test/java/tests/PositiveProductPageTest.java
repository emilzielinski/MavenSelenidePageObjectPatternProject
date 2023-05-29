package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.ProductsPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;

public class PositiveProductPageTest extends PositiveLoginTest {

    @Test
    public void successfulSelectSectionFromHamburgerMenu() {

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
    public void successfulDescendingNameSorting() {

        successfulLoginWithGoodCredentials();

        ProductsPage productsPage = new ProductsPage();

        productsPage.sortContainer.selectOption(1);

        /*Assertion*/
        productsPage.inventoryNameContainer.get(0).shouldHave(Condition.exactText("Test.allTheThings() T-Shirt (Red)"));
        /*End of assertion*/

    }

    @Test
    public void successfulAscendingNameSorting() {

        successfulLoginWithGoodCredentials();

        ProductsPage productsPage = new ProductsPage();

        productsPage.sortContainer.selectOption(1);
        productsPage.sortContainer.selectOption(0);

        /*Assertion*/
        productsPage.inventoryNameContainer.get(0).shouldHave(Condition.exactText("Sauce Labs Backpack"));
        /*End of assertion*/

    }


    @Test
    public void successfulAscendingPriceSorting() {

        successfulLoginWithGoodCredentials();

        ProductsPage productsPage = new ProductsPage();

        productsPage.sortContainer.selectOption(2);

        int sizeOfTheProductList = productsPage.inventoryPriceContainer.size();

        for (int i = 0; i <= sizeOfTheProductList; i++) {
            for (int j = i + 1; j < sizeOfTheProductList; j++) {
                float price1 = Float.parseFloat(productsPage.inventoryPriceContainer.get(i).getText().substring(1));
                float price2 = Float.parseFloat(productsPage.inventoryPriceContainer.get(j).getText().substring(1));

                /*Assertion*/
                if (price1 > price2) {
                    Assert.fail("Price 1: " + price1 + " is greater than price 2: " + price2);
                }
                /*End of assertion*/
                /*Comment: I had to use TestNG Assertion due to Selenide limitations*/

            }
        }
    }
}
