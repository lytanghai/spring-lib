package com.psp.fd.pspspringboot.service;

import com.psp.fd.pspspringboot.dto.ListUserRequest;
import com.psp.fd.pspspringboot.dto.Calculate;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileService {

    public List<ListUserRequest> insertRecord(MultipartFile file) throws IOException {
        List<ListUserRequest> list = new ArrayList<ListUserRequest>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
            ListUserRequest bankHubBlackListDTO = new ListUserRequest();

            XSSFRow row = worksheet.getRow(i);

            bankHubBlackListDTO.setAgentId((int) row.getCell(0).getNumericCellValue());
            bankHubBlackListDTO.setReceiverName(row.getCell(1).getStringCellValue());
            bankHubBlackListDTO.setBankName(row.getCell(2).getStringCellValue());
            list.add(bankHubBlackListDTO);
        }
        String query = "";

        return list;
    }

    public Map<String,Object> calculate(MultipartFile file) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        int numOfSheet = workbook.getNumberOfSheets();

        Map<String,Object> map = new HashMap<>();

        List<Calculate> list = new ArrayList<>();

        double total = 0.0;

        for(int o = 0; o < numOfSheet; o++) {
            Calculate calculate = new Calculate();
            calculate.setName(workbook.getSheetName(o));
            XSSFSheet worksheet = workbook.getSheetAt(o);
            double eachPersonTotal = 0.0;
            for(int i=0; i < worksheet.getPhysicalNumberOfRows();i++) {
                XSSFRow row = worksheet.getRow(i);
                eachPersonTotal += row.getCell(0).getNumericCellValue();
                calculate.setEachPersonTotal(eachPersonTotal);
            }
            list.add(calculate);
            map.put("calculate", list);
            map.put("total", total+= eachPersonTotal);
        }
        return map;
    }

}
