package com.codsoft.studentmanagementsystempro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository repo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", repo.findAll());
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
