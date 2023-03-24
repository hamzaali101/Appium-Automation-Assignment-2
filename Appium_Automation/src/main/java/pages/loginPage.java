package pages;
import baseTest.appDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class loginPage {
    public loginPage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(appDriver.getDriver()), this);
    }


    @FindBy(id = "com.booking:id/identity_header_title")
    public WebElement pageHeader;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement SignInBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Create your account']")
    public WebElement createAccountBtn;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement email;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc ='Show password']")
    public List<WebElement> eyeIcon;
    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public List<WebElement> password;
    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public List<WebElement> confirmPass;

    @FindBy(xpath = "//android.widget.TextView[@text='Continue']")
    public WebElement cont;


    @FindBy(xpath = "//android.widget.Button[@index='0']")
    public WebElement signUpBtn;



    By by_pageheader = By.id("com.booking:id/identity_header_title");

    public void waitForElement(WebDriver d, WebElement elem){
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElements(WebDriver d, List<WebElement> elem){
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfAllElements(elem));
    }

    public void clickCreateAccountBtn(){
        waitForElement(appDriver.getDriver(), createAccountBtn);
        createAccountBtn.click();
    }
    public void enterEmail(String emai){
        waitForElement(appDriver.getDriver(), email);
        email.sendKeys(emai);
    }
    public void enterPass(String pass){

        waitForElements(appDriver.getDriver(), eyeIcon);
        waitForElements(appDriver.getDriver(), password);
        password.get(0).sendKeys(pass);
    }
    public void enterConfirmPass( String pass){
        waitForElements(appDriver.getDriver(), confirmPass);
        confirmPass.get(1) .sendKeys(pass);
    }

    public void clickSignUpBtn(){
        waitForElement(appDriver.getDriver(), signUpBtn);
        signUpBtn.click();
    }

    public void clickContBtn(){
        waitForElement(appDriver.getDriver(), cont);
        cont.click();
    }

}