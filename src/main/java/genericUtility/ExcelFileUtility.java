package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility 
{
	/**
	 * This method will read data from excel and return value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/contact.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	    return value;
	}
}
