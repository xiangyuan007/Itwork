package com.work.Controller;

import com.work.Entity.*;
import com.work.Repository.ApplyInfRepository;
import com.work.Repository.ApplyListRepository;
import com.work.Repository.ApplyRepository;
import com.work.Repository.ConserveListRepository;
import com.work.Repository.ConserveRepository;
import com.work.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@RestController
@RequestMapping("wx")
public class WxController {
    @Autowired
    private UserService userService;
    @Autowired
    private ConserveService conserveService;
    @Autowired
    private JobService jobService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private EJudgeService eJudgeService;
    @Autowired
    private JJudgeService jJudgeService;
    @PostMapping("/wxLogin")
    public String wxLogin(@RequestParam String openid, String identity) {
        String success1 = "用户初次登录成功";
        String success2 = "用户登录成功";
        User user = new User();
        user = userService.findOne(openid);
        if (user != null)
            return success2;
        else {
            User tmp = new User();
            tmp.setUserName(openid);
            tmp.setIdentity(identity);
            userService.addUser(tmp);
        }
        return success1;
    }

    //收藏申请岗位信息
    @PostMapping("/addConserve")
    public int addConserve(@RequestBody JobConserve conserve) {
        return conserveService.addConserve(conserve);
    }

    //申请岗位信息
    @PostMapping("/addApply")
    public int addApply(@RequestBody JobApply apply) {
        return applyService.addApply(apply);
    }

    //取消收藏岗位信息
    @PostMapping("/deleteConserve")
    public int deleteConserve(@RequestBody JobConserve conserve) {
        String empId = conserve.getEmpId();
        String jobId = conserve.getJobId();
        return conserveService.deleteConserve(empId, jobId);
    }

    //取消申请岗位信息
    @PostMapping("/deleteApply")
    public int deleteApply(@RequestBody JobApply apply) {
        String empId = apply.getEmpId();
        String jobId = apply.getJobId();
        return applyService.deleteApply(empId, jobId);
    }

    //显示申请人列表.
    @Transactional
    @PostMapping("/showApply")
    public List<ApplyDetail> showApply(@RequestBody JobInf jobInf) {
        String busId = jobInf.getBusId();
        return applyService.findApplyInf(busId);
    }
    //显示收藏信息列表
    @Transactional
    @PostMapping("/showConserveList")
    public List<ConserveList> showConserveList(@RequestBody JobConserve jobConserve) {
        String empId = jobConserve.getEmpId();
        return conserveService.findConserveList(empId);
    }
    //显示申请信息列表
    @Transactional
    @PostMapping("/showApplyList")
    public List<ApplyList> showApplyList(@RequestBody JobApply jobApply) {
        String empId = jobApply.getEmpId();
        return applyService.findApplyList(empId);
    }
    //查询收藏信息
    @Transactional
    @PostMapping("/findConserve")
    public JobConserve findConserve(@RequestBody JobConserve jobConserve) {
        String empId = jobConserve.getEmpId();
        String jobId = jobConserve.getJobId();
        return conserveService.findConserve(empId, jobId);
    }

    //查询申请信息
    @Transactional
    @PostMapping("/findApply")
    public JobApply findApply(@RequestBody JobApply jobApply) {
        String empId = jobApply.getEmpId();
        String jobId = jobApply.getJobId();
        return applyService.findApply(empId, jobId);
    }

    //修改申请信息状态
    @Transactional
    @PostMapping("/updateApplyStatus")
    public int updateApplyStatus(@RequestBody JobApply jobApply) {
        String empId = jobApply.getEmpId();
        String jobId = jobApply.getJobId();
        String applyStatus = jobApply.getApplyStatus();

        return applyService.updateStatus(empId, jobId, applyStatus);
    }
 
    //增加用户信息
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    //查询用户信息
    @PostMapping("/findUser")
    public User findUser(@RequestBody User user) {
        return userService.findOne(user.getUserName());
    }

    //查询评价
    @PostMapping("/findEJudge")
    public List<EmployeeJudge> findEJudge(@RequestBody EmployeeJudge judge){return eJudgeService.findJudge(judge.getEmpId());}

    @PostMapping("/findJJudge")
    public List<JobJudge> findJJudge(@RequestBody JobJudge judge){return jJudgeService.findJudge(judge.getBusId());}
}