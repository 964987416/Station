package com.xuxueli.poi.excel.test;

import com.briup.bean.Station;
import com.xuxueli.poi.excel.ExcelExportUtil;
import com.xuxueli.poi.excel.ExcelImportUtil;
import com.xuxueli.poi.excel.test.model.ShopDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FUN Test
 *
 * @author xuxueli 2017-09-08 22:41:19
 */
public class test1 {

    public static void main(String[] args) {

    
        String filePath = "E:\\demo-sheet.xls";
        /**
         * Excel导入：Excel 转换为 Object
          */
        List<Object> list = (List<Object>) ExcelImportUtil.importExcel(filePath, Station.class);
        for (Object object : list) {
        	System.out.println(object);
        	
		}

    }

}
