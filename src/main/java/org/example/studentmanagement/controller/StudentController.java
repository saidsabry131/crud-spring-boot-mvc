package org.example.studentmanagement.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model)
    {

        model.addAttribute("students",studentService.getALL());
        return "views/students";
    }


    @GetMapping("/students/create")
    public String createStudent(Model model)
    {
        Student student=new Student();

        model.addAttribute("student",student);

        return "views/studentform";
    }

    @PostMapping("/students")

    public String savingStudent(@ModelAttribute Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/api/students";
    }

//    public String savingStudent(HttpServletRequest request)
//    {
//        Student student=new Student();
//        student= (Student) request.getAttribute("student");
//        studentService.saveStudent(student);
//        return "redirect:/api/students";
//    }


    @GetMapping("/students/delete/{id}")

    String deleteStudent(@PathVariable("id") Long id)
    {

        Student student=studentService.deleteStudent(id);
        System.out.println(student);
        if(student !=null)
        return "redirect:/api/students";
        else {
            return "views/errorpage";
        }
    }


    @GetMapping("/students/edit/{id}")
    String showFormEditing(Model model,@PathVariable("id") Long id)
    {

        Student student=studentService.getStudent(id);

        model.addAttribute("theStudent",student);
        return "views/editform";
    }

    @PostMapping("/students/edit/{id}")
    String editingStudent(@PathVariable("id") Long id,@ModelAttribute("theStudent") Student student)
    {

        studentService.edit(student);
        return "redirect:/api/students";

    }

}
