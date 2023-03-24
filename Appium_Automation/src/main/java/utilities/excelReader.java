package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class excelReader {
    private  static XSSFSheet mSheet;
    static configReader confReader;
    public excelReader(){

    }

    public void readExcelFile(){
        confReader = new configReader();

        if(mSheet != null){
            return ;
        }
        File src = new File(confReader.getExcepPAth());

        try{
            FileInputStream file = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(file);
            mSheet  =wb.getSheetAt(0);

        }
        catch (Exception e){
            System.out.println("You Get:" + e);
        }
    }

    public  static String getCellValueFromSheet(int row, int col){
        if(mSheet == null){
            return "";
        }
        XSSFCell cell = mSheet.getRow(row).getCell(col);
        return cell.getStringCellValue();
    }


}
