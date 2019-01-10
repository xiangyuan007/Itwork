package com.work.Controller;
import com.work.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.work.service.StudentService;
import java.util.List;
@RestController
@RequestMapping("stu")
public class StudentController {
    @Autowired
    private StudentService studentService;
    //增加一个学生
    @PostMapping("/add")
    private Student addStudent(Student student){
        return studentService.addStudent(student);
    }
    //根据ID查询一个学生
    @GetMapping(value = "/find/{id}")
    public Student studentFind(@PathVariable("id") Integer id) {
        return studentService.studentFind(id);
    }
    //查询全部学生
    @GetMapping(value = "/findAll")
    public List<Student> studentFindAll() {
        return studentService.studentFindAll();
    }
    //根据ID删除一个学生
    @DeleteMapping(value = "/delete/{id}")
    public void studentdelete(@PathVariable("id") Integer id) {
        studentService.studentdelete(id);
    }
    //更新
    @PutMapping(value = "/update")
    private Student studentUpdate(Student student){
        return studentService.studentUpdate(student);
    }

}
