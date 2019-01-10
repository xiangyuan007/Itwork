package com.work.Controller;
import com.work.Entity.Administrator;
import com.work.Entity.EmployeeInf;
import com.work.service.AdminService;
import com.work.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("/InfWeb")
public class InfPageController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private AdminService adminService;
    //登录Controller
    Administrator admin = new Administrator();
    @RequestMapping("/adminlogin")
    public String login( @RequestParam String name,String password, Model m,  HttpSession session){
        Object usero = session.getAttribute("admin");
        //如果用户登陆过直接进入用户主页
        if(usero!=null){
            return getAll(m);
        }

        admin.setAdminName(name);
        admin.setAdminPassword(password);

        //判断是否存在该用户
        int issu =  adminService.hasAdmin(name,password);
        if (issu==1){          //登录成功
            return getAll(m);
        }else if(issu==2){      //密码错误
            m.addAttribute("name","1");
            return "login";
        }else {                 //不存在该用户
            m.addAttribute("name","2");
            return "login";
        }
    }

    //跳转到登录页面
    @GetMapping(value = "/login")
    public String indexpage(String name,Model model){
        model.addAttribute("name",name);
        return  "login";
    }
    @RequestMapping("/all")
    public String getAll(Model model){
        List<EmployeeInf>  lists=employeeService.FindAll();
        model.addAttribute("emp",lists);
        return "index";
    }
    @GetMapping("/find/{status}")
    public String findByStatus(Model model,@PathVariable("status") Integer status){
        List<EmployeeInf>  lists=employeeService.findByStatus(status);
        model.addAttribute("emp",lists);
        return "index";
    }
    @GetMapping("/update/{id}")
    public String update_Show(Model model, @PathVariable("id") String empId)
    {
        EmployeeInf emp = employeeService.FindOne(empId);
        model.addAttribute("emp",emp);
        model.addAttribute("cap","修改兼职人员信息");
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update_Submit(Model model, @PathVariable("id") String empId, @ModelAttribute EmployeeInf emp)
    {
        //stu.setStuID(stuID);
        EmployeeInf tmp=new EmployeeInf();
        tmp.setEmpId(empId);
        tmp.setEmpName(emp.getEmpName());
        tmp.setEmpPhone(emp.getEmpPhone());
        tmp.setEmpAddress(emp.getEmpAddress());
        tmp.setEmpSex(emp.getEmpSex());
        tmp.setEmpDegree(emp.getEmpDegree());
        tmp.setEmpIntroduce(emp.getEmpIntroduce());
        tmp.setEmpStatus(emp.getEmpStatus());
        employeeService.UpdateEmployee(tmp);
        model.addAttribute("emp",emp);
        //return getAllStu(model);
        return "result";
    }
    @GetMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable("id") String empId)
    {
        employeeService.deleteEmployee(empId);
        return "delSuc";
    }

    @PostMapping("/check/{choice}")
    public void check(@PathVariable("choice") Integer choice, @ModelAttribute String empId) {
        EmployeeInf emp = employeeService.FindOne(empId);
        emp.setEmpStatus(choice);
        employeeService.UpdateEmployee(emp);
    }
}