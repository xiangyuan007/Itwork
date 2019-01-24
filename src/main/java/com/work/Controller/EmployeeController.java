package com.work.Controller;
import com.work.Entity.EmployeeInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.work.service.EmployeeService;
import com.work.Repository.EmployeeRepository;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //123
    //321
    //增加一个兼职人员信息
    @PostMapping("/add")
    public EmployeeInf addEmployee(@RequestBody EmployeeInf employee){
        System.out.println(employee.getEmpId());
       return employeeService.addEmployee(employee);
    }
    //根据ID查询一个兼职人员信息
    @GetMapping(value = "/find/{id}")
    public EmployeeInf FindOne(@PathVariable("id") String id) {
        return employeeService.FindOne(id);
    }
    //查询全部兼职人员信息
    @GetMapping(value = "/findAll")
    public List<EmployeeInf> FindAll() { return employeeService.FindAll();
    }
    //根据ID删除一个兼职人员信息
    @DeleteMapping(value = "/delete/{id}")
    public void deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
    }
    //更新
    @PutMapping(value = "/update")
    private EmployeeInf UpdateEmployee(EmployeeInf employee){
        return employeeService.UpdateEmployee(employee);
    }
   /* @Transactional
    @GetMapping(value = "/search/{status}")
    public List<EmployeeInf> search(@PathVariable("status") Integer status) {

       // return employeeService.searchByStatus(status);
       return employeeRepository.SearchEmployeeByStatus(status);
    }*/
    //@Transactional
    @GetMapping(value = "/f/{status}")
    public List<EmployeeInf> f(@PathVariable("status") Integer status){
        return employeeService.findByStatus(status);
    }
}
