package homepage;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/** ●	Create the package homepage

 1. create class "TopMenuTest"
 1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string
 1.2 This method should click on the menu whatever name is passed as parameter.
 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
*/

 public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);  //this method comes from BaseTest
    }


    public void selectMenu(String menu) {
        List<WebElement> elementList = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement element : elementList) {
            System.out.println(element.getText());
            if (element.getText().equals(menu)) {
                element.click();
                break;
            }
        }

    }

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        Thread.sleep(3000);
        selectMenu("Gift Cards");

        Thread.sleep(3000);
        //Assert
        String expectedMessage = "Gift Cards";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Electronics is not display", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

/*if (menu == "Computers") {
        mouseHoverToElementAndClick(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        } else if (menu == "Electronics") {
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        } else if (menu == "Apparel") {
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        } else if (menu == "Digital downloads") {
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        } else if (menu == "Books") {
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
        } else if (menu == "Jewelry") {
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        } else if (menu == "Gift Cards") {
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        } else {
        System.out.println("Name not available on Menu");
        }*/

