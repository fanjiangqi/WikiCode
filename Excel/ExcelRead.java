package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
		  
	    public List<String[]> readExcel(String filePath) {  
	        List<String[]> dataList = new ArrayList<String[]>();  
	        boolean isExcel2003 = true;  
	        if (isExcel2007(filePath)) {  
	            isExcel2003 = false;  
	        }  
	        File file = new File(filePath);  
	        InputStream is = null;  
	        try {  
	            is = new FileInputStream(file);  
	        } catch (FileNotFoundException ex) {  
	            Logger.getLogger(ExcelRead.class.getName()).log(Level.SEVERE, null, ex);  
	        }  
	        Workbook wb = null;  
	        try {  
	            wb = isExcel2003 ? new HSSFWorkbook(is) : new XSSFWorkbook(is);  
	        } catch (IOException ex) {  
	            Logger.getLogger(ExcelRead.class.getName()).log(Level.SEVERE, null, ex);  
	        }  
	        Sheet sheet = wb.getSheetAt(0);  
	        int totalRows = sheet.getPhysicalNumberOfRows();  
	        int totalCells = 0;  
	        if (totalRows >= 1 && sheet.getRow(0) != null) {  
	            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();  
	        }  
	        for (int r = 0; r < totalRows; r++) {  
	            Row row = sheet.getRow(r);  
	            if (row == null) {  
	                continue;  
	            }  
	            String[] rowList = new String[totalCells];  
	            for (int c = 0; c < totalCells; c++) {  
	                Cell cell = row.getCell(c);  
	                String cellValue = "";  
	                if (cell == null) {  
	                    rowList[c] = (cellValue);  
	                    continue;  
	                }  
	                cellValue = ConvertCellStr(cell, cellValue);  
	                rowList[c] = (cellValue);  
	            }  
	            dataList.add(rowList);  
	        }  
	        return dataList;  
	    }  
	  
	    private String ConvertCellStr(Cell cell, String cellStr) {  
	        switch (cell.getCellType()) {  
	            case Cell.CELL_TYPE_STRING:  
	            	 // 读取String  
	                cellStr = cell.getStringCellValue().toString();  
	                break;  
	            case Cell.CELL_TYPE_BOOLEAN:  
	                // 得到Boolean对象的方法  
	                cellStr = String.valueOf(cell.getBooleanCellValue());  
	                break;  
	            case Cell.CELL_TYPE_NUMERIC:  
	                // 先看是否是日期格式
	                if (DateUtil.isCellDateFormatted(cell)) {  
	                	   // 读取日期格式  
	                    cellStr = formatTime(cell.getDateCellValue().toString());  
	                } else {  
	                	// 读取数字  
	                    cellStr = String.valueOf(cell.getNumericCellValue());  
	                }  
	                break;  
	            case Cell.CELL_TYPE_FORMULA:  
	            	 // 读取公式  
	                cellStr = cell.getCellFormula().toString();  
	                break;  
	        }  
	        return cellStr;  
	    }  
	  
	    private boolean isExcel2007(String fileName) {  
	        return fileName.matches("^.+\\.(?i)(xlsx)$");  
	    }  
	  
	    private String formatTime(String s) {  
	        SimpleDateFormat sf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);  
	        Date date = null;  
	        try {  
	            date = sf.parse(s);  
	        } catch (ParseException ex) {  
	            Logger.getLogger(ExcelRead.class.getName()).log(Level.SEVERE, null, ex);  
	        }  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        String result = sdf.format(date);  
	        return result;  
	    }  
	  
	    public static void main(String[] args) throws IOException {  
	    	ExcelRead re = new ExcelRead();  
	  
	        //List<String[]> list = re.readExcel("c:/群组.xlsx"); 
	    	//文件目录为项目根目录
	    	//读取的数据存在 list集合中，集合中每个元素是 一个String数组，每个数组元素对应excel中元素，必须理解这个数据结构
	    	//读取的数据存在 list集合中，集合中每个元素是 一个String数组，每个数组元素对应excel中元素，必须理解这个数据结构
	    	//读取的数据存在 list集合中，集合中每个元素是 一个String数组，每个数组元素对应excel中元素，必须理解这个数据结构
	    	 List<String[]> list = re.readExcel("2013数据.xlsx"); 
	        if(list ==null){
	        	System.out.println("打开文件出错");
	        }
	        
	        System.out.println(list.size());
	        if (list != null) {  
	            for (int i = 0; i < list.size(); i++) {  
	                System.out.println("第" + (i + 1) + "行");  
	                String[] cellList = list.get(i);  
	                //System.out.println(cellList.length);
	                for (int j = 0; j < cellList.length; j++) {  
	                    System.out.print("\t第" + (j + 1) + "列值");  
	                    System.out.println(cellList[j]);  
	                }  
	            }  
	        }  
	    }  



}
