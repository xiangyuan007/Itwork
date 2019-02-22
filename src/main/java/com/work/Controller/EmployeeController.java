package com.work.Controller;
import com.work.Entity.EmployeeInf;
import com.work.Entity.EmployeeJudge;
import com.work.service.EJudgeService;
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
    @Autowired
    private EJudgeService eJudgeService;

    //增加评价
    @PostMapping("/addJudge")
    private EmployeeJudge addJudge(@RequestBody EmployeeJudge employeeJudge){
        return eJudgeService.addJudge(employeeJudge);
    }

    //增加一个兼职人员信息
    @PostMapping("/add")
    public EmployeeInf addEmployee(@RequestBody EmployeeInf employee){
        System.out.println(employee.getEmpId());
       return employeeService.addEmployee(employee);
    }
    //根据ID查询一个兼职人员信息
    @PostMapping(value = "/find")
    public EmployeeInf FindOne(@RequestBody EmployeeInf employee) {
        return employeeService.FindOne(employee.getEmpId());
    }
    //查询全部兼职人员信息
    @PostMapping(value = "/findAll")
    public List<EmployeeInf> FindAll() { return employeeService.FindAll();
    }
    //根据ID删除一个兼职人员信息
    @PostMapping(value = "/delete")
    public void deleteEmployee(@RequestBody EmployeeInf employee) {
        employeeService.deleteEmployee(employee.getEmpId());
    }
    //更新
    @PostMapping(value = "/update")
    private EmployeeInf UpdateEmployee(@RequestBody EmployeeInf employee){
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
