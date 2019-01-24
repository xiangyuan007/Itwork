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
    private JobInf addJob(JobInf job){
        return jobService.addJob(job);
    }
    //根据ID查询一个工作信息
    @PostMapping(value = "/find")
    public JobInf FindOne(@RequestBody JobInf jobInf) {
        return jobService.FindOne(jobInf.getBusId());
    }
    //查询全部工作信息
    @GetMapping(value = "/findAll")
    public List<JobInf> FindAll() {
        return jobService.FindAll();
    }
    //根据ID删除一个工作信息
    @DeleteMapping(value = "/delete/{id}")
    public void deleteJob(@PathVariable("id") String id) {
        jobService.deleteJob(id);
    }
    //更新
    @PutMapping(value = "/update")
    private JobInf UpdateJob(JobInf job){
        return jobService.UpdateJob(job);
    }

    //查询岗位信息列表
    @GetMapping(value = "/findPart")
    List<Map<String,String>> findPart() {
        return jobService.findPart();
    }
    //选择地区和类型后查询岗位信息列表
    @PostMapping("/findPartByKey")
    public List<Map<String,String>> findPartByKey(@RequestBody JobInf jobInf) {
        System.out.println(jobInf.getJobType()+' '+jobInf.getJobPlace());
        return jobService.findPartByKey(jobInf.getJobType(),jobInf.getJobPlace());
    }
}
