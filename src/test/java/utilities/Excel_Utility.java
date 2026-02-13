package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility {
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook xwork;
	public XSSFSheet xsheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	
	String path;
	
	public Excel_Utility(String path) {
		this.path =path;
	}
	
	public int rowCount(String sheet) throws Exception {
		fis = new FileInputStream(path);
		xwork = new XSSFWorkbook(fis);
		xsheet = xwork.getSheet(sheet);
		int rowNum = xsheet.getLastRowNum();
		xwork.close();
		fis.close();
		return rowNum;
	}
	
	public int cellCount(String sheet, int r) throws Exception {
		fis = new FileInputStream(path);
		xwork = new XSSFWorkbook(fis);
		xsheet = xwork.getSheet(sheet);
		row = xsheet.getRow(r);
		int cellNum = row.getLastCellNum();
		xwork.close();
		fis.close();
		return cellNum;
	}
	
	public String getCelldata(String sheet, int r, int c) throws Exception {
		fis = new FileInputStream(path);
		xwork = new XSSFWorkbook(fis);
		xsheet = xwork.getSheet(sheet);
		row = xsheet.getRow(r);
		cell = row.getCell(c);
		
		String data;
		DataFormatter df = new DataFormatter();
		try {
			data=df.formatCellValue(cell);
		} catch (Exception e) {
			data="";
		}
		
		xwork.close();
		fis.close();
		return data;
	}

	
	public void setCellData(String sheet, int r, int c, String data) throws Exception {
		
		File f = new File(path);
		if(!f.exists()) {
			xwork = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			xwork.write(fos);
		}
		
		fis = new FileInputStream(path);
		xwork = new XSSFWorkbook(fis);
		
		if(xwork.getSheetIndex(sheet)==-1)
			xwork.createSheet(sheet);
		xsheet= xwork.getSheet(sheet);
		
		if(xsheet.getRow(r)==null)
			xsheet.createRow(r);
		row = xsheet.getRow(r);
	cell = row.createCell(c);
	fos = new FileOutputStream(path);
	xwork.write(fos);
	fis.close();
	fos.close();
	
	}
	
	public void setGreenColor(String sheet, int r, int c) throws Exception {
		fis = new FileInputStream(path);
		xwork = new XSSFWorkbook(fis);
		xsheet = xwork.getSheet(sheet);
		row = xsheet.getRow(r);
		cell = row.getCell(c);

		style = xwork.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);


		cell.setCellStyle(style);
		xwork.write(fos);
		xwork.close();
		fis.close();

	}
	
	public void setRedColor(String sheet, int r, int c) throws Exception {
		fis = new FileInputStream(path);
		xwork = new XSSFWorkbook(fis);
		xsheet = xwork.getSheet(sheet);
		row = xsheet.getRow(r);
		cell = row.getCell(c);
		
		style = xwork.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		
		cell.setCellStyle(style);
		xwork.write(fos);
		xwork.close();
		fis.close();
		
	}
}
