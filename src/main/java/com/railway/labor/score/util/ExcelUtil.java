package com.railway.labor.score.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelUtil {
	
    @SuppressWarnings("deprecation")
	public static boolean rowHasData(XSSFRow row,List<Integer> columnIndexList) {
        if (row == null) {
            return false;
        }
        
        for (Integer columnIndex : columnIndexList) {
        	XSSFCell cell = row.getCell(columnIndex);
        	if(cell!=null){
        		if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    if (StringUtils.isNotBlank(cell.getStringCellValue())) {
                        return true;
                    }
                } else {
                    if (StringUtils.isNotBlank(cell.getRawValue())) {
                        return true;
                    }
                }
        	}
		}
        return false;
    }
    
    @SuppressWarnings("deprecation")
   	public static boolean rowHasData(XSSFRow row, int colStart, int colEnd) {
           if (row == null) {
               return false;
           }
           for (int i = colStart; i <= colEnd; i++) {
           	XSSFCell cell = row.getCell(i);
           	if(cell!=null){
           		if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                       if (StringUtils.isNotBlank(cell.getStringCellValue())) {
                           return true;
                       }
                   } else {
                       if (StringUtils.isNotBlank(cell.getRawValue())) {
                           return true;
                       }
                   }
           	}
   		}
           return false;
       }
}
