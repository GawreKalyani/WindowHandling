package tableTestCases;

import org.testng.annotations.Test;

public class DataConversion {
	@Test
	public void test01()
	{
		float f=0.1f;
		//Converting float into integer        int i=(int)f;
		
		//1)Using wrapper class
		
		Float value=30.0f;
		Integer intVal=value.intValue();     //int java.lang.Float.intVal
										//Returns the value of this Float as an int after a narrowing primitive conversion.
		System.out.println(intVal);     //30
	
		//2)Using Type Casting
		 int i=(int)f;
		 System.out.println(i);     //0
	}
	@Test
	public void test02()
	{
		String text="1";
		//Converting NumberString into integer       
		
		//1)Using wrapper class Integer
		int a=Integer.parseInt(text);
		System.out.println(a);       //1
	
	}
	@Test
	public void test03(){  //converting double into String
		double j=1111111111d;
		String text=String.valueOf(j);
		System.out.println(text);    //1.111111111E9
	}
	
}
