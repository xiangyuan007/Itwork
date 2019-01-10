package com.work.Controller;
import com.work.Entity.JobInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.work.service.JobService;
import com.work.Repository.JobRepository;

import javax.transaction.Transactional;
import java.util.List;

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
    @GetMapping(value = "/find/{id}")
    public JobInf FindOne(@PathVariable("id") String id) {
        return jobService.FindOne(id);
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
}
