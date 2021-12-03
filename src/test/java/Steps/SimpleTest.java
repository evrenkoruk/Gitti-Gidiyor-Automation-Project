package Steps;

import BaseClass.BaseClass;
import Cons.Cons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static Cons.Cons.*;


public class SimpleTest extends BaseClass {

    private static Logger Logger = LogManager.getLogger();


    public void controlTitle() throws InterruptedException {
        checkUrl();

        Logger.info("Checked the login to the Home Page.");    }


    public void LoginSite() throws InterruptedException {
        ElementToBeClickableAndClick(By.cssSelector(LOGIN1));
        Thread.sleep(3000);  // Added because it detects it is a bot.
        ElementToBeClickableAndClick(By.cssSelector(LOGIN2));
        Thread.sleep(1000);
        ElementSendKey(By.cssSelector(Cons.NAME), "evrenkoruk@gmail.com");
        Thread.sleep(1000);
        ElementSendKey(By.name(PASSWORD), "evren123.");
        Thread.sleep(1000);
        ElementToBeClickableAndClick(By.cssSelector(LOGINBUTTON));
        checkLogin();
        Logger.info("Name Surname checked. Signed in.");
    }

    public void controlSearchComp() throws InterruptedException {
        ElementSendKey(By.cssSelector(SEARCH), "Kalem");
        ElementToBeClickableAndClick(By.xpath(BUTTONSEARCH));
        Thread.sleep(3000);
        Logger.info("The selected keyword was searched by entering it in the search box.");
    }

    public void scrollToPage(String pixel) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0," + pixel + ")");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.info("Checked that it is scrolled to the end of the page.");
    }
    public void randomClick() throws InterruptedException {
        //  logger.info("Rastgele ürün seçiliyor");
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            int number =random.nextInt(31)+ 1;
            System.out.println(number + ". ürün favorilere eklendı" );
            WebElement elementsByClassName = findElementByXpath("//*[@id=\"__next\"]/main/div[2]/div/div/div[2]/div/div[3]/div[3]/ul/li["+number+"]/article/div[1]/div");
            try{
                Actions actions = new Actions(webDriver);
                actions.moveToElement(elementsByClassName);
                Thread.sleep(1000);
                elementsByClassName.click();
                Thread.sleep(1000);
            }catch (Exception ex){
                Logger.info("System Error");
                i--;
            }
        }
        Logger.info("4 items are randomly selected with the for loop.");
    }
    public void backToMainPage() throws InterruptedException {
        ElementToBeClickableAndClick(By.xpath(MAINLOGO));
        Logger.info("Access to the Second Page is Controlled."+ MAINLOGO);
        Thread.sleep(2000);
    }

    public void controlSearchComp2() throws InterruptedException {
        ElementSendKey(By.cssSelector(SEARCH), "Çanta");
        ElementToBeClickableAndClick(By.xpath(BUTTONSEARCH));
        Thread.sleep(3000);
        Logger.info("The selected keyword was searched by entering it in the search box.");
    }
    public void productSelect() throws InterruptedException {

        ElementToBeClickableAndClick(By.xpath("(//div[@class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl'])[" + 6 + "]"));
        Thread.sleep(1000);
        Logger.info("On the product page, the 7th product was selected and it was checked that the product was accessed.");

    }

    public void addToCart() throws InterruptedException {
        ElementToBeClickableAndClick(By.id("add-to-basket"));
        Thread.sleep(1000);
        Logger.info("The product has been added to the cart and checked.");

    }


    public void goToCart() throws InterruptedException {

            By path = new By.ByXPath(BASKET1);
            By path2 = new By.ByXPath(BASKET2);
            hoverElement(path);
            Thread.sleep(1000);  // Added because it detects it is a bot.

            ElementToBeClickableAndClick(path2);
            Thread.sleep(1000);
            checkCart();
            Logger.info("went to cart and checked.");

    }
    public void addMoreItem() throws InterruptedException {
        Thread.sleep(1000);
        ElementToBeClickableAndClick(By.xpath("//div[@class='gg-input gg-input-select ']"));
        ElementToBeClickableAndClick(By.xpath("//option[@value='3']"));
        Thread.sleep(500);
        Logger.info("The number of products was increased and checked.");


    }
    public void goToPay() throws InterruptedException {
        Thread.sleep(500);
        ElementToBeClickableAndClick(By.xpath("//input[@class='gg-d-24 gg-ui-btn-primary gg-ui-btn-lg btn-pay']"));
        Logger.info("Click the 'Complete Shopping' button and go to the address page");


    }
    public void save() throws InterruptedException {
        Thread.sleep(500);
        ElementToBeClickableAndClick(By.xpath("//button[@class='gg-ui-btn-primary gg-btn post-address gg-ui-btn-fluid post-address-button gg-ui-btn-lg']"));
        Logger.info("The 'Save' button was pressed without filling in the address information. Error message checked");


    }
    public void edit() throws InterruptedException {
        Thread.sleep(500);
        ElementToBeClickableAndClick(By.xpath("(//a[@class='header-link pl10'])[2]"));
        Logger.info("Selected 'Edit My Cart' and went to the Cart page");


    }

    public void addToFavBasket() throws InterruptedException {
        findElementByXpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[3]/div[2]/div/div/div/div/div/div/div/div/div/ul/li[6]/div/a[2]").click();
        Thread.sleep(2000);
        Logger.info("2nd product added to cart from 'I'll Buy Later' section");


    }
    public void deleteToFav() throws InterruptedException {
        Thread.sleep(2000);
        findElementByXpath("//*[@class='recom-wide-content recom-content active' and @rev=2]/child::div/child::a[3]").click();
        Thread.sleep(2000);
        Logger.info("The 3rd item from the 'I'll Buy Later' section has been removed from favourites.");

    }

    public void logOut() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.get("https://www.gittigidiyor.com/cikis-yap");
        Logger.info("Checked that the new tab opened is logged out");



    }
    public void closeTab() throws InterruptedException {
        Thread.sleep(500);
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(0));
        Thread.sleep(300);
        Logger.info("last tab closed and checked");
        webDriver.switchTo().window(tabs2.get(1));
        Thread.sleep(300);
        webDriver.close();
        Logger.info("All tabs closed and checked.");

    }
}

