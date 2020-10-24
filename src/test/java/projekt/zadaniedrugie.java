package projekt;

import gherkin.lexer.Fi;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class zadaniedrugie {

    private WebDriver driver;

    @Before
    public void setUp() {

        // Powiedz testowi, gdzie jest driver do przegladarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl/");

    }


    @Test
    public void myStoreTest() throws InterruptedException {

        // Znajdź element odsylajacy do okna logowania
        WebElement element = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a/span"));
        element.click();

//        znajdź element z miejscem na login i wpisz go
        WebElement elementLogin = driver.findElement(By.xpath("//*[@id='login-form']/section/div[1]/div[1]/input"));
        elementLogin.click();
        elementLogin.sendKeys("ania.kowalska01012020@o2.pl");

//      znajdź element z miejscem na hasło i wpisz je
        WebElement elementPassword = driver.findElement(By.xpath("//*[@id='login-form']/section/div[2]/div[1]/div/input"));
        elementPassword.click();
        elementPassword.sendKeys("qwertyqwerty");

//      znajdź i wciśnij przysisk Sign in
        WebElement elementSignIn = driver.findElement(By.xpath("//*[@id='submit-login']"));
        elementSignIn.click();


//      znajdź i wsiśnij przycisk Clothes
        WebElement elementClothes = driver.findElement(By.xpath("//*[@id='category-3']/a"));
        elementClothes.click();

//      znajdź i wsiśnij element do kupienia
        WebElement elementHummingbirdPrintedSweater = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/div[1]/h2/a"));
        elementHummingbirdPrintedSweater.click();

//      wybierz rozmiar
        Select clothesSize = new Select(driver.findElement(By.name("group[1]")));
        for (WebElement e : clothesSize.getOptions()) {
            if (e.getText().equals("L")) {
                e.click();
                break;
            }
        }

//        wybierz liczbę sztuk
        WebElement elementQuantity = driver.findElement(By.name("qty"));
        int elementsAmount = Integer.parseInt(elementQuantity.getAttribute("value"));
        WebElement boostButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span[3]/button[1]"));
        while (elementsAmount < 5) {
            Thread.sleep(1000);
            boostButton.click();
            elementsAmount++;
        }

        //    dodaj element do koszyka
    WebElement addToCartElement = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"));
    addToCartElement.click();

    Thread.sleep(2000);

// przejście do opcji checkout
        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a"));
        proceedToCheckout.click();

//     potwierdzenie adresu
        WebElement elementCheckOut = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a"));
        elementCheckOut.click();
        WebElement elementChechContinue = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[2]/div/div/form/div[2]/button"));
        elementChechContinue.click();

//      wybranie sposobu dostawy
        WebElement shippingRadioButton = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/div/div[1]/div[1]/div/span/input"));
        if (!shippingRadioButton.isSelected()){
            shippingRadioButton.click();
        }

//        przejście dalej
        WebElement confirmShippingMethod = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/button"));
        confirmShippingMethod.click();


//      wybieranie metody płatności
        WebElement paymentMethod = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/div[2]/div[1]/div/span/input"));
        paymentMethod.click();

//      potwierdzenie regulaminu
        WebElement agreement = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/form/ul/li/div[1]/span/input"));
        agreement.click();

//      potwierdzenie zamówienia
        WebElement submitOrderButton = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button"));
        submitOrderButton.click();

//      screenshot
        try {
            takeScreenShot(driver, "C:\\Users\\dell\\Desktop\\screenshot.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void takeScreenShot(WebDriver driver, String destination) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(destination);
        FileUtils.copyFile(sourceFile, destinationFile);



    }
}
