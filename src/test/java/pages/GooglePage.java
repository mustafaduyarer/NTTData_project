package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GooglePage extends BasePage {



    @FindBy(xpath = "//input[@class='gLFyf']")
    public WebElement googleInput;

    @FindBy(css = "#L2AGLb")
    public WebElement acceptTodas;





}
