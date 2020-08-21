package com.myproject.admin.controller;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.SeatCategory;
import com.myproject.service.SeatCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@Controller
@RequestMapping("admin/seatcategory")
public class AdminSeatCategoryController {
    @Autowired
    private SeatCategoryService seatCategoryService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("categories", seatCategoryService.findAll());
        return "seatcategory/index";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("category", new SeatCategory());
        return "seatcategory/add";
    }

    @PostMapping("add")
    public String add(Model model,
                      @Validated @ModelAttribute("category") SeatCategory category,
                      BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("category", category);
            return "seatcategory/add";
        }
        ResponseModel<Null> errorModel = seatCategoryService.insert(category);
        if (errorModel.getStatusCode() != CONSTANT.API_RESPONSE_STATUS_CODE_OK) {
            model.addAttribute("message", errorModel.getMessage());
            model.addAttribute("category", category);
            return "seatcategory/add";
        }

        return "redirect:/admin/seatcategory";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", seatCategoryService.findById(id));
        return "seatcategory/edit";
    }

    @PostMapping("edit")
    public String edit(Model model,
                       @Validated @ModelAttribute("category") SeatCategory category,
                       BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("category", category);
            return "seatcategory/edit";
        }
        ResponseModel<Null> errorModel = seatCategoryService.update(category);
        if (errorModel.getStatusCode() != CONSTANT.API_RESPONSE_STATUS_CODE_OK) {
            model.addAttribute("message", errorModel.getMessage());
            model.addAttribute("category", category);
            return "seatcategory/edit";
        }
        return "redirect:/admin/seatcategory";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        seatCategoryService.delete(id);
        return "redirect:/admin/seatcategory";
    }
}
