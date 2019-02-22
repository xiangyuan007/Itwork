package com.work.Controller;
import com.work.Entity.Administrator;
import com.work.Entity.EmployeeInf;
import com.work.Entity.JobInf;
import com.work.Entity.User;
import com.work.service.AdminService;
import com.work.service.EmployeeService;
import com.work.service.JobService;
import com.work.service.UserService;
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
    JobService jobService;
    @Autowired
    UserService userService;
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
    @RequestMapping("/all2")
    public String getAll2(Model model){
        List<JobInf>  lists=jobService.FindAll();
        System.out.println(lists.get(1).getJobId());
        System.out.println(lists.get(2).getJobId());
        model.addAttribute("job",lists);
        return "index2";
    }
    @RequestMapping("/all3")
    public String getAll3(Model model){
        List<User>  lists=userService.findAll();
        model.addAttribute("user",lists);
        return "index3";
    }
    @GetMapping("/find/{status}")
    public String findByStatus(Model model,@PathVariable("status") Integer status){
        List<EmployeeInf>  lists=employeeService.findByStatus(status);
        model.addAttribute("emp",lists);
        return "index";
    }
    @GetMapping("/find2/{status}")
    public String findByStatus2(Model model,@PathVariable("status") Integer status){
        List<JobInf>  lists=jobService.findByStatus(status);
        model.addAttribute("job",lists);
        return "index2";
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

    @GetMapping("/update2/{id}")
    public String update_Show2(Model model, @PathVariable("id") String jobId)
    {
        JobInf job = jobService.FindOne(jobId);
        model.addAttribute("job",job);
        model.addAttribute("cap","修改兼职人员信息");
        return "update2";
    }

    @PostMapping("/update2/{id}")
    public String update_Submit2(Model model, @PathVariable("id") String jobId, @ModelAttribute JobInf job)
    {
        //stu.setStuID(stuID);
        JobInf tmp=new JobInf();
        tmp.setJobId(jobId);
        tmp.setJobTitle(job.getJobTitle());
        tmp.setJobType(job.getJobType());
        tmp.setJobPlace(job.getJobPlace());
        tmp.setJobPhone(job.getJobPhone());
        tmp.setJobPNum(job.getJobPNum());
        tmp.setJobIntroduce(job.getJobIntroduce());
        tmp.setJobStatus(job.getJobStatus());
        jobService.UpdateJob(tmp);
        model.addAttribute("job",job);
        //return getAllStu(model);
        return "result2";
    }

    @GetMapping("/update3/{id}")
    public String update_Show3(Model model, @PathVariable("id") String UserName)
    {
        User user = userService.findOne(UserName);
        model.addAttribute("user",user);
        model.addAttribute("cap","修改兼职人员信息");
        return "update3";
    }

    @PostMapping("/update3/{id}")
    public String update_Submit3(Model model, @PathVariable("id") String UserName, @ModelAttribute User user)
    {
        //stu.setStuID(stuID);
        User tmp=new User();
        tmp.setUserName(UserName);
        tmp.setIdentity(user.getIdentity());
        userService.UpdateUser(tmp);
        model.addAttribute("user",user);
        //return getAllStu(model);
        return "result3";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable("id") String empId)
    {
        employeeService.deleteEmployee(empId);
        return "delSuc";
    }
    @GetMapping("/delete2/{id}")
    public String deleteById2(Model model, @PathVariable("id") String jobId)
    {
        jobService.deleteJob(jobId);
        return "delSuc2";
    }
    @GetMapping("/delete3/{id}")
    public String deleteById3(Model model, @PathVariable("id") String UserName)
    {
        userService.deleteUser(UserName);
        return "delSuc3";
    }

    @PostMapping("/check/{choice}")
    public void check(@PathVariable("choice") Integer choice, @ModelAttribute String empId) {
        EmployeeInf emp = employeeService.FindOne(empId);
        emp.setEmpStatus(choice);
        employeeService.UpdateEmployee(emp);
    }
}