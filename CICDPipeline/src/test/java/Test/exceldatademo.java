package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataUtilitydemo.Excelutility;
import testProjectpages.loginpage;

public class exceldatademo {
	WebDriver driver;
	Excelutility eut;
	loginpage lp;
	
@BeforeTest
	public void setup() {
		String cpath="C:\\Users\\Admin_SRV\\git\\CICDpipline\\CICDPipeline\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", cpath);
		driver=new ChromeDriver();
		
	}
	
	
	@DataProvider(name="testdata")
	
	public Object[][] datap() throws Exception{
		String xlpath="C:\\Users\\Admin_SRV\\git\\CICDpipline\\CICDPipeline\\src\\test\\resources\\datautil\\loginDataprovider.xlsx";
		 String sheetname="Sheet1";
		Object data [][]=getdata(xlpath, sheetname);
		
		return data;
	}
	
	@Test(dataProvider="testdata")
	
	public void finaldata(String username,String password,String id) throws InterruptedException {
		
		driver.get("https://example.testproject.io/web/");
		lp=new loginpage(driver);
		lp.us_name(username);
		lp.us_pass(password);
		Thread.sleep(1500);
		lp.loginbuton();
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
