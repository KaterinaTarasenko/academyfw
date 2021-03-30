package org.academy.utils.helpers;

import org.academy.utils.ui.waiters.WebWaiters;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;


public class WebHelpers extends WebWaiters {

    public void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollWindowBy(WebDriver driver, int shiftPixels) {
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollBy(0,%s);", shiftPixels));
    }

    public void switchWindowTab(WebDriver driver, int windowInQueue) {
        List<String> listWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listWindows.get(windowInQueue));
    }

    public void switchToLastOpenedTab(WebDriver driver) {
        ArrayList<String> allTab = new ArrayList<>(driver.getWindowHandles());
        int lastTab = (allTab.size()) - 1;
        driver.switchTo().window(allTab.get(lastTab));
    }

    public String acceptAlert() {
        waitUntilAlertPresent();
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void refreshPage() {
        webDriver.navigate().refresh();
    }

    public void deleteCookieByName(String name) {
        Cookie cookie = webDriver.manage().getCookies().stream().filter(x -> x.getName().equals(name)).findFirst().get();
        if (cookie != null) {
            webDriver.manage().deleteCookie(cookie);
        } else {
            webDriver.manage().deleteAllCookies();
        }
    }

    public void openNewBlankBrowserTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

}
