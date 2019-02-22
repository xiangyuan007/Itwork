package com.work.serviceImpl;

import com.work.Entity.JobInf;
import com.work.service.JobService;
import com.work.Repository.JobRepository;
import com.work.Entity.JobConserve;
import com.work.service.ConserveService;
import com.work.Repository.ConserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService{
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ConserveRepository conserveRepository;
    @Override
    public JobInf addJob(JobInf job){
        return jobRepository.save(job);
//        String jobId = job.getJobId();
//        String busId = job.getBusId();
//        String jobTitle = job.getJobTitle();
//        String jobType = job.getJobType();
//        String jobPlace = job.getJobPlace();
//        String jobPhone = job.getJobPhone();
//        String jobPNum = job.getJobPNum();
//        String jobIntroduce = job.getJobIntroduce();
//        String jobStatus = job.getJobStatus();
//        String jobDate = job.getJobDate();
//
//        return jobRepository.addJob(jobId, busId, jobTitle, jobType, jobPlace, jobPhone, jobPNum, jobIntroduce, jobStatus, jobDate);
    }
    public JobInf FindOne(String id){
        return jobRepository.findById(id).get();
    }
    public List<JobInf> FindAll(){
        return jobRepository.findAll();
    }
    public void deleteJob(String id){
        jobRepository.deleteById(id);
    }
    public JobInf UpdateJob(JobInf job){
        return jobRepository.save(job);
    }
    public List<Map<String,String>> findPart(){return jobRepository.findPart();}

    public JobConserve findSituByEmpId(String id){
        return conserveRepository.findById(Integer.valueOf(id)).get();//???????为什么要转换
    }

    @Transactional
    public List<Map<String,String>> findPartByKey(String type,String place){
        if(type==null&&place==null)
            return jobRepository.findPart();
        else if(type!=null&&place==null)
            return jobRepository.findPartByType(type);
        else if(type==null&&place!=null)
            return jobRepository.findPartByPlace(place);
        else
            return jobRepository.findPartByKey(type,place);
    }
    @Transactional
    public List<JobInf> FindByBusId(String id){
        return jobRepository.findByBusId(id);
    }

    @Transactional
    public List<JobInf> findByStatus(Integer status){
        if(status==-1)
            return jobRepository.findAll();
        else
            return jobRepository.findJobByStatus(status);
    }


}
