package dataProvider;


import java.io.FileInputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Excelbasic {
public static void main(String[] args) throws Throwable {
	
	FileInputStream fis=new FileInputStream("Book1.xls");
	Workbook wb=Workbook.getWorkbook(fis);
	Sheet sh=wb.getSheet("login");//sheet1 ka name rename it to login
	int rows=sh.getRows();
	int cols=sh.getColumns();
	
	for(int i=0;i<rows;i++)//For Rows
	{
		for(int j=0;j<cols;j++)	//For Columns
		{
			Cell cell=sh.getCell(j, i);  //getCell(column,row)
			String data=cell.getContents();
			System.out.print("    "+data); //print Used so thst Username & Password prints in same line
		}
		System.out.println();//pair data prints in newline
	}
}
}
