package com.work.service;
import com.work.Entity.Student;
import java.util.List;
public interface StudentService {
    Student addStudent(Student student);
    Student studentFind(Integer id);
    List<Student> studentFindAll();
    void studentdelete(Integer id);
    Student studentUpdate(Student student);
}
