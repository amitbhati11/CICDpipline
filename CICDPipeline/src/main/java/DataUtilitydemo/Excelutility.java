package DataUtilitydemo;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
XSSFWorkbook workbook;
XSSFSheet sheet;
	

	public Excelutility(String xlpath,String sheetname) throws IOException {
		
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(sheetname);
		}
	public int rownum() {
	int rowcount=	sheet.getPhysicalNumberOfRows();
	return rowcount;
	}
	
	public int cellnum() {
		int cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		return cellcount;
	}
	
	public String getcellstringdata(int rnum,int cnum) throws Exception {
		
		DataFormatter formater=new DataFormatter();
		
	String value=formater.formatCellValue(sheet.getRow(rnum).getCell(cnum));
	
	return value;
	}
}
