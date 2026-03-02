package Tests;

import org.testng.annotations.*;

public class TestNG {
    @Test
    public void test1() {
        System.out.println("This is Test 1");
    }
    @Test
    public void test2() {
        System.out.println("This is Test 2");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This runs before each test method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("This runs after each test method");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("This runs once before all test methods in the class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("This runs once after all test methods in the class");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("This runs before any test method in the <test> tag");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("This runs after all test methods in the <test> tag");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This runs before the entire test suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("This runs after the entire test suite");
    }

}
