package com.work.serviceImpl;

import com.work.Entity.EmployeeInf;
import com.work.service.EmployeeService;
import com.work.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeInf addEmployee(EmployeeInf Employee){
        return employeeRepository.save(Employee);
    }
    public EmployeeInf FindOne(String id){
        try{
            EmployeeInf employee = employeeRepository.findById(id).get();
            return employee;
        }catch(Exception e) {
            return null;
        }
    }
    public List<EmployeeInf> FindAll(){
        return employeeRepository.findAll();
    }
    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }
    public EmployeeInf UpdateEmployee(EmployeeInf employee){
        return employeeRepository.save(employee);
    }
    @Transactional
   public List<EmployeeInf> findByStatus(Integer status){
       if(status==-1)
            return employeeRepository.findAll();
        else
            return employeeRepository.findEmployeeByStatus(status);
    }
}
