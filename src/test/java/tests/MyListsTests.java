package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;


public class MyListsTests extends CoreTestCase {
/*
private static final String folderName = "My folder";

    @Test
    public void testSaveAndDeleteArticleToReadindList() throws IllegalAccessException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUIPageObject NavigationUIPageObject = NavigationUIPageObjectFactory.get(driver);
        MyListsPageObject MyListsPageObject = MyListPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        String firstArticleTitleOnSearch = "Island of Indonesia";
        SearchPageObject.goToTitle(firstArticleTitleOnSearch);
        ArticlePageObject.addArticleToFavoriteList();
        ArticlePageObject.confirmArticleSelection();
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.clearDefaultNameOfFolder();
            ArticlePageObject.giveArticleNewName(folderName);
            ArticlePageObject.confirmArticleAddiction();
        }
        NavigationUIPageObject.exitFromArticlePage();
        SearchPageObject.initSearchInput();
        if (Platform.getInstance().isAndroid()) {
            SearchPageObject.typeSearchLine("Java");
        }
        String secondArticleTitleOnSearch = "Object-oriented programming language";
        SearchPageObject.goToTitle(secondArticleTitleOnSearch);
        ArticlePageObject.addArticleToFavoriteList();
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToExistingFolder(folderName);
        }
        NavigationUIPageObject.exitFromArticlePage();
        NavigationUIPageObject.goToSavedFolders();
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.goToSelectedFolder();
            String firstArticleTitle = "object-oriented programming language";
            String secondArticleTitle = "island of Indonesia";
            MyListsPageObject.deleteArticle(firstArticleTitle);
            MyListsPageObject.waitForTitle(secondArticleTitle);
            MyListsPageObject.waitNotForTitle(firstArticleTitle);
        }
        MyListsPageObject.swipeToDeleteArticleForIOS();
        MyListsPageObject.waitNotForTypeImage();
        }
*/
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

