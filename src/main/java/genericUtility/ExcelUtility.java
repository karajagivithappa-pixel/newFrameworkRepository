package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	Workbook wb;
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception {
		FileInputStream fis=new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		wb=WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		//dataformatter will give you the data as it is in excel
		DataFormatter df=new DataFormatter();
		return df.formatCellValue(cell);
	}
	
	public void modifyExisitingCell(String sheetName,String value,int rowNum,int cellNum) throws Exception {
		FileInputStream fis=new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/VtigerTestData.xlsx");
		wb.write(fos);
	}
	
	public void setDataInNewCell(String sheetName,String value,int rowNum,int cellNum) throws Exception{
		FileInputStream fis=new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/VtigerTestData.xlsx");
		wb.write(fos);
	}
	
	
}
