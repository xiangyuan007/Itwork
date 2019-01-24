package com.work.Controller;

import com.work.Entity.*;
import com.work.Repository.ApplyInfRepository;
import com.work.Repository.ApplyListRepository;
import com.work.Repository.ConserveListRepository;
import com.work.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
//new
@RestController
@RequestMapping("wx")
public class WxController {
    //@Autowired
    //HttpClient httpClient;
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
    private ApplyInfRepository applyInfRepository;
    @Autowired
    private ConserveListRepository conserveListRepository;
    @Autowired
    private ApplyListRepository applyListRepository;
    @PostMapping("/wxLogin")
    public String wxLogin(@RequestParam String openid, String identity) {
        String success1 = "用户初次登录成功";
        String success2 = "用户登录成功";
        /*System.out.println("wxLogin-code:"+code);
        String url="https://api.weixin.qq.com/sns/jscode2session";
        HttpMethod method =HttpMethod.POST;
        MultiValueMap<String, String> param= new LinkedMultiValueMap<String, String>();
        param.add("appid","wxa4958450998eb776");
        param.add("secret","625211eb2ee7a1390784bc941b263cbd");
        param.add("js_code",code);
        param.add("grant_type","authorization_code");
        String data = httpClient.client(url,method,param);
        System.out.println(data);
        return success;*/
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

    //显示申请人列表
    /*@PostMapping("/findEmpByBus")
    public List<Map<String, String>> findEmpByBus(@RequestBody JobInf jobInf) {
        String busId = jobInf.getBusId();
        List<JobInf> job = new ArrayList<JobInf>();
        EmployeeInf emp = new EmployeeInf();
        JobApply apply = new JobApply();
        job = jobService.FindByBusId(busId);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (JobInf str : job) {
            Map<String, String> map = new HashMap<String, String>();
            String jobId = str.getJobId();
            String title = str.getJobTitle();
            apply = applyService.FindByJobId(jobId);
            String date = apply.getApplyDate();
            String empId = apply.getEmpId();
            emp = employeeService.FindOne(empId);
            String name = emp.getEmpName();
            String sex = emp.getEmpSex();
            String degree = emp.getEmpDegree();
            String address = emp.getEmpAddress();
            map.put("emp_id", empId);
            map.put("emp_name", name);
            map.put("emp_sex", sex);
            map.put("emp_degree", degree);
            map.put("emp_address", address);
            map.put("job_id", jobId);
            map.put("job_title", title);
            map.put("apply_date", date);
            list.add(map);
        }
        return list;
    }*/
    //显示申请人列表
    @Transactional
    @PostMapping("/showApply")
    public List<ApplyDetail> showApply(@RequestBody JobInf jobInf) {
        //tring busId = jobInf.getBusId();
       // return applyInfRepository.findApplyInf(busId);
        return null;
    }
    //显示收藏心信息列表
    @Transactional
    @PostMapping("/showConserveList")
    public List<ConserveList> showConserveList(@RequestBody JobConserve jobConserve) {
        String empId = jobConserve.getEmpId();
        return conserveListRepository.findConserveList(empId);
    }
    //显示申请信息列表
    @Transactional
    @PostMapping("/showApplyList")
    public List<ApplyList> showApplyList(@RequestBody JobApply jobApply) {
        String empId = jobApply.getEmpId();
        return applyListRepository.findApplyList(empId);
    }
}