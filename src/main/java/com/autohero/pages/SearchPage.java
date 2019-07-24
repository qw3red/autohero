package com.autohero.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private SelenideElement registrationDateSelector = $x("//*[@data-qa-selector='filter-year']");
    private SelenideElement dateDropdown = $x("//*[@data-qa-selector='filter-year']//*[@data-qa-selector='select']");
    private SelenideElement sortingDropDown = $x ("//*[contains(text(), 'Sortiert nach')]//..//*[@data-qa-selector='select']");

    public SelenideElement selectedYear = $x("//*[@data-qa-selector='active-filter']");
    public ElementsCollection yearsSorted = $$x("//li[@data-qa-selector='spec'][1]");
    public ElementsCollection priceSorted = $$x("//*[@data-qa-selector='price']");

    public SearchPage clickRegistrationDateBlock () {
        registrationDateSelector.click();
        return this;
    }

    public SearchPage clickRegisteredFromDropDown() {
        dateDropdown.click();
        return this;
    }

    public SearchPage selectYearFromDropdown(String year) {
        $x("//*[@data-qa-selector-value='" + year + "']").click();
        Utils.refreshAfterDropDown();
        return this;
    }

    public SearchPage clickSortingDropdown() {
        sortingDropDown.click();
        return this;
    }

    public SearchPage selectSortingValue (String sorting) {
        $x("//*[contains(text(), '" + sorting + "')]").click();
        Utils.refreshAfterDropDown();
        return this;
    }
}
