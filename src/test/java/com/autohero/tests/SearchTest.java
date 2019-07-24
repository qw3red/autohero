package com.autohero.tests;

import com.autohero.pages.SearchPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import one.util.streamex.StreamEx;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class SearchTest extends BaseTest {

    private SearchPage searchPage = new SearchPage();

    @BeforeClass
    void openSearchPage() {
        Selenide.open("de/search");
    }

    @Test
    void selectAndSortCarsByPrice() {
        searchPage.clickRegistrationDateBlock()
                .clickRegisteredFromDropDown()
                .selectYearFromDropdown("2015");

        searchPage.selectedYear.shouldHave(Condition.text("Erstzulassung von: 2015"));

        searchPage.clickSortingDropdown()
                  .selectSortingValue("Höchster Preis");

        //verify that cars are 2015+ year registered
        String years = searchPage.yearsSorted.toString();
        assertThat(years).doesNotContain("2014", "2013", "2012").contains("2015", "2016", "2017");

        //verify that prices are sorted
        List<String> prices = StreamEx.of(searchPage.priceSorted)
                .map(SelenideElement::text)
                .toList();

        then(prices).isSortedAccordingTo(Comparator.comparing(String::valueOf).reversed());
    }
}
