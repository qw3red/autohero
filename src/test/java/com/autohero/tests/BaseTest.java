package com.autohero.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.autohero.com/";
        Configuration.browserSize = "1600x1200";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
    }
}
