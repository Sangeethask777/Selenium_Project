package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	public static String getStringdata(int a, int b) throws IOException {
		f = new FileInputStream(
				System.getProperty("user.dir")+ "\\src\\test\\resources\\excel.xlsx");
		w = new XSSFWorkbook(f);
		sh = w.getSheet("Sheet1");
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		return c.getStringCellValue();

	}

	public static String getIntegerdata(int a, int b) throws IOException {
		f = new FileInputStream(
				"C:\\\\Users\\\\sange\\\\eclipse-workspace\\\\My_Maven\\\\src\\\\main\\\\resources\\\\testdata.xlsx");

		w = new XSSFWorkbook(f);
		sh = w.getSheet("Sheet1");
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		int x = (int) c.getNumericCellValue();
		return String.valueOf(x);

	}

}
