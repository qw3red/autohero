package com.autohero.pages;

import com.codeborne.selenide.Selenide;

public class Utils {
    public static void refreshAfterDropDown() {
        //i had a row with selenium - after click on value in select the dropdown does not hiding
        //i believe there some tricky workaround but does not have a lot of time to investigate
        //the code below is not a good code but it works

        Selenide.sleep(2000);
        Selenide.refresh();
        Selenide.sleep(2000);
    }
}
