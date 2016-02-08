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
public class BoardPage extends PageObject{
    public List<String> getListOfCards(String listName){
        List<WebElement> listOfCards = driver.findElements(By.xpath("//h2[.='" + listName + "']/../../descendant::a[@class='list-card-title js-card-name']"));
        return listOfCards.stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public void dragAndDropCard(String cardName, String targetList){
        (new Actions(driver)).dragAndDrop(driver.findElement(By.xpath("//a[contains(text(),'" + cardName + "')]")), driver.findElement(By.xpath("//h2[.='" + targetList + "']/../.."))).perform();
    }
}
