package com.hoangyen.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangyen.model.PhongBan;
import com.hoangyen.repository.PhongBanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongbanRepository;

    public List<PhongBan> getAllPhongBan(){
        return phongbanRepository.findAll();
    }
    public PhongBan getPhongBanById(Long id){
        Optional<PhongBan> optionalPhongBan = phongbanRepository.findById(id);
        if(optionalPhongBan.isPresent()){
            return optionalPhongBan.get();
        } else {
            throw new RuntimeException("PhongBan Not Found");
        }
    }
    public void addPhongBan(PhongBan newPhongBan){
        phongbanRepository.save(newPhongBan);
    }
    public PhongBan savePhongBan(PhongBan phongban) { return phongbanRepository.save(phongban);}
    public void updatePhongBan(PhongBan phongban){
        phongbanRepository.save(phongban);
    }
    public void deletePhongBan(Long id) {phongbanRepository.deleteById(id);}
}
