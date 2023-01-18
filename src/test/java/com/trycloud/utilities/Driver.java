package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
        if (driverPool.get() == null){
            String browserType = ConfigReader.getProperty("browser".toLowerCase());

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }

    /**
     * static String browser;
     *
     *     private Driver() {
     *     }
     *
     *     private static WebDriver driver;
     *
     *     public static WebDriver getDriver() {
     *         if (driver == null) {
     *             if (System.getProperty("BROWSER") == null) {
     *                 browser = ConfigurationReader.getProperty("browser");
     *             } else {
     *                 browser = System.getProperty("BROWSER");
     *             }
     *             System.out.println("Browser: " + browser);
     *             switch (browser) {
     *                 case "remote-chrome":
     *                     try {
     *                         // assign your grid server address
     *                         String gridAddress = "3.93.188.212";
     *                         URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
     *                         DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
     *                         desiredCapabilities.setBrowserName("chrome");
     *                         driver = new RemoteWebDriver(url, desiredCapabilities);
     *                     } catch (Exception e) {
     *                         e.printStackTrace();
     *                     }
     *                     break;
     *                 case "remote-firefox":
     *
     *                     try {
     *                         // assign your grid server address
     *                         String gridAddress = "52.90.101.17";
     *                         URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
     *                         DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
     *                         desiredCapabilities.setBrowserName("firefox");
     *                         driver = new RemoteWebDriver(url, desiredCapabilities);
     *                     } catch (Exception e) {
     *                         e.printStackTrace();
     *                     }
     *                     break;
     *                 case "chrome":
     *                     WebDriverManager.chromedriver().setup();
     *                     driver = new ChromeDriver();
     *                     break;
     *                 case "chrome-headless":
     *                     WebDriverManager.chromedriver().setup();
     *                     driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
     *                     break;
     *                 case "firefox":
     *                     WebDriverManager.firefoxdriver().setup();
     *                     driver = new FirefoxDriver();
     *                     break;
     *                 case "firefox-headless":
     *                     WebDriverManager.firefoxdriver().setup();
     *                     driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
     *                     break;
     *
     *                 case "ie":
     *                     if (System.getProperty("os.name").toLowerCase().contains("mac")) {
     *                         throw new WebDriverException("Your operating system does not support the requested browser");
     *                     }
     *                     WebDriverManager.iedriver().setup();
     *                     driver = new InternetExplorerDriver();
     *                     break;
     *
     *                 case "edge":
     *                     if (System.getProperty("os.name").toLowerCase().contains("mac")) {
     *                         throw new WebDriverException("Your operating system does not support the requested browser");
     *                     }
     *                     WebDriverManager.edgedriver().setup();
     *                     driver = new EdgeDriver();
     *                     break;
     *
     *                 case "safari":
     *                     if (System.getProperty("os.name").toLowerCase().contains("windows")) {
     *                         throw new WebDriverException("Your operating system does not support the requested browser");
     *                     }
     *                     WebDriverManager.getInstance(SafariDriver.class).setup();
     *                     driver = new SafariDriver();
     *                     break;
     *             }
     *         }
     *
     *         return driver;
     *     }
     *
     *     public static void closeDriver() {
     *         if (driver != null) {
     *             driver.quit();
     *             driver = null;
     *         }
     *     }
     */



}