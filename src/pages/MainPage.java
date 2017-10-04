package pages;

import elements.Button;
import org.openqa.selenium.By;

public class MainPage {

    private Button signin = new Button(By.cssSelector("#gb_70"));
    private Button activateKeyboardButton = new Button(By.id("gs_ok0")); // title="Google apps"
    private Button activateAppMenu = new Button(By.cssSelector("a[title='Google apps']"));
    private Button emailMenuIcon = new Button(By.xpath("//span[text()='Gmail']"));
    private Button docsMenuIcon = new Button(By.xpath("//span[text()='Docs']")); // !


    private Button cButton = new Button(By.id("K67"));
    private Button eButton = new Button(By.id("K84"));
    private Button lButton = new Button(By.id("K75"));
    private Button nButton = new Button(By.id("K89"));
    private Button iButton = new Button(By.id("K66"));
    private Button uButton = new Button(By.id("K69"));
    private Button mButton = new Button(By.id("K86"));
    private Button searchButton = new Button(By.cssSelector("input.lsb"));

    public MainPage activateKeyboard(){
        //activateKeyboardButton.click(); // Why we write this method here???
        return this;
    }

    public MainPage enterSearchCriteria() {
        cButton.click();
        eButton.click();
        lButton.click();
        eButton.click();
        nButton.click();
        iButton.click();
        uButton.click();
        mButton.click();
        return this;
    }

    public MainPage activateAppMenu(){
        activateAppMenu.click();
        return this;
    }

    public EmailPage selectEmailIcon(){
        emailMenuIcon.waitAndClick();
        return new EmailPage();
    }
    public DocumentsPage selectDocsIcon(){
        docsMenuIcon.waitAndClick();
        return new DocumentsPage();
    }

    public SearchResultsPage performSearch() {
        searchButton.waitAndClick();
        return new SearchResultsPage();
    }

    public LoginPage signInClick(){
        signin.click();
        return new LoginPage();
    }

    public EmailPage goToEmail(){
        signInClick()
                .logInToAcc()
                .activateAppMenu()
                .selectEmailIcon();
        return new EmailPage();
    }

    public DocumentsPage goToDocs(){
        signInClick()
                .logInToAcc()
                .activateAppMenu()
                .selectDocsIcon();
        return new DocumentsPage();
    }




}