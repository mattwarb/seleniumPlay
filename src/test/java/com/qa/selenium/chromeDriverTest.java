package com.qa.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class chromeDriverTest {

    private static WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromeDriver/chromeDriver.exe");

        driver = new ChromeDriver();

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void exampleTest() throws InterruptedException{
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        WebElement googleSearchField = driver.findElement(By.name("q"));
        Thread.sleep(1000);
        googleSearchField.sendKeys("doggos");
        Thread.sleep(1000);
        googleSearchField.submit();
        Thread.sleep(1000);
        WebElement doggo = driver.findElement((By.partialLinkText("What is a Pupper? What is a Doggo?")));
        doggo.click();
        Thread.sleep(200000);

    }
    @Test
    public void demoSite() throws InterruptedException{
        driver.manage().window().fullscreen();
        driver.get("https://www.thedemosite.co.uk/");
        Thread.sleep(1000);
        WebElement addUser = driver.findElement(By.linkText(("3. Add a User")));
        addUser.click();
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("mwarb");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");
        Thread.sleep(1000);
        WebElement create = driver.findElement(By.name("FormsButton2"));
        create.click();
        Thread.sleep(1000);
        WebElement logIn = driver.findElement(By.linkText(("4. Login")));
        logIn.click();
        Thread.sleep(1000);
        WebElement userName2 = driver.findElement((By.name("username")));
        userName2.sendKeys("mwarb");
        Thread.sleep(1000);
        WebElement password2 = driver.findElement(By.name("password"));
        password2.sendKeys("password");
        Thread.sleep(1000);
        WebElement signIn = driver.findElement(By.name("FormsButton2"));
        signIn.click();
        Thread.sleep(1000);
        //Assert.assertEquals("** Login Successful**", "<b>**Successful Login**</b>");
        WebElement success = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
        success.isDisplayed();





    }

    @Test
    public void shoppingSite()throws InterruptedException{
        driver.manage().window().fullscreen();
        driver.get("http://automationpractice.com/index.php/");
        Thread.sleep(1000);
        WebElement searchBar = driver.findElement(By.id("search_query_top"));
        searchBar.sendKeys("asdfgh");
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.name("submit_search"));
        search.click();
        Thread.sleep(1000);
        WebElement thing = driver.findElement(By.className("heading-counter"));
        Assert.assertNotEquals( 0, thing.getText().charAt(0));
        System.out.println(thing.getText().charAt(0));


    }
    @Test
    public void hotel() throws InterruptedException{
        driver.manage().window().fullscreen();
        driver.get("http://www.phptravels.net/");
        Thread.sleep(1000);

        WebElement searchBar = driver.findElement(By.tagName("input"));
        searchBar.sendKeys("London");
        Thread.sleep(1000);
        WebElement dropDown = driver.findElement((By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]")));
        dropDown.click();
        Thread.sleep(1000);


        WebElement people = driver.findElement(By.id("adults"));
        people.click();
        WebElement numpeople = driver.findElement(By.cssSelector("#adults > option:nth-child(3)"));
        numpeople.click();


        Thread.sleep(1000);
        WebElement checkout = driver.findElement(By.name("checkout"));
        checkout.clear();
        checkout.sendKeys("18/05/2018");
        checkout.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        WebElement hotel = driver.findElement(By.linkText("Grand Plaza Apartments"));
        Assert.assertTrue(hotel.isDisplayed());
    }

    @Test
    public void draggable()throws InterruptedException{
        driver.manage().window().fullscreen();
        driver.get("http://demoqa.com/");
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement draggable = driver.findElement(By.linkText("Draggable"));
        draggable.click();
        Thread.sleep(1000);
        action.dragAndDropBy(driver.findElement(By.id("draggable")),300, 200).perform();
        Thread.sleep(5000);

    }
    @Test
    public void selectable() throws InterruptedException{
        driver.manage().window().fullscreen();
        driver.get("http://demoqa.com/");
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement selectable = driver.findElement((By.linkText("Selectable")));
        selectable.click();
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[1]"))).clickAndHold().moveByOffset(200,300).release().perform();
        Thread.sleep(5000);
    }
}
