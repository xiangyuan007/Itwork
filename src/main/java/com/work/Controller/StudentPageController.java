package com.work.Controller;
import com.work.Entity.Student;
import com.work.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Controller
@RequestMapping("/web")
public class StudentPageController {
    @Autowired
    private StudentService studentService;
   @RequestMapping("/all")
    public String getAllStu(Model model){
        List<Student>  lists=studentService.studentFindAll();
        model.addAttribute("stus",lists);
        return "index2";
    }
    @GetMapping("/update/{id}")
    public String update_Show(Model model, @PathVariable("id") Integer stuID)
    {
        Student tmp = studentService.studentFind(stuID);
        model.addAttribute("stu",tmp);
        model.addAttribute("cap","修改学生信息");
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update_Submit(Model model, @PathVariable("id") Integer stuID, @ModelAttribute Student stu)
    {
        //stu.setStuID(stuID);
       Student tmp=new Student();
        tmp.setStuID(stuID);
        tmp.setStuName(stu.getStuName());
        tmp.setStuPhone(stu.getStuPhone());
        tmp.setStuAddress(stu.getStuAddress());
        studentService.studentUpdate(tmp);
        model.addAttribute("stu",stu);
        //return getAllStu(model);
        return "result";
}

    @GetMapping("/add")
    public String add_Show(Model model)
    {
        model.addAttribute("stu",new Student());
        model.addAttribute("cap","添加新的学生");
        return "update";
    }

    @PostMapping("/add")
    public String add_Submit(Model model, @ModelAttribute Student stu)
    {
        Student newStudent = new Student();
        newStudent.setStuPhone(stu.getStuPhone());
        newStudent.setStuName(stu.getStuName());
        newStudent.setStuAddress(stu.getStuAddress());
        newStudent.setStuID(0);
        studentService.addStudent(newStudent);
        model.addAttribute("stu",newStudent);
        //return getAllStu(model);
        return "result";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable("id") Integer stuID)
    {
        studentService.studentdelete(stuID);
        return "delSuc";
    }
}
