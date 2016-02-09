package framework.pageobject.pages;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class BoardPage extends PageObject {

    /**
     * Get the names of the cards present in the list as a List of Strings
     * @param listName the name of the list
     * @return list of card names as Strings, empty if there are no cards present
     */
    public List<String> getListOfCards(String listName) {
        List<WebElement> listOfCards = driver.findElements(By.xpath(String.format("//h2[.='%1$s']/../../" +
                "descendant::a[@class='list-card-title js-card-name']", listName)));
        return listOfCards.stream()
                .map(WebElement::<String>getText)
                .collect(Collectors.toList());
    }

    /**
     * Move a card from one list to another. This method finds the card in any list on the page. This method doesn't
     * check if the card and the target list are present.
     * @param cardName The name of a card as a string, case-sensitive
     * @param targetList The name of the list where the card should be dropped, case-sensitive
     */
    public void dragAndDropCard(String cardName, String targetList) {
        (new Actions(driver)).dragAndDrop(driver.findElement(By.xpath(String.format("//a[contains(text(),'%1$s')]",cardName))),
                driver.findElement(By.xpath(String.format("//h2[.='%1$s']/../..",targetList)))).perform();
    }
}
