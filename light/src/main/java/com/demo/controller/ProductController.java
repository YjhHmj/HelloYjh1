package com.demo.controller;

import com.demo.model.ProductInitResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yjh
 * @date 2020-02-04 14:33
 */
@RestController
@RequestMapping("product/")
public class ProductController {

    //测试类
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String index() {
        return "testSuccess";
    }

    //初始化读取excel并且解析
    @RequestMapping(value = "init", method = RequestMethod.GET)
    public List<ProductInitResponse> init() throws Exception {
        return this.getExcelInfo();
    }

    //获取Excel数据
    private List<ProductInitResponse> getExcelInfo() throws Exception {
        //文件路径
        String filePath = "/usr/local/java/light1.xlsx"; //todo 这里要改
        XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet = wookbook.getSheet("Sheet1");

        //获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        //结果集
        List<ProductInitResponse> responseList = new ArrayList<ProductInitResponse>();
        //遍历行
        for (int i = 2; i < rows; i++) {
            //读取左上端单元格
            XSSFRow row = sheet.getRow(i);
            //行不为空
            if (row != null) {
                ProductInitResponse productInitResponse = new ProductInitResponse();
                //赋值
                productInitResponse.setProductName(this.getValue(row.getCell(0)));
                productInitResponse.setWatts(this.getValue(row.getCell(1)));
                productInitResponse.setVoltage(this.getValue(row.getCell(2)));
                productInitResponse.setMinWidth(this.getValue(row.getCell(3)));
                productInitResponse.setMinLength(this.getValue(row.getCell(4)));
                productInitResponse.setMinHeight(this.getValue(row.getCell(5)));
                productInitResponse.setUnitLength(this.getValue(row.getCell(6)));
                productInitResponse.setMinDepth(this.getValue(row.getCell(7)));
                productInitResponse.setMaxDepth(this.getValue(row.getCell(8)));
                productInitResponse.setLinearSpacing(this.getValue(row.getCell(9)));

                responseList.add(productInitResponse);
            }
        }
        return responseList;
    }

    //获取
    private String getValue(XSSFCell xSSFCell) {
        if (null == xSSFCell) {
            return "";
        }

        xSSFCell.setCellType(Cell.CELL_TYPE_STRING);
        return String.valueOf(xSSFCell.getStringCellValue());


//        if (xSSFCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
//            // 返回布尔类型的值
//            return String.valueOf(xSSFCell.getBooleanCellValue());
//        } else if (xSSFCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
//            // 返回数值类型的值
//            return String.valueOf(xSSFCell.getNumericCellValue());
//        } else {
//            // 返回字符串类型的值
//            return String.valueOf(xSSFCell.getStringCellValue());
//        }
    }

}
