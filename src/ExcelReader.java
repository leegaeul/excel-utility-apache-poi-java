import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * <h4>ExcelReader.java</h4>
 * 
 * @author <a href="mailto:gaeul.lee@kt.com"><b>이가을</b></a>
 * @since 2017. 12. 26.
 */
public class ExcelReader {

	private static ExcelReader instance = new ExcelReader();

	/**
	 * 
	 * @return ExcelReader
	 */
	public static ExcelReader getInstance() {
		return instance;
	}

	/**
	 * 
	 * 
	 * @return void
	 * @throws IOException
	 */
	public void readXls(File input) throws IOException {
		// 파일을 읽기위해 엑셀파일을 가져온다
		FileInputStream fis = new FileInputStream(input);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		HSSFSheet sheet = workbook.getSheetAt(0);
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = 1; rowindex < rows; rowindex++) {
			// 행을 읽는다
			HSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells();
				System.out.println(rowindex + "행");
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					// 셀값을 읽는다
					HSSFCell cell = row.getCell(columnindex);
					String value = "";
					// 셀이 빈값일경우를 위한 널체크
					if (cell == null) {
						continue;
					} else {
						// 타입별로 내용 읽기
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
					}
					System.out.println("\t" + columnindex + "열: " + value);
				}
			}
		}

	}

	/**
	 * 
	 * @return void
	 * @throws IOException
	 */
	public void readXlsx(File input) throws IOException {

		// 파일을 읽기위해 엑셀파일을 가져온다
		FileInputStream fis = new FileInputStream(input);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		XSSFSheet sheet = workbook.getSheetAt(0);

		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = 1; rowindex < rows; rowindex++) {
			// 행을읽는다
			XSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells();
				System.out.println(rowindex + "행");
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					// 셀값을 읽는다
					XSSFCell cell = row.getCell(columnindex);
					String value = "";
					// 셀이 빈값일경우를 위한 널체크
					if (cell == null) {
						continue;
					} else {
						// 타입별로 내용 읽기
						switch (cell.getCellType()) {
						case XSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
					}
					System.out.println("\t" + columnindex + "열: " + value);
				}
			}
		}
	}
}
