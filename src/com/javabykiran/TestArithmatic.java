package com.javabykiran;
 //Give priority to test cases:whose result displayed first
//TestArithmatic class and ArithmeticOperation class are connected
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestArithmatic {
	
	
	@Test(priority=4)
	public void varifyAddition()
	{
		ArithmeticOperation obj=new ArithmeticOperation();
		Assert.assertEquals(obj.add(3, 6),4);
	}	
	@Test(priority=3)
	public void varifySubtraction()
	{
		ArithmeticOperation obj1=new ArithmeticOperation();
		int a=obj1.sub(6, 5);
		Assert.assertEquals(a,4);
	}	
	@Test(priority=2)
	public void varifyMultiplication()
	{
		ArithmeticOperation obj1=new ArithmeticOperation();
		int a=obj1.mul(6, 5);
		Assert.assertEquals(a,30);
	}	
	@Test(priority=1)
	public void varifyDivision()
	{
		ArithmeticOperation obj1=new ArithmeticOperation();
		Assert.assertEquals(obj1.div(6, 2),3);
	}	
	
	
	
	
	
	
}
