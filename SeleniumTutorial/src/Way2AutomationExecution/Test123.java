package Way2AutomationExecution;

import org.testng.annotations.*;

public class Test123 {
	@BeforeSuite
	  public void beforeSuite() {
	    System.out.println("BeforeSuite");
	  }

	  

	  @BeforeClass
	  public void beforeClass() {
	    System.out.println("BeforeClass");
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
	    System.out.println("BeforeTest");
	  }

	  @BeforeMethod
	  public void beforeMethod() {
	    System.out.println("BeforeMethod");
	  }
	  
	  @Test (priority=1)
	  public void okDone(){
		  System.out.println("OK Done!...");
	  }
	  
	  @Test(priority=2)
	  public void notDone(){
		  System.out.println("NOT Done!...");
	  }
	  

	  public void ok1(){
		  System.out.println("OK 1");
	  }
	  
	  @Test(priority=4)
	  public void ok2(){
		  System.out.println("OK 2");
	  }

	  @AfterMethod  public void afterMethod() {
	    System.out.println("AfterMethod");
	  }

	  @AfterClass
	  public void afterClass() {
	    System.out.println("AfterClass");
	  }
	  
	 

	  @AfterTest
	  public void afterTest() {
	    System.out.println("AfterTest");
	  }

	  @AfterSuite
	  public void afterSuite() {
	    System.out.println("AfterSuite");
	  }
}
