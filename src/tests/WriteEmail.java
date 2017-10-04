package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class WriteEmail extends Main{

    @Test
    public void writeEmailToYourself(){
        String expectedSubject = getUniqueString();
        MainPage mainPage = new MainPage();
        String newEmailSubj = mainPage.goToEmail()
            .writeAndSendEmail(expectedSubject,"Hi there, this is my email to me :) ")
            .waitAndReturnSubject(expectedSubject);
        Assert.assertEquals(newEmailSubj, expectedSubject);
    }

    @Test
    public void tryToSendEmailWithoutSubject(){
        String expectedSubject = "(no subject)";
        MainPage mainPage = new MainPage();
        String newEmailSubj = mainPage.goToEmail()
                .writeAndSendEmail("","Hi there, this is my email to me :) ")
                .waitAndReturnSubject(expectedSubject);
        Assert.assertEquals(newEmailSubj, expectedSubject);
    }

    @Test
    public void writeEmailEndCheckEmailBody(){
        String expectedEmailBody = getUniqueString();
        MainPage mainPage = new MainPage();
        String newEmailBody = mainPage.goToEmail()
                .writeAndSendEmail("Email Body Test", expectedEmailBody)
                .waitAndReturnEmailBody();
        Assert.assertEquals(newEmailBody," - "+expectedEmailBody);
    }
}
