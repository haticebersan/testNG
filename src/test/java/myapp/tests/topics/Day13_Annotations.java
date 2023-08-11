package myapp.tests.topics;

import org.testng.annotations.*;

public class Day13_Annotations {
    /*
    @Test: Marks a class or a method as part of the test.
    We have 5 @Before and @After annotations
    Running hierarchy: @BeforeSuite -> @BeforeTest -> @BeforeGroups -> @BeforeClass -> @BeforeMethod
    @Ignore: Ignores/skips the test case
    @Test(enabled = false) disables the test
    @BeforeSuite runs before all tests in this suite.
    @BeforeTest runs before any test method belonging to the classes
    @BeforeGroups runs before groups
    @BeforeClass runs before the first test method in the current class
    @BeforeMethod runs before EACH test method.
    @Test(priority = -1) means it will work before default priorities.
    Because default priority is 0. If you make the priority less it will work first.
     */

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method...");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class...");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before groups...");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test...");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before msuite...");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method...");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class...");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("After groups...");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test...");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite...");
    }
    @Test(priority = 3, groups = "minor-regression-1")
    public void test1(){
        System.out.println("Test1");
    }
    @Test @Ignore//ignoring
    public void test2(){
        System.out.println("Test2");
    }
    @Test(enabled = false)//disabling
    public void test3(){
        System.out.println("Test3");
    }
    @Test(priority = 1)
    public void test4(){
        System.out.println("Test4");
    }
    @Test(groups = "minor-regression-1")
    public void test5(){
        System.out.println("Test5");
    }

}
