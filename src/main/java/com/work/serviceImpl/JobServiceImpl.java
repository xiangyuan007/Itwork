package com.work.serviceImpl;

import com.work.Entity.JobInf;
import com.work.service.JobService;
import com.work.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService{
    @Autowired
    private JobRepository jobRepository;
    @Override
    public JobInf addJob(JobInf job){
        return jobRepository.save(job);
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
}
