package org.vaadin.jonatan.contexthelp.pageobjects;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TabSheetElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class AbstractPageObject extends TestBenchTestCase {

    public AbstractPageObject(WebDriver driver) {
        setDriver(driver);
    }

    public abstract boolean isOpen();

    protected boolean isTabSelected(final String tabCaption) {
        return isElementPresent(By.xpath("//td[contains(@class, 'v-tabsheet-tabitemcell-selected')]//div[@class='v-captiontext' and text()='" + tabCaption + "']"));
    }

//    protected void selectTab(final int index) {
//        getDriver().findElement(By.xpath("(//div[contains(@class, 'v-tabsheet-tabitem')]/div[contains(@class, 'v-caption')])[" + index + "]")).click();
//    }

    protected void selectTab(final String tabCaption) {
        $(TabSheetElement.class).first().openTab(tabCaption);
    }

    public void pressKeys(CharSequence keys) {
        new Actions(getDriver()).sendKeys(keys).build().perform();
    }

    protected WebElement buttonWithCaption(final String caption) {
        return $(ButtonElement.class).caption(caption).first();
    }

    public void unfocusEverything() {
        getDriver().findElement(By.className("v-app")).click();
    }
}
