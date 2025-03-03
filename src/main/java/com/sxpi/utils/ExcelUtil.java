package com.sxpi.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;

public class ExcelUtil<T> {
    private Class<T> clazz;

    public ExcelUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void exportExcel(List<T> list, String sheetName, HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        // 创建表头
        Row headerRow = sheet.createRow(0);
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(field.getName());
        }

        // 填充数据
        for (int i = 0; i < list.size(); i++) {
            T obj = list.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < fields.length; j++) {
                Field field = fields[j];
                field.setAccessible(true);
                Cell cell = row.createCell(j);
                try {
                    Object value = field.get(obj);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(sheetName + ".xlsx", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        // 输出文件
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.flush();
        outputStream.close();
    }
}