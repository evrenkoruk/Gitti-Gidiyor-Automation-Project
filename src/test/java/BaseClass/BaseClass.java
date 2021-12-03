package BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static Cons.Cons.*;


public class BaseClass {
    private static org.apache.logging.log4j.Logger Logger = LogManager.getLogger();
        public WebDriver webDriver;

        @Before
        public void main()
        {

            WebDriverWait webDriverWait;
            String baseUrl = "https://www.gittigidiyor.com";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions options = new ChromeOptions();
            String Path = "resources/chromedriver";

            if (Platform.getCurrent().toString().contains("WIN")) {
                Path = "resources/chromedriver.exe";
            }
            System.setProperty("webdriver.chrome.driver", Path);
            options.setExperimentalOption("w3c", false);
            options.addArguments("--disable-notifications");
            options.addArguments("disable-popup-blocking");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            webDriver = new ChromeDriver(capabilities);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            webDriverWait = new WebDriverWait(webDriver, 45, 150);
            webDriver.manage().window().maximize();
            webDriver.get(baseUrl);
        }

        public void checkUrl()
        {
            Assert.assertTrue(URL.contains("https://www.gittigidiyor.com/"));
            Logger.info("Homepage Checked."+ URL);
        }

        public void checkLogin()
        {
            Assert.assertNotNull(LOGINCONTROL);
            Logger.info("Access Control Done."+ LOGINCONTROL);
        }

        public void checkCart()
        {
            Assert.assertTrue(EMPTYBASKET.contains("Sepetinizde ürün bulunmamaktadır."));
            Logger.info("No Product Available. Text Checked"+ EMPTYBASKET);
        }

        public void ElementToBeClickableAndClick(By element)
        {
            WebDriverWait wait = new WebDriverWait(webDriver,30);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            Logger.info(element+" ");
        }
        public void click(By byElement) {
        webDriver.findElement(byElement).click();
        Logger.info(byElement + " Element clicked");
         }

        public void ElementSendKey(By element,String sendkey)
        {
            WebDriverWait wait = new WebDriverWait(webDriver,30);
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(sendkey);
            Logger.info(element+"The page was expected to be clickable and clicked.");
        }

        private WebElement findElement(By element)
        {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
            WebElement webElement = webDriverWait.
                    until(ExpectedConditions.presenceOfElementLocated(element));
            ((JavascriptExecutor) webDriver).executeScript(
                    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                    webElement);
            return webElement;

        }
        public WebElement findElementByXpath(String xpath)
        {
            return webDriver.findElement(By.xpath(xpath));
        }

        public void hoverElement(By by)
        {
        Actions action = new Actions(webDriver);
        action.moveToElement(findElement(by)).build().perform();
        Logger.info("Click done with Hover");

        }

        public  void  addNewTab()
        {
        ((JavascriptExecutor) webDriver).executeScript("window.open();");
        //Get handles of the windows
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                webDriver.get("https://www.gittigidiyor.com/");
            }
        }
            Logger.info("New tab opened");
        }
        @After
        public void quit() throws InterruptedException
        {
            Thread.sleep(1000);
            webDriver.quit();
        }
    }


