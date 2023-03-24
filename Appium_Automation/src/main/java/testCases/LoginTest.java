package testCases;

import baseTest.appFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;
import utilities.excelReader;

import java.net.MalformedURLException;
import java.util.Random;

public class LoginTest {

    excelReader xlsReader;
    private loginPage logPage;

    @BeforeTest
    public void setup() throws MalformedURLException{
        xlsReader = new excelReader();
        xlsReader.readExcelFile();
        appFactory.initializer();
        logPage = new loginPage();
    }

    @Test
    public void creageAccount() throws InterruptedException{
        String email = excelReader.getCellValueFromSheet(1,0);
        String pass = excelReader.getCellValueFromSheet(1,1);
        Assert.assertTrue(logPage.pageHeader.isDisplayed());
        logPage.clickCreateAccountBtn();
        logPage.enterEmail(email+ random() + "@gmail.com");
        logPage.clickContBtn();
        Assert.assertTrue(logPage.pageHeader.isDisplayed());
        logPage.enterPass(pass);
        Assert.assertTrue(logPage.pageHeader.isDisplayed());
        logPage.enterConfirmPass(pass);
        logPage.clickSignUpBtn();

    }

    @AfterTest
    public void Teardown(){
        appFactory.quitDriver();
    }

    public  int random(){
        Random rand = new Random();
        int x = rand.nextInt(900) + 100;
        return x;
    }
}
