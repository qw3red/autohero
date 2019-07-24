package com.autohero.tests;

import com.autohero.pages.SearchPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    SearchPage searchPage = new SearchPage();

    @BeforeClass
    void openSearchPage() {
        Selenide.open("de/search");
    }

    @Test
    void openSearchPageTest() {
        searchPage.clickRegistrationDateBlock()
                .clickRegisteredFromDropDown()
                .selectYearFromDropdown("2015");
        Selenide.sleep(10000);
        searchPage.selectedYear.shouldHave(Condition.text("Erstzulassung von: 2015"));
    }
}
