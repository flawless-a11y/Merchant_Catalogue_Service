package com.api.controller;


import com.api.entity.Merchant;
import com.api.helper.Helper;
import com.api.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("/merchant/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
        if(Helper.checkExcelFormat(file)){
            //true

            this.merchantService.save(file);


            Map<String ,String> body = new HashMap<>();
            body.put("message","File is uploaded and the data is saved to db");
            return ResponseEntity.ok(body);

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload exel file with .xlsx format");

    }

    @GetMapping("/merchant")
    public List<Merchant> getAllMerchant(){
        return this.merchantService.getAllMerchants();
    }
}
