package com.hoangyen.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hoangyen.model.NhanVien;
import com.hoangyen.service.NhanVienService;
import com.hoangyen.service.PhongBanService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanvienService;
    @Autowired
    private PhongBanService phongbanService;
    @GetMapping
    public String listBooks(Model model){
        List<NhanVien> nhanviens = nhanvienService.getAllNhanVien();
        model.addAttribute("nhanviens", nhanviens);
        model.addAttribute("title", "DANH SÁCH NHÂN VIÊN");
        return "book/list"; 
    }    
     
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("categories", phongbanService.getAllPhongBan());
        return "book/add";
    }    
    @PostMapping("/add")
    public String addBook( @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult bindingResult, Model model) {

        nhanvienService.addNhanVien(nhanvien);
        return "redirect:/nhanvien";
    }
  
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") long id, Model model){
        NhanVien editBook = nhanvienService.getNhanVienById(id);
        if(editBook != null){
            model.addAttribute("nhanvien", editBook);
            model.addAttribute("categories", phongbanService.getAllPhongBan());
            return "book/edit";
        }else {
            return "not-found";
        }     
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("nhanvien")NhanVien updateNV, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", phongbanService.getAllPhongBan());
            return "book/edit";
        } 
        nhanvienService.getAllNhanVien().stream()
                .filter(nhanvien -> nhanvien.getMaNV() == updateNV.getMaNV())
                .findFirst()
                .ifPresent(nhanvien -> {

                    nhanvienService.updateNhanVien(updateNV);
                });  
        return "redirect:/nhanvien";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id){
        nhanvienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }
}
