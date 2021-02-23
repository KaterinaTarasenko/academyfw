package org.academy.utils.ui;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class LocalWebDriverManager {
    private static WebDriver webDriver;

    public static synchronized void setWebDriver(WebDriver driver) {
        webDriver = driver;
    }

    public static synchronized WebDriver getWebDriver() {
        if (webDriver == null) {
            setWebDriver(getWebDriver(MainConfig.getBrowser()));
        }
        return webDriver;
    }

    private static WebDriver getWebDriver(String browser) {
        switch (browser) {
            default:
            case "chrome":
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                WebDriver chromeWebDriver = new ChromeDriver();

                chromeWebDriver.manage().window().maximize();
                return chromeWebDriver;

            case "chrome_selenium_server":
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                RemoteWebDriver wdriver = null;
                try {
                    wdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                assert wdriver != null;
                wdriver.manage().window().maximize();
                return wdriver;
        }
    }
}
