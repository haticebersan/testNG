package myapp.utilities;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] customerCredentials() {

        Object[][] data = {
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };

        return data;
    }

    //With this method we will get the data from Excel sheet and use it as data provider
    @DataProvider
    public Object[][] excelCustomerCredentials(){
        String path = "resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";

        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
        return excelUtils.getDataArrayWithoutFirstRow();

    }
}
