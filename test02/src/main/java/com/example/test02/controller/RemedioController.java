package com.example.test02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test02.entity.RemedioEntity;
import com.example.test02.interfaces.IRemedioService;

@Controller
@RequestMapping("/crud/remedio")
public class RemedioController {
    @Autowired
    private IRemedioService service;

    @GetMapping
    public String listar(Model model) {
        List<RemedioEntity> lista = service.findAll();
        model.addAttribute("remedio", lista);
        return "indexremedio";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("remedio", new RemedioEntity());
        return "remedio-form";
    }

   @PostMapping("/guardar") 
    public String guardar(@ModelAttribute("remedio") RemedioEntity remedio) {
        service.save(remedio);
        return "redirect:/crud/remedio";
    }

    @GetMapping("/{id}/editar")
    public String formularioEditar(@PathVariable("id") Long id, Model model) {
        RemedioEntity remedio = service.findById(id);
        model.addAttribute("remedio", remedio);
        return "remedio-form";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable("id") Long id, @ModelAttribute("remedio") RemedioEntity remedio) {
       
        service.update(id, remedio);
        return "redirect:/crud/remedio";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/crud/remedio";
    }
}



