package generic;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb = null;
	public ExcelReader(String path) 
	{
		
		//String path= "D:\\JavaWorkspace_2016\\April_2016_batch\\April_2016\\src\\test\\resources\\Age.xlsx";
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(wb!=null)
		{
			System.out.println("XL connection successfull");
		}
	}
	
	public int getRowcount(String sheetname)
	{
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		//System.out.println(rowcount+"  - rowcount");
		return rowcount+1;//Since the rowcount is the last index of the row, add 1 to make it userfriendly
	}
	
	public int getColcount(String sheetname)
	{
		int colcount = wb.getSheet(sheetname).getRow(0).getLastCellNum();
		//System.out.println(colcount+"  - colcount");
		return colcount;
		
	}
	
	
	public String readXLcellvalue(String sheetname, int rowindex, int cellindex)
	{
		String celltext = null;
		XSSFCell cell = wb.getSheet(sheetname).getRow(rowindex).getCell(cellindex);
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		{
			celltext = cell.getStringCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			if(DateUtil.isCellDateFormatted(cell))
			{
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				celltext = date.format(cell.getDateCellValue());
			}
			else
			{
				double temp = cell.getNumericCellValue();
				celltext = String.valueOf(temp);
			}
			
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN)
		{
			boolean temp = cell.getBooleanCellValue();
			celltext = String.valueOf(temp);
		}
		//System.out.println(celltext);
		return celltext;
	}
	
	
	public void writeXLcellvalue(String sheetname, int rowindex, int colindex, String value ) 
	{
		XSSFRow row = wb.getSheet(sheetname).getRow(rowindex);
		if(row==null)
		{
			row = wb.getSheet(sheetname).createRow(rowindex);
		}
		
		XSSFCell cell = row.getCell(colindex);
		if(cell==null)
		{
			cell = row.createCell(colindex);
		}
		cell.setCellValue(value);
		
		
	}
	
	public void SaveXLfile(String path) throws IOException
	{
		FileOutputStream fout = new FileOutputStream(path);
		wb.write(fout);
		fout.close();
	}

}
