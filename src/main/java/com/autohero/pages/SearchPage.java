package com.autohero.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    private SelenideElement registrationDateSelector = $x("//*[@data-qa-selector='filter-year']");
    private SelenideElement clickDropdown = $x("//*[@data-qa-selector='filter-year']//*[@data-qa-selector='select']");

    public SelenideElement selectedYear  = $x("//*[@data-qa-selector='active-filter']");


    public SearchPage clickRegistrationDateBlock () {
        registrationDateSelector.click();
        return this;
    }

    public SearchPage clickRegisteredFromDropDown() {
        clickDropdown.click();
        return this;
    }

    public SearchPage selectYearFromDropdown(String year) {
        //had a row with selenium - after click on value in select the dropdown does not hiding
        //i believe there some tricky workaround but does not have a lot of time to investigate
        //the code below is not a good code but it works

        $x("//*[@data-qa-selector-value='" + year + "']").click();
        Selenide.sleep(2000);
        Selenide.refresh();
        return this;
    }
}
