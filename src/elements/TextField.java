package elements;

import org.openqa.selenium.By;

/**
 * Created by onedell on 28.09.2017.
 */
public class TextField extends Element {

    public TextField (By by){
        super(by);
    }

    public void type(String text){
        composeWebElement(by).sendKeys(text);
    }

    public String getText(){
        return composeWebElement(by).getText();
    }


}
