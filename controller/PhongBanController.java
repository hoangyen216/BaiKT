package com.hoangyen.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hoangyen.model.PhongBan;
import com.hoangyen.service.PhongBanService;

import java.util.List;

@Controller
@RequestMapping("/phongban")
public class PhongBanController {
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String listCategory(Model model){
        List<PhongBan> category = phongBanService.getAllPhongBan();
        model.addAttribute("categories", category);
        model.addAttribute("title", "DANH SÁCH PHÒNG BAN");
        return "category/list";
    } 
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("category", new PhongBan());
        return "category/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("category") PhongBan category, BindingResult bindingResult, Model model) {
        
        phongBanService.addPhongBan(category);
        return "redirect:/phongban";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") long id, Model model){
        PhongBan editCategory = phongBanService.getPhongBanById(id);
        if(editCategory != null){
            model.addAttribute("category", editCategory);
            return "category/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("category")PhongBan updateCategory, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            return "category/edit";
        }
        phongBanService.getAllPhongBan().stream()
                .filter(category -> category.getMaphong() == updateCategory.getMaphong())
                .findFirst()
                .ifPresent(book -> {
                	phongBanService.updatePhongBan(updateCategory);
                });
        return "redirect:/category";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id){
    	phongBanService.deletePhongBan(id);
        return "redirect:/category";
    }
}
