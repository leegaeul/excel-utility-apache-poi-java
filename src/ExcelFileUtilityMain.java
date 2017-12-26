import java.io.File;
import java.io.IOException;

/*
 * Copyright ⓒ [2017] KTH corp.All rights reserved.
 *
 * This is a proprietary software of KTH corp, and you may not use this file except in
 * compliance with license with license agreement with KTH corp. Any redistribution or use of this
 * software, with or without modification shall be strictly prohibited without prior written
 * approval of KTH corp, and the copyright notice above does not evidence any actual or
 * intended publication of such software.
 */

/**
 * <h4>ExcelReaderMain.java</h4>
 * 
 * @author <a href="mailto:gaeul.lee@kt.com"><b>이가을</b></a>
 * @since 2017. 12. 26.
 */
public class ExcelFileUtilityMain {

	/**
	 * 
	 * @return void
	 */
	public static void main(String[] args) {
		ExcelReader reader = ExcelReader.getInstance();
		try {
			reader.readXls(new File("resources/jxlrwtest.xls"));
			reader.readXlsx(new File("resources/receivers.xlsx"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
