package CalculateTripCost;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestCase {
	       public static HSSFWorkbook workbook;
	    public void createExcelFile()    //createing Excel sheet if not present
	    {
	          try
	          {
	        	  FileInputStream in=new FileInputStream("D://TestCase.xls");
	          }
	          catch(Exception e)
	          {
	        		XSSFWorkbook wb=new XSSFWorkbook();
	        		try
	        		{
	    	    	FileOutputStream out=new FileOutputStream("D://TestCase.xls");
	    	    	 XSSFSheet sheet=wb.createSheet("TestCase");
	    	    			out.close();
	    	   	}
	        		catch(Exception ex)
	        		{
	        			System.out.println(ex);
	        		}
	    	  }
	    }
	    public HSSFWorkbook openExcelFile()
	    {
	    	try
	    	{
	    			
	    		FileInputStream in=new FileInputStream("D://TestCase.xls");
	    		System.out.println(in);
	    		workbook=new HSSFWorkbook(in);
	    				
	 	    }
	    	catch(Exception e)
	    	{
	    	 System.out.println(e);
	    		
	    	}
	    	return workbook;
	    }
}
