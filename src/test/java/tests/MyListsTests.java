package tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.*;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.MyListPageObjectFactory;
import ui.factories.NavigationUIPageObjectFactory;
import ui.factories.SearchPageObjectFactory;
import ui.AuthorizationPageObject;

public class MyListsTests extends CoreTestCase {

    private static final String folderName = "My folder";
    private static final String login = "EugeniyaD";
    private static final String password = "utkaUtka41684";

    @Test
    public void testSaveAndDeleteArticleToReadindList() throws IllegalAccessException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject;
        ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUIPageObject NavigationUIPageObject = NavigationUIPageObjectFactory.get(driver);
        MyListsPageObject MyListsPageObject = MyListPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        String firstArticleTitleOnSearch = "Indonesian island";
        SearchPageObject.goToTitle(firstArticleTitleOnSearch);
        ArticlePageObject.addArticleToFavoriteList();
        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            MyListsPageObject.waitForTitle(firstArticleTitleOnSearch);
            ArticlePageObject.addArticleToFavoriteList();
        }

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.confirmArticleSelection();
            ArticlePageObject.clearDefaultNameOfFolder();
            ArticlePageObject.giveArticleNewName(folderName);
            ArticlePageObject.confirmArticleAddiction();
            NavigationUIPageObject.exitFromArticlePage();
        }
        SearchPageObject.initSearchInput();
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isMW()) {
            SearchPageObject.typeSearchLine("Java");
        }
        String secondArticleTitleOnSearch = "Object-oriented programming language";
        SearchPageObject.goToTitle(secondArticleTitleOnSearch);
        ArticlePageObject.addArticleToFavoriteList();
        NavigationUIPageObject.openNavigation();
        NavigationUIPageObject.clickMyLists();
        MyListsPageObject.swipeByArticleToDeleteForMW();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToExistingFolder(folderName);
        }
        NavigationUIPageObject.exitFromArticlePage();
        NavigationUIPageObject.goToSavedFolders();
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.goToSelectedFolder();
            String firstArticleTitle = "object-oriented programming language";
            String secondArticleTitle = "Indonesian island";
            MyListsPageObject.deleteArticle(firstArticleTitle);
            MyListsPageObject.waitForTitle(secondArticleTitle);
            MyListsPageObject.waitNotForTitle(firstArticleTitle);
        } else if (Platform.getInstance().isIOS()) {
            MyListsPageObject.swipeToDeleteArticleForIOS();
            MyListsPageObject.waitNotForTypeImage();
        } else {
            SearchPageObject.clickByArticleWithSubstringForMW();
            ArticlePageObject.waitForTitleElement();
            String first_element_in_list = ArticlePageObject.getArticleTitle();
            assertEquals(
                    "Cannot presented this element",
                    secondArticleTitleOnSearch,
                    first_element_in_list
            );
        }
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

        String title3 = "Jamaica, Queens";
        String description3 = "Neighborhood of Queens, New York City";
        SearchPageObject.waitForElementByTitleAndDescription(title3, description3);
    }
}

