package com.javabykiran;
//Cell(column,row)
import java.io.FileInputStream;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelFor2 {
	public static void main(String[] args) throws Throwable   {
		FileInputStream fis=new FileInputStream("abc.xls");
		Workbook workbook= Workbook.getWorkbook(fis);
		Sheet sheet=workbook.getSheet(0);
		
		int rows=sheet.getRows();
		//System.out.println(rows);  //7
		int cols=sheet.getColumns();  
		//System.out.println(cols);  //3
		
		for(int i=0;i<cols;i++){
			//System.out.println("Inside for loop");
			for(int j=0;j<rows;j++){
				//System.out.println(" Inside Inside For Loop");
				
				Cell cell=sheet.getCell(i, j);
				String data=cell.getContents();
				System.out.println(data);
				
			}
		}
	}
}
