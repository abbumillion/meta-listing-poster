package com.app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        new Thread(new Poster()).start();
    }
}


class Poster implements Runnable{
    @Override
    public void run() {
        ChromeOptions options;
        WebDriver driver;
        Map<String, Object> prefs = new HashMap<String, Object>();
        //add key and value to map as follow to switch off browser notification
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 2);
        //Create an instance of ChromeOptions
        options = new ChromeOptions();
        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);
        //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
        driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));
        email.sendKeys("0923683988");
        pass.sendKeys("million@03043623683988");
        loginButton.click();


        List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
        for (WebElement webElement : allLinks) {
            if (webElement.isDisplayed() && webElement.getText().equalsIgnoreCase("Marketplace")) {
                webElement.click();
            }
        }




        List<WebElement> webElements1 = driver.findElements(By.xpath("//a[@href]"));
        for (WebElement webElement : webElements1) {
            if (webElement.getText().contains("Create new listing")) {
                webElement.click();
                break;
            }
        }



        List<WebElement> webElements2 = driver.findElements(By.tagName("a"));
        for (WebElement webElement1 : webElements2)
        {
            if (webElement1.getText().contains("Item for sale"))
            {
                webElement1.click();
            }
        }

        List<WebElement> webElements3 = driver.findElements(By.tagName("input"));
        for (WebElement webElement : webElements3)
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].enabled = true", webElement);
            System.out.println("this element is enabled...");
            webElement.sendKeys("values");
        }
    }
}