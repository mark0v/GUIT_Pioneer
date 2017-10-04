package pages;

import elements.Button;
import elements.TextField;
import org.junit.internal.ExactComparisonCriteria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.Main;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by onedell on 28.09.2017.
 */
public class EmailPage extends MainPage {
    private Button compose = new Button(By.xpath("//div[text()='COMPOSE']"));
    private TextField recipients = new TextField(By.xpath(".//textarea[@name='to']"));
    private TextField subject = new TextField(By.xpath(".//input[@placeholder='Subject']"));
    private TextField emailBody = new TextField(By.xpath(".//div[@aria-label='Message Body']"));
    private Button submit = new Button(By.xpath("//div[text()='Send']"));



    public EmailPage writeAndSendEmail(String sub, String body){
        compose.click();
        recipients.type("devamark0vv@gmail.com");
        subject.waitAndType(sub);
        emailBody.waitAndType(body);
        submit.waitAndClick();
        return this;
    }

    public String waitAndReturnSubject(String subject){
        Main.waitInSeconds(20);
        try{
            return new TextField(By.xpath("//tr[1]//span/b[text()='"+subject+"']/..")).getText();
            }catch (NoSuchElementException e){}
        return "Error occurred when get Text in element";
    }

    // Refactoring needed. What happen if email body will more than displayed on the grid preview???
    public String waitAndReturnEmailBody(){
        Main.waitInSeconds(20);
        return new TextField(By.xpath(".//tbody/tr[1]//span[@class='y2']")).getText();
    }
}
