package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;


public class SearchTests extends CoreTestCase {
     @Test
    public void testAssertElementHasText() throws Exception {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
    }

   @Test
    public void testCancelSearch() throws IllegalAccessException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Led Zeppelin");
        SearchPageObject.clearStringSearch();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

   @Test
    public void testTitleUsersSearch() throws Exception {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        String articleTitleOnSearch = "Island of Indonesia";
        SearchPageObject.waitForTitlePresent(articleTitleOnSearch);
        SearchPageObject.goToTitle(articleTitleOnSearch);
    }

 @Test
    public void testTitleAndDescriptionSearch() throws Exception {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Jamaica");


        String title1 = "Jamaica, Queens";
        String description1 = "Neighborhood of Queens, New York City";
        SearchPageObject.waitForElementByTitleAndDescription(title1, description1);

        String title2 = "Jamaica";
        String description2 = "Island sovereign state in the Caribbean Sea";
        SearchPageObject.waitForElementByTitleAndDescription(title2, description2);

        String title3 = "Jamaica national football team";
        String description3 = "Men's national association football team representing Jamaica";
        SearchPageObject.waitForElementByTitleAndDescription(title3, description3);
    }
}
