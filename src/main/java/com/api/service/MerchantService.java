package com.api.service;

import com.api.entity.Merchant;
import com.api.helper.Helper;
import com.api.repo.MerchantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepo merchantRepo;

    public void  save(MultipartFile file){

        try{
            List<Merchant> merchantList= Helper.convertExcelToListOfMerchant(file.getInputStream());

            this.merchantRepo.saveAll(merchantList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public List<Merchant> getAllMerchants(){
        return this.merchantRepo.findAll();
    }
}

