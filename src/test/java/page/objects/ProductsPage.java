package page.objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    public SelenideElement logoName = $(byClassName("app_logo"));

}
