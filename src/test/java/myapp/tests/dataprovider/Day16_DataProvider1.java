package myapp.tests.dataprovider;
import myapp.utilities.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Day16_DataProvider1 {
    //1. Data source
    @DataProvider
    public Object[][] customerData() {

        Object[][] data = {
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };

        return data;
    }
    @Test(dataProvider = "customerData")
    public void test1(String username, String password) {

        System.out.println("Username: " + username + " -- Password: " + password);

    }
    //2. Data source with custom name
    @DataProvider(name = "electricCars")
    public Object[][] carInventory() {

        Object[][] carList = {
                {"tesla"},
                {"lucid"},
                {"nio"},
                {"bmw"},
                {"rivian"},
                {"mercedes"}
        };
        return carList;
    }

    @Test(dataProvider = "electricCars")
    public void test2(String car) {

        System.out.println(car);

    }
    //3. Data source with DataProviderUtils class
    //If you get the data from other class beside data provider method name, also give class name.
    @Test(dataProvider = "customerCredentials", dataProviderClass = DataProviderUtils.class)
    public void test3(String username, String password) {

        System.out.println(username + " | " + password);
} }
