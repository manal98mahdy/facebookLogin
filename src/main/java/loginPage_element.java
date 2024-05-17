import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage_element {
    public WebElement passwordPom(WebDriver driver)
    {
        By password = By.id("pass");
        WebElement passwordEle =driver.findElement(password);
        return passwordEle;
    }
    public WebElement usernamePom(WebDriver driver)
    {
        return  driver.findElement(By.id("email"));
    }
    public WebElement loginPom(WebDriver driver)
    {
        return  driver.findElement(By.name("login"));
    }
}
