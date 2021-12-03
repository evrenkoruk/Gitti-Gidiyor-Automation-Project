package Steps;

import org.junit.Test;
import org.openqa.selenium.By;

public class BaseTest extends SimpleTest {
    public static By backToMainPage;

    @Test
    public void checkAndTest() throws InterruptedException
    {

        controlTitle();
        LoginSite();
        controlSearchComp();
        scrollToPage("7200");
        randomClick();
        backToMainPage();
        checkUrl();
        controlSearchComp2();
        productSelect();
        addToCart();
        goToCart();
        addMoreItem();
        goToPay();
        save();
        scrollToPage("7200");
        edit();
        addToFavBasket();
        deleteToFav();
        addNewTab();
        logOut();
        closeTab();




    }
}
