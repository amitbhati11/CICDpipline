package Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataUtilitydemo.Excelutility;

public class exceldatademo {
	Excelutility eut;
	
	@DataProvider(name="testdata")
	
	public Object[][] datap() throws Exception{
		String xlpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\CICDPipeline\\src\\test\\resources\\datautil\\loginDataprovider.xlsx";
		 String sheetname="Sheet1";
		Object data [][]=getdata(xlpath, sheetname);
		
		return data;
	}
	
	@Test(dataProvider="testdata")
	
	public void finaldata(String username,String password,String id) {
		System.out.println(username+" | "+password+" | "+id);
		
	}
	
	
	public Object [][] getdata(String xlpath,String sheetname) throws Exception {
		eut=new Excelutility(xlpath, sheetname);
		int Rownum=eut.rownum();
		int Cellnum=eut.cellnum();
		
		Object data [][]=new Object[Rownum-1][Cellnum];
		
		for(int i=1;i<Rownum;i++) {
			for(int j=0;j<Cellnum;j++) {
				  
			data[i-1][j]=	eut.getcellstringdata(i, j);
			}
		}
		
		return data;
	}
}
