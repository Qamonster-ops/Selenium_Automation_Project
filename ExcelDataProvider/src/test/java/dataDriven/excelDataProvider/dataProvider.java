package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	DataFormatter formatter = new DataFormatter();
	@Test(dataProvider="driveTest")
	public void testCaseData(String greeting,String communication,int id)
	{
		System.out.println(greeting+communication+id);
	}
	
		@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException
	{
		
		//Object[][] data = {{"Hello","text",1},{"Bye","message",12},{"solo","cell",123}};
		//Every row of excelshould be sent to one array
			FileInputStream fis = new FileInputStream("Users//thotsec//Downloads//demodata.xlsx");	//path where the excel is saved
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount =sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			int colcount = row.getLastCellNum();
			Object data[][]=new Object[rowCount-1][colcount];
			for(int i =0;i<rowCount-1;i++)
			{
				row=sheet.getRow(i+1);
				for(int j=0;j<colcount;j++)
				{
					XSSFCell cell = row.getCell(j);
					data[i][j]= formatter.formatCellValue(cell);
				}
			}
			return data;
			
	}

}
