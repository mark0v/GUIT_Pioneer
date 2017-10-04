package pages;

import elements.Button;
import elements.TextField;
import org.openqa.selenium.By;
import tests.Main;

public class LoginPage extends MainPage {

    private static TextField email = new TextField(By.cssSelector("input[type='email']"));
    private Button next = new Button(By.xpath("//span[text()='Далі']"));
    private TextField password = new TextField(By.cssSelector("input[type='password']"));


    public LoginPage typeEmail(){
        email.type("devamark0vv@gmail.com");
        return this;
    }

    public LoginPage next(){
        next.waitAndClick();
        return this;
    }

    public LoginPage typePass(){
        password.waitAndType("H8NI9HHuLSTp");
        return this;
    }

    public MainPage logInToAcc(){
        typeEmail()
                .next()
                .typePass()
                .next();
        return new MainPage();
    }

    public static boolean loginPageisShown() {
        return email.isPresent();
    }

}
