package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class CombinationTest {
	@Test(priority=0,enabled=false)
	public void demo1() {
		Reporter.log("demo1",true);
	}

	@Test(invocationCount=3,priority=1)
	public void demo2() {
		Reporter.log("demo2",true);
	}
	@Test(priority=2,invocationCount=3)
	public void demo3() {
		Reporter.log("demo3",true);
	}
	@Test(enabled =true,priority=3)
	public void demo4() {
		Reporter.log("demo4",true);
	}
	@Test(priority=3,invocationCount=3)
	public void demo5() {
		Reporter.log("demo5",true);
	}

}
