package myapp.tests.dataprovider;
import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.*;
import org.testng.annotations.Test;
public class Day16_DataProvider3 {
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;

    @Test(dataProvider = "excelCustomerCredentials", dataProviderClass = DataProviderUtils.class)
    public void customerLogin(String username, String password){

        rentalHomePage = new RentalHomePage();
        rentalLoginPage = new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcar_url"));
        rentalHomePage.loginLink.click();
        rentalLoginPage.username.sendKeys(username);
        rentalLoginPage.password.sendKeys(password);
        rentalLoginPage.loginButton.click();
        WaitUtils.waitFor(2);
        BrowserUtils.verifyElementDisplayed(rentalHomePage.userID);

        //Log out
        rentalHomePage.userID.click();
        rentalHomePage.logOut.click();
        rentalHomePage.OK.click();

        //Verify if page logout
        BrowserUtils.verifyElementDisplayed(rentalHomePage.loginLink);
        WaitUtils.waitFor(2);
        Driver.closeDriver();
} }
