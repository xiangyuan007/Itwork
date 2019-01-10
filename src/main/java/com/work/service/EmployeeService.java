package com.work.service;
import com.work.Entity.EmployeeInf;
import java.util.List;
public interface EmployeeService {
    //兼职人员信息的增删改查
    EmployeeInf addEmployee(EmployeeInf employee);
    EmployeeInf FindOne(String id);
    List<EmployeeInf> FindAll();
    void deleteEmployee(String id);
    EmployeeInf UpdateEmployee(EmployeeInf employee);
    //根据审核状态搜索兼职人员信息
    List<EmployeeInf> findByStatus(Integer status);
}
