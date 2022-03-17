package com.api.helper;

import com.api.entity.Merchant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {


    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    }


    //convert excel to list of products

    public static List<Merchant> convertExcelToListOfMerchant(InputStream is) {
        List<Merchant> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");
            System.out.println(sheet);
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Merchant merchant = new Merchant();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {

                        case 0:
                            merchant.setMerchantName(cell.getStringCellValue());
                            break;
                        case 1:
                            merchant.setGstin(cell.getStringCellValue());
                            break;
                        case 2:
                            merchant.setPan(cell.getStringCellValue());
                            break;
                        case 3:
                            merchant.setAddress(cell.getStringCellValue());
                            break;
                        case 4:
                            merchant.setAccountNumber((long) cell.getNumericCellValue());
                            break;
                        case 5:
                            merchant.setPhoneNumber((long) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(merchant);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


}
