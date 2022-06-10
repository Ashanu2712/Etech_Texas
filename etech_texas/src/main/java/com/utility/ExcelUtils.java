package com.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
 
	public static String getData(String filepath, String sheetname, int row, int col){
	
		FileInputStream fis = null;
		Workbook wb = null;
		Sheet sh = null;
		
		try {
			fis = new FileInputStream(filepath);
			wb = WorkbookFactory.create(fis);
			sh = wb.getSheet(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sh.getRow(row).getCell(col).getStringCellValue();
	}
	
	public static String[][] getExcelData(String filePath,String sheetName)
	{
		FileInputStream fis=null;
		Workbook wb=null;
		Sheet sh=null;
		try
		{
			fis=new FileInputStream(filePath);
			wb=WorkbookFactory.create(fis);
			sh=wb.getSheet(sheetName);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
			int rowno=sh.getLastRowNum()+1;
			int colno=sh.getRow(0).getLastCellNum();
			String tableData[][]=new String[rowno][colno];
			Cell cell;
			String data;
			DataFormatter dataformat=new DataFormatter();
			
			for(int i=0;i<rowno;i++)
			{
				for(int j=0;j<colno;j++)
				{
					cell=sh.getRow(i).getCell(j);
					try
					{
						data=dataformat.formatCellValue(cell);
					}
					catch(Exception e)
					{
						data="";
					}
					tableData[i][j]=data;
				}
			}
			return tableData;
	}
}
