package com.hoangyen.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangyen.model.NhanVien;
import com.hoangyen.repository.NhanVienRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanvienRepository;
    public List<NhanVien> getAllNhanVien(){
        return nhanvienRepository.findAll();
    }
    public NhanVien getNhanVienById(Long id){
        Optional<NhanVien> optionalNhanVien = nhanvienRepository.findById(id);
        return optionalNhanVien.orElse(null);
    }
    public void addNhanVien(NhanVien newnhanvien){
        nhanvienRepository.save(newnhanvien);
    }
    public void updateNhanVien(NhanVien newnhanvien){
        nhanvienRepository.save(newnhanvien);
    }
    public void deleteNhanVien(Long id){
        nhanvienRepository.deleteById(id);
    }
}
