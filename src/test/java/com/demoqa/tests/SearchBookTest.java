package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.bookStore.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookPositiveTest() {
        new ProfilePage(driver).typeKeyInSearchInput("git")
                .verifyNameOfBook("Git");

    }


}
