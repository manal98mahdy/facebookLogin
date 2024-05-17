import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestBase {

    WebDriver driver=null;
    SoftAssert soft=new SoftAssert();
    loginPage_element login=new loginPage_element();
    loginPage_action steps=new loginPage_action();
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        String chrompath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chrompath);

        System.setProperty("webdriver.chrome.driver", chrompath);

        //2-new object of web driver
         driver = new ChromeDriver();

        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test (priority = 5)
    public void validData() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(7000);
        steps.loginSteps(driver,"pipiy72884@qiradio.com","koko@12345");


        Thread.sleep(50000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/?sk=welcome");


        System.out.println("done!");
    }
    @Test (priority = 4)
    public void invalid_username() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(7000);
        steps.loginSteps(driver,"pipiy@qiradio.com","koko@12345");


        Thread.sleep(20000);
        String exepectedReselt ="The email address you entered isn't connected to an account. ";
        String acualResult = driver.findElement(By.className("_9ay7")).getText();
        soft.assertEquals(acualResult.contains(exepectedReselt),true);
        System.out.println("first assertion");

        System.out.println("done!");
    }
    @Test (priority = 3)
    public void invalid_paas() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(7000);
        steps.loginSteps(driver,"pipiy72884@qiradio.com","koko@");


        Thread.sleep(50000);
        String exepectedReselt ="The password you've entered is incorrect.";
        String acualResult = driver.findElement(By.className("_akzt")).getText();

        soft.assertEquals(acualResult.contains(exepectedReselt),true);
        System.out.println("first assertion");

        System.out.println("done!");
    }
    @Test (priority = 2)
    public void empty_username() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(3000);

        steps.loginSteps(driver,"","koko@1234");

        Thread.sleep(10000);
        String exepectedReselt ="The email address or mobile number you entered isn't connected to an account";
        String acualResult = driver.findElement(By.className("_9ay7")).getText();

        soft.assertEquals(acualResult.contains(exepectedReselt),true);
        System.out.println("first assertion");

        System.out.println("done!");
    }
    @Test (priority = 1)
    public void empty_paas() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(3000);
        steps.loginSteps(driver,"pipiy72884@qiradio.com","");

        Thread.sleep(10000);
        String exepectedReselt ="The password you've entered is incorrect.";
        String acualResult = driver.findElement(By.className("_akzt")).getText();

        soft.assertEquals(acualResult.contains(exepectedReselt),true);
        System.out.println("first assertion");

        System.out.println("done!");
    }
    @Test(priority = 0)
    public void empty_username_paas() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(3000);

        steps.loginSteps(driver,"","");

        Thread.sleep(10000);
        String exepectedReselt ="The email address or mobile number you entered isn't connected to an account";
        String acualResult = driver.findElement(By.className("_9ay7")).getText();

        soft.assertEquals(acualResult.contains(exepectedReselt),true);
        System.out.println("first assertion");

        System.out.println("done!");
    }


    @AfterMethod
    public void AfterTest()
    {
        driver.quit();
    }

}