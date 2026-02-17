package Utilities; // package declaration: this class is in the Utilities package

import org.apache.poi.ss.usermodel.*; // import Apache POI interfaces and classes for Excel handling (Workbook, Sheet, Row, Cell, etc.)
import org.testng.annotations.DataProvider;

import java.io.File; // import File to represent file system paths
import java.io.FileInputStream; // import FileInputStream to read bytes from the Excel file
import java.io.IOException; // import IOException for method throws declaration
import java.lang.reflect.Method;

public class ReadXLSdata { // public class to read test data from an Excel file

    @DataProvider(name = "testData") // TestNG DataProvider annotation to define a data provider named "testdata"
    public String[][] getData(Method method) throws IOException { // method that returns a 2D String array given the sheet name, may throw IOException
        String excelSheetName = method.getName(); // use the test method's name as the sheet name to read from
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx"); // locate the Excel file relative to project root
        FileInputStream fileInputStream = new FileInputStream(file); // open a file input stream for the Excel file
        Workbook workbook = WorkbookFactory.create(fileInputStream); // create a Workbook from the input stream using POI's WorkbookFactory
        Sheet sheetname = workbook.getSheet(excelSheetName); // get the sheet by name from the workbook

        int totalRows = sheetname.getLastRowNum(); // get index of the last row (0-based), used to determine number of data rows
        System.out.println("Total number of rows: " + totalRows); // print totalRows for debugging / visibility
        Row rowCells = sheetname.getRow(0); // read the first row (usually header) to determine the number of columns
        int totalCols = rowCells.getLastCellNum(); // get number of columns from header row (getLastCellNum returns count)
        System.out.println("Total number of columns: " + totalCols); // print totalCols for debugging / visibility

        DataFormatter formatter = new DataFormatter(); // create a formatter to convert cell values to String reliably
        String testData[][] = new String[totalRows][totalCols]; // allocate the 2D array for test data (rows x cols)
        for (int i = 1; i <= totalRows; i++) { // iterate rows starting from 1 to skip header row (assumes header is row 0)
            for (int j = 0; j < totalCols; j++) { // iterate through each column in the current row
                testData[i - 1][j] = formatter.formatCellValue(sheetname.getRow(i).getCell(j)); // read cell, format to String, store in array
                System.out.println(testData[i - 1][j] + " "); // print the cell value for debugging / quick verification
            } // end inner for: finished processing all columns for a given row
        } // end outer for: finished processing all data rows
        return testData; // return the populated 2D String array containing the sheet's data

    } // end getData method
} // end ReadXLSdata class
