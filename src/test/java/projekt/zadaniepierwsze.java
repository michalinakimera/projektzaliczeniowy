package projekt;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.support.ui.Select;

public class zadaniepierwsze {

    private WebDriver driver;

    @Given("user is on the my store main page")
    public void userOpensMainPage() {

        // Powiedz testowi, gdzie jest driver do przegladarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl");
    }

    @And("user click on the SignIn button")
    public void userclicksOnSignInButton() {
        // Znajdź element odsylajacy do okna logowania
        WebElement element = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a/span"));
        element.click();
    }

    @When("user completes email field with (.*)")
    public void userCompletesEmailField(String email) {
        WebElement elementLogin = driver.findElement(By.xpath("//*[@id='login-form']/section/div[1]/div[1]/input"));
        elementLogin.click();
        elementLogin.sendKeys(email);

    }

    @And("user completes password with (.*)")
    public void userCompletesPassword(String password){
            WebElement elementPassword = driver.findElement(By.xpath("//*[@id='login-form']/section/div[2]/div[1]/div/input"));
            elementPassword.click();
            elementPassword.sendKeys(password);

        }
    @And("user submits credentials")
    public void userSubmitsCredentials() {
        WebElement elementSubmit = driver.findElement(By.xpath("//*[@id='submit-login']"));
        elementSubmit.click();
    }

    @Then("user click on the Addresses button")
    public void userClickOnTheAddressesButton() {
        WebElement elementAddresses = driver.findElement(By.xpath("//*[@id='footer_account_list']/li[4]/a"));
        elementAddresses.click();
    }

    @And("user click on the Create new address button")
    public void userClickOnTheCreateNewAddressButton() {
        WebElement elementCreateNewAddress = driver.findElement(By.xpath("//*[@id='content']/div[2]/a/span"));
        elementCreateNewAddress.click();
    }


    @When("user completes alias field with (.*)")
    public void userFillsAlias(String alias){
        WebElement aliasField = driver.findElement(By.name("alias"));
        aliasField.clear();
        aliasField.sendKeys(alias);
    }

    @And("user completes address field with (.*)")
    public void userCompletesAddress(String address){
        WebElement addressField = driver.findElement(By.name("address1"));
        addressField.clear();
        addressField.sendKeys(address);
    }
    @And("user completes city field with (.*)")
    public void userComletesCityfield(String city){
        WebElement cityField = driver.findElement(By.name("city"));
        cityField.clear();
        cityField.sendKeys(city);

    }
    @Then("user completes zip field with (.*)")
    public void userCompletesZipField(String zip){
        WebElement zipField = driver.findElement(By.name("postcode"));
        zipField.clear();
        zipField.sendKeys(zip);

    }
    @And("user completes phone field with (\\d{9,11}?)")
    public void userCompletesPhoneField(String phone){
        WebElement phoneField = driver.findElement(By.name("phone"));
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    @And("user chooses country from combobox")
    public void userChooseCountry(){
        Select countrySelect = new Select(driver.findElement(By.name("id_country")));
        WebElement webElement = countrySelect.getOptions().get(1);
        webElement.click();

    }

    @Then("user click on the save button")
    public void userClicksSaveButton(){
        WebElement saveButton = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));
        saveButton.click();
    }

    @When("user check the save is correct")
    public void userCheckDataInFormIsCorrect(){
        String saveInformation = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li")).getText();
        Assert.assertEquals("Address successfully added!", saveInformation);
    }

    @Then("user delete address")
    public void userDeleteAddress(){
        WebElement deleteButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]/span"));
        deleteButton.click();
    }

    @And("user check the delete is correct")
    public void userCheckIsDeleted(){
        String deletedMessage = driver.findElement(By.cssSelector("#notifications > div > article > ul > li")).getText();
        Assert.assertEquals("Address successfully deleted!",deletedMessage);

    }



}
