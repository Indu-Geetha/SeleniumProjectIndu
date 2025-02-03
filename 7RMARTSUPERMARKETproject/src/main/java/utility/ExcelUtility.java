package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {

	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	
	public static String getStringData(int a,int b,String sheet) throws IOException
	{
		String FILE_PATH=Constant.FILE_PATH;
		f=new FileInputStream(FILE_PATH);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r =sh.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static String getIntegerData(int a,int b,String sheet) throws IOException 
	{
		String FILE_PATH=Constant.FILE_PATH;
		f=new FileInputStream(FILE_PATH);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r =sh.getRow(a);
		XSSFCell c = r.getCell(b);
		int v=(int) c.getNumericCellValue();
		return String.valueOf(v);
	}
	
	public static String getFloatData(int a,int b,String sheet) throws IOException 
	{
		String FILE_PATH=Constant.FILE_PATH;
		f=new FileInputStream(FILE_PATH);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r =sh.getRow(a);
		XSSFCell c = r.getCell(b);
		float x=(float) c.getNumericCellValue();
		return String.valueOf(x);
	}

	
}