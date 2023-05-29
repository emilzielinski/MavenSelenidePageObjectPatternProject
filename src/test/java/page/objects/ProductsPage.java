package page.objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    public SelenideElement logoName = $(byClassName("app_logo"));
    public SelenideElement hamburgerMenuButton = $(byId("react-burger-menu-btn"));
    public ElementsCollection table = $$(byClassName("bm-item"));
    public SelenideElement aboutSection = $(byId("about_sidebar_link"));
    public SelenideElement sortContainer = $(byXpath("//*[@data-test='product_sort_container']"));
    public ElementsCollection inventoryNameContainer = $$(byClassName("inventory_item_name"));
    public ElementsCollection inventoryPriceContainer = $$(byClassName("inventory_item_price"));


}
