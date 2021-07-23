package softHardAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertEx {
	SoftAssert sa;

	@Test(priority=1)
	public void hardAssert(){
		Assert.assertEquals(0,1);
		System.out.println("Testcase 1 ends"); //stmt will not be printed "Due to Hard Assert"
	}
	@Test(priority=2)
	public void aSoftAssert(){
		sa=new SoftAssert();
		sa.assertEquals(0,1);
		System.out.println("softassert"); // TC wil pass and stmt will  be printed 
	}
	@Test(priority=3)
	public void softAssert(){
		sa=new SoftAssert();
		sa.assertEquals(0,1);
		System.out.println("Testcase using asserAll"); //  stmt will  be printed 
		sa.assertAll(); //should be written at end , at this step TC will fail
	}
	@Test(priority=4)
	public void softAssertEx(){
		sa=new SoftAssert();
		sa.assertEquals(0,1);
		System.out.println("Testcase using asserAll"); // TC will fail and stmt will  be printed 
		sa.assertAll(); //tc fail and next step not executed so should be written at end
		System.out.println("sdddd");
	}
}
