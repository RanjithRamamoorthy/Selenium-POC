package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{

                                                private static XSSFSheet ExcelWSheet;

                                                private static XSSFWorkbook ExcelWBook;

                                                private static XSSFCell Cell;

                                                private static XSSFRow Row;

                                public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception 
                                {   
 
                                   String[][] tabArray = null;

                                   try 
                                   {
                                                   FileInputStream ExcelFile = new FileInputStream(FilePath);

                                                   // Access the required test data sheet

                                                   ExcelWBook = new XSSFWorkbook(ExcelFile);

                                                   ExcelWSheet = ExcelWBook.getSheet(SheetName);

                                                   int startRow = 1;

                                                   int startCol = 0;

                                                   int ci,cj;

                                                   int totalRows = ExcelWSheet.getLastRowNum();
                                                   System.out.println("Rows :"+totalRows);
                                                   // you can write a function as well to get Column count

                                                   int totalCols = ExcelWSheet.getRow(0).getLastCellNum() ;
                                                   System.out.println("columns :"+totalCols);
                                                

                                                   ci=0;
                                                   
                                                   // Randomly picking the start of the row
                                                   double start = Math.floor(Math.random() * (totalRows - startRow + 1));
                                                   if((totalRows - start) < 10)
                                                                   start = start-10;
                                                   tabArray=new String[10][totalCols];
                                                   for (int i=(int)start;i<(start+10);i++, ci++) 
                                                   {                             
                                                                  cj=0;
                                                                   for (int j=startCol;j<totalCols;j++, cj++)
                                                                   {
                                                                                   tabArray[ci][cj]=getCellData(i,j);
                                                                                   System.out.println(tabArray[ci][cj]);  
                                                                                }
                                                                }
                                                }
                                                                catch (FileNotFoundException e)
                                                                {
                                                                                System.out.println("Could not read the Excel sheet");
                                                                                e.printStackTrace();
                                                                }

                                                catch (IOException e)
                                                {
                                                                System.out.println("Could not read the Excel sheet");
                                                                e.printStackTrace();
                                                }
                                                return(tabArray);
                                }

                                public static String getCellData(int RowNum, int ColNum) throws Exception 
                                {
                                                try
                                                {
                                                                Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                                                                String CellData = Cell.getStringCellValue();
                                                                                return CellData;
                                                                
                                                }
                                                catch (Exception e)
                                                {
                                                                System.out.println(e.getMessage());
                                                                throw (e);
                                                }
                                }
                                
                                @SuppressWarnings({ "static-access", "deprecation" })
								public static void setCellData(String Result,  int RowNum, int ColNum, String filepath, String sheetname) throws Exception    {
                                                
                                                try
                                                {
                                               Row  = ExcelWSheet.getRow(RowNum);
                                                                Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
                                                                if (Cell == null) 
                                                                {
                                                                                Cell = Row.createCell(ColNum);
                                                                                Cell.setCellValue(Result);
                                                                } 
                                                                else 
                                                                {
                                                                                Cell.setCellValue(Result);
                                                                }

      // Constant variables Test Data path and Test Data file name

                                                               FileOutputStream fileOut = new FileOutputStream(filepath+"//"+sheetname);
                                                               ExcelWBook.write(fileOut);
                                                               fileOut.flush();
                                                                                fileOut.close();
                                                                }
                                                catch(Exception e)
                                                {
                                                                throw (e);
                                                }
                                }

                }
