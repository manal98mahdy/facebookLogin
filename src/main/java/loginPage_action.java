import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage_action {
    loginPage_element login=new loginPage_element();

    public void loginSteps(WebDriver driver,String username,String pass)
    {
        WebElement email = login.usernamePom(driver);
        email.clear();
        email.sendKeys(username);

        WebElement password = login.passwordPom(driver);
        password.clear();
        password.sendKeys(pass);
        WebElement loginbutton = login.loginPom(driver);
        loginbutton.click();
    }
}
