package com.adrian.springboot.springmvc.app.controllers;

import com.adrian.springboot.springmvc.app.entities.User;
import com.adrian.springboot.springmvc.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@SessionAttributes({"user"})
public class UserController {

   private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("title", "Hola Mundo Spring Boot!!!");
        model.addAttribute("messages", "Esta es un app spring boot!!!");
        model.addAttribute("user", new User("Adrian", "Carpio"));
        return "view";
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("title", "Listado de usuarios");
        model.addAttribute("users", service.findAll());
        return "list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Crear Usuario");
        return "form";
    }

    @GetMapping("/form/{id}")
    public String form(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isPresent()) {
            model.addAttribute("user", optionalUser.get());
            model.addAttribute("title", "Editar Usuario");
            return "form";
        } else {
            redirect.addFlashAttribute("error", "El usuario"
                    + optionalUser.get().getId()
                    + " no existe");
            return "redirect:/users";
        }
    }

    @PostMapping
    public String form(@Valid User user, BindingResult result, Model model, RedirectAttributes redirect, SessionStatus status ) {

        if (result.hasErrors()) {
            model.addAttribute("title", "validando Formulario");
            return "form";
        }
        
        String message = (user.getId() != null && user.getId() > 0) ? "El usuario" +
                user.getName() +
                " actualizado correctamente!" : "El usuario" +
                user.getName() +
                " creado correctamente!";

        this.service.save(user);
        status.setComplete();
        redirect.addFlashAttribute("success", message);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isPresent()) {
            redirect.addFlashAttribute("success", "El usuario" +
                    optionalUser.get().getName() +
                    " eliminado correctamente!");
            service.remove(id);
            return "redirect:/users";
        }
        redirect.addFlashAttribute("error", "El usuario" + id + " no existe");
        return "redirect:/users";
    }
}
