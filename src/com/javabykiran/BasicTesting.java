package com.javabykiran;

import org.testng.Assert;
import org.testng.annotations.Test;
//Testing:Comparision of actual value and expected value
//Testing a website=Black box testing
//Testing a java code=White box testing
//To run any method singlely;select just methodname dont take brackets() ex:verifyAddition
public class BasicTesting {
	//ArithmeticOperation on=new ArithmeticOperation();
//select your project-rightclick mouse-Properties--Java build path(lhs)-Libraries-Add library-TestNG
//select TestNG --aplly--finish
	
	@Test	//import
	public void verifyAddition()
	{
		//Assert.assertEquals(actual value,expected value) Comparision of Act val and exp val
		//23==78 test fail
		Assert.assertEquals(23,78);	
	}
	
	@Test	
	public void verifySubtraction()
	{
		Assert.assertEquals(4,4);
	}
	
	@Test	
	public void verifyMultiplication()
	{
		Assert.assertEquals(23,23);
	}
	
	@Test	
	public void verifyDivision()
	{
		Assert.assertEquals(78,23);
	}
















}
