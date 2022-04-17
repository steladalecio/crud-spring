package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Student;
import br.edu.ifms.crudspring.service.StudentService;


@Controller 
@RequestMapping("/student") 

public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/list")
    public String saves(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }
    

    @GetMapping("/list")
    public String locall(@Valid Student student, Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("listStudents", students);
        model.addAttribute("studentUpdate", new Student());
        return "list";
    }
    

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("student", new Student());
        return "Reg";
    }

    @GetMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") UUID id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @Valid Student student, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "edit";
        }

        this.studentService.save(student);

        return "redirect:/student/list";
    }
    

}
