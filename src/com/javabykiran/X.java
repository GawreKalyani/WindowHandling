package com.javabykiran;
//Assert line14 fail,so 4 is not printed;next assert statement result not obtained
//so Do not write many assert stmt in one method
import org.testng.Assert;
import org.testng.annotations.Test;

public class X {
@Test
public void m1(){
	System.out.println(1);
	Assert.assertEquals(34, 34);
	System.out.println(2);
	Assert.assertEquals(2, 2);
	System.out.println(3);
	Assert.assertEquals(34, 78);//Failed Condition
	System.out.println(4);
	Assert.assertEquals(34, 34);
	
}
}
