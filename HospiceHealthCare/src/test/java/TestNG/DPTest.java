package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.IpathConstant;

public class DPTest {
@DataProvider(name="readDataFromExcel")
public  Object[][] orgData() throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
	Workbook workbook=WorkbookFactory.create(fis);
	Sheet sh = workbook.getSheet("dataprovider");
	int rowCount = sh.getLastRowNum();
	int cellCount = sh.getRow(0).getLastCellNum();
	Object[][] obj=new Object[rowCount][cellCount];
	for(int i=0;i<rowCount;i++)
	{
		for(int j=0;j<cellCount;j++)
		{
			 obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		
		}
	}
	return obj;
}
}
