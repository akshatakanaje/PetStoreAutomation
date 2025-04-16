package api.utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XLUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    public String path;

    public XLUtility(String path){
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        int rowcount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }

    public int getCellCount(String sheetName, int rownum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        int cellcount=row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellcount;
    }

    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
        File xlfile=new File(path);
        if(!xlfile.exists()){
            workbook=new XSSFWorkbook();
            fo=new FileOutputStream(path);
            workbook.write(fo);
        }

        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);

        if(workbook.getSheetIndex(sheetName)==-1) //If sheet not exists then create new sheet
            workbook.createSheet(sheetName);
        sheet=workbook.getSheet(sheetName);

        if(sheet.getRow(rownum)==null)  //If row not exists then create new row
            sheet.createRow(rownum);
        row=sheet.getRow(rownum);

        cell=row.createCell(colnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}
