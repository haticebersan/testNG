package myapp.tests.listeners;
import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

//@Listeners(myapp.utilities.ListenersUtil.class)
@Listeners(myapp.utilities.ListenersUtil.class)
public class Day17_Listeners1 {
    /*
  There are 2 ways to connect Listeners and Test Classes:

a. Use this in the test class :
    @Listeners(techproed.utilities.Listeners.class)
b. Add listeners tag before test in the xml file to connect Listeners and this xml file(Recommended)

    <listeners>
        <listener class-name="techproed.utilities.Listeners"></listener>
    </listeners>
     */
    @Test
    public void test1() {

        System.out.println("PASS");
        assertTrue(true);

    }

    @Test
    public void test2() {

        System.out.println("FAIL");
        assertTrue(false);
        //whitespace(empty) screenshot
    }


    @Test
    public void test3() {

        System.out.println("SKIPPED");
        throw new SkipException("Skipped on purpose");

    }


    @Test
    public void test4(){

        System.out.println("FAIL -- THROW EXCEPTION");
        Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().findElement(By.id("wrong-id"));//noSuchElementException
        //techproeducation homepage screenshot

    }



}
