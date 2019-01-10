package com.work.serviceImpl;

import com.work.Repository.StudentRepository;
import com.work.service.StudentService;
import com.work.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student studentFind(Integer id){
        return studentRepository.findById(id).get();
    }
    public List<Student> studentFindAll(){
        return studentRepository.findAll();
    }
    public void studentdelete(Integer id){
        studentRepository.deleteById(id);
    }
    public Student studentUpdate(Student student){
        return studentRepository.save(student);
    }
}
