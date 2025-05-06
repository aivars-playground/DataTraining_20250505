import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class XlsFileReader {
    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream(args[0]);
        Workbook workbook = WorkbookFactory.create(in);

        System.out.println("Workbook(numberOfSheets:" + workbook.getNumberOfSheets()+")");
        Sheet purchasesSheet = workbook.getSheetAt(0);
        System.out.println("Sheet(sheetName:" +  purchasesSheet.getSheetName()+")");

        StringBuilder stringBuilder = new StringBuilder();
        for (Row row : purchasesSheet) {
            for (Cell cell : row) {
                stringBuilder.append(cell2String(cell));
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    static String cell2String(Cell cell) {
        switch (cell.getCellType()) {
            case BLANK -> {
                return "[ ]";
            }
            case FORMULA -> {
                return "[F:" +
                        cell.getCellFormula() +
                        " (" + cell.getCachedFormulaResultType() +" -> " +
                        cell.getNumericCellValue() + ")]";
            }
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    return "[D:" + cell.getLocalDateTimeCellValue() + "]";
                } else {
                    return "[N:" + cell.getNumericCellValue() + "]";
                }
            }
            case STRING -> {
                return "[S:" + cell.getStringCellValue() + "]";
            }
            default -> {
                return "[?]";
            }
        }
    }
}