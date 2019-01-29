package com.work.Controller;
import com.work.Entity.JobInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.work.service.JobService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("job")
public class JobController {
    @Autowired
    private JobService jobService;
    //增加一个工作信息
    @PostMapping("/add")
    private JobInf addJob(@RequestBody JobInf jobInf){
        return jobService.addJob(jobInf);
    }
    //根据ID查询一个工作信息
    @PostMapping(value = "/find")
    public JobInf FindOne(@RequestBody JobInf jobInf) {
        return jobService.FindOne(jobInf.getJobId());
    }
    //查询全部工作信息
    @PostMapping(value = "/findAll")
    public List<JobInf> FindAll() {
        return jobService.FindAll();
    }
    //根据ID删除一个工作信息
    @PostMapping(value = "/delete")
    public void deleteJob(@RequestBody JobInf jobInf) {
        jobService.deleteJob(jobInf.getJobId());
    }
    //更新
    @PostMapping(value = "/update")
    private JobInf UpdateJob(@RequestBody JobInf jobInfb){
        return jobService.UpdateJob(jobInfb);
    }
    //根据企业用户id查询岗位信息
    @PostMapping(value = "/findByBusId")
    public List<JobInf> findByBusId(@RequestBody JobInf jobInf) {
        return jobService.FindByBusId(jobInf.getBusId());
    }
    //查询岗位信息列表
    @PostMapping(value = "/findPart")
    List<Map<String,String>> findPart() {
        return jobService.findPart();
    }
    //选择地区和类型后查询岗位信息列表
    @PostMapping("/findPartByKey")
    public List<Map<String,String>> findPartByKey(@RequestBody JobInf jobInf) {
        System.out.println(jobInf.getJobType()+' '+jobInf.getJobPlace());
        return jobService.findPartByKey(jobInf.getJobType(),jobInf.getJobPlace());
    }
    //为企业用户添加岗位信息
    @PostMapping("/addJobById")
    private JobInf addJobById(@RequestBody JobInf jobInf){
        int i=0;
        int flag=1;
        String index=jobInf.getBusId();
        String jobId;
        jobId=index+i;
        JobInf job=new JobInf();
        System.out.println(jobId);
        try{
            job=jobService.FindOne(jobId);
        }
        catch(Exception e){
            flag=0;
        }
        while(flag!=0){
            i=(++i)%100;
            jobId=index+i;
            try{
                job=jobService.FindOne(jobId);
            }
            catch(Exception e){
                flag=0;
            }
        }
        jobInf.setJobId(jobId);
        return jobService.addJob(jobInf);
    }
}
