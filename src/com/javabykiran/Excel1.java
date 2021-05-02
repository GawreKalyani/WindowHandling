package com.javabykiran;

//Single data of cell of excel is obtained
//Column & row & Sheet:Index Start with 0
//Input Stream:Reading  ; Output Stream:Writing
//WebElement:Represent elements of browser
//WebDriver:Represent Browser
//Method   getSheet(int arg(0):Sheet-Workbook(Returntype:Sheet,Class:Workboook)
import java.io.FileInputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Excel1 {
public static void main(String[] args) throws Throwable   {
	FileInputStream fis=new FileInputStream("abc.xls");
	Workbook workbook= Workbook.getWorkbook(fis);
	Sheet sheet=workbook.getSheet(0);
	Cell cell=sheet.getCell(0, 0);//(column,row)
	String data=cell.getContents();
	System.out.println(data);
	
	Cell cell1=sheet.getCell(0, 1);
	String data1=cell1.getContents();
	System.out.println(data1);
	
	Cell cell11=sheet.getCell(0, 4);
	String data11=cell11.getContents();
	System.out.println(data11);
	
	Cell cell21=sheet.getCell(1, 0);
	String data21=cell21.getContents();
	System.out.println(data21);
	
	Cell cell2=sheet.getCell(1, 1);
	String data2=cell2.getContents();
	System.out.println(data2);
	
	Cell cell22=sheet.getCell(1, 4);
	String data22=cell22.getContents();
	System.out.println(data22);
	
	Cell cell3=sheet.getCell(2, 0);
	String data3=cell3.getContents();
	System.out.println(data3);
	
	Cell cell31=sheet.getCell(2, 1);
	String data31=cell31.getContents();
	System.out.println(data31);
	
	Cell cell32=sheet.getCell(2, 4);
	String data32=cell32.getContents();
	System.out.println(data32);
	
	
	//Download API for ExcelSheet:jxl-2.4.2 jar
	//By Downloading this jar, data of excel sheet is obtained using eclipse
	//Copy jxl-2.4.2 jar File and paste it in your project
	//4 Method:getWorkbook(),getSheet(),getCell(),getContents()
}
}
