package com.Webalk.Verseny.ACI3X3.controller;

import java.io.IOException;

import com.Webalk.Verseny.ACI3X3.models.Verseny;
import com.Webalk.Verseny.ACI3X3.service.VersenyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
    @Autowired
    private VersenyService versenyService;

    @GetMapping("/index")
    public String index(Model model) throws IOException {
        model.addAttribute("list", versenyService.findAll());
        return "index";
    }

    @GetMapping("/form={ID}")
    public String formUpdate(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            Long longid = Long.parseLong(id);
            model.addAttribute("verseny", versenyService.findById(Long.parseLong(id)));
        } catch (NumberFormatException e) {

        }
        return "form";

    }

    @GetMapping("/form")
    public String formInsert(Model model) throws IOException {
        model.addAttribute("verseny", new Verseny());
        return "form";
    }

    @PostMapping("/update")
    public String formSubmit(@ModelAttribute Verseny verseny, Model model) {
        model.addAttribute("verseny", verseny);
        versenyService.save(verseny);
        return "proceeded";
    }

    @GetMapping("/delete={ID}")
    public String delete(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            Long longid = Long.parseLong(id);
            versenyService.delete(versenyService.findById(longid));
        } catch (NumberFormatException e) {

        }
        return "proceeded";

    }
}
