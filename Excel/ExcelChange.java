package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelChange {
	//OldFile 原来文件名， newFile 修改后的文件名， rowNum 第几行 ，colNum 第几列 ，data 要插入的值
	//(rowNum,colNum)对应excel表(rowNum+1,colNum+1)，比如rowNum=1,colNum=2,(2,3)单元格
	public void excelChange(String OldFile,String newFile,int rowNum,int colNum, String data) throws IOException{
		boolean isExcel2003 = true;  
        if (isExcel2007(OldFile)) {  
            isExcel2003 = false;  
        }  
        try {
        	//Get the excel file.
			FileInputStream file = new FileInputStream(new File(OldFile));
			Workbook yourworkbook =null;
			yourworkbook = isExcel2003 ? new HSSFWorkbook(file) : new XSSFWorkbook(file); 
			//Get first sheet from the workbook.
            //If there have >1 sheet in your workbook, you can change it here IF you want to edit other sheets.
            Sheet sheet1 = yourworkbook.getSheetAt(0);

            // Get the row of your desired cell.
            // Let's say that your desired cell is at row 2.
            Row row = sheet1.getRow(rowNum);
            // Get the column of your desired cell in your selected row.
            // Let's say that your desired cell is at column 2.
            Cell column = row.getCell(colNum);//Cell 是单元格的意思，第二行第二列
            // If the cell is String type.If double or else you can change it.
            String updatename = column.getStringCellValue();
            System.out.println("原来数据:"+updatename);
            //New content for desired cell.
            updatename=data;
            //Print out the updated content.
            System.out.println(updatename);
            //Set the new content to your desired cell(column).
            column.setCellValue(updatename); 
            //Close the excel file.
            file.close();
            //Where you want to save the updated sheet.
            FileOutputStream out = 
                new FileOutputStream(new File(newFile));
            yourworkbook.write(out);
            out.close();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 private boolean isExcel2007(String fileName) {  
	        return fileName.matches("^.+\\.(?i)(xlsx)$");  
	    }  
    public static void main(String[] args) throws IOException  {
    		ExcelChange ec =new ExcelChange();
    		ec.excelChange("qun.xlsx", "qun1.xlsx",1,2,"an");
       
    }
}