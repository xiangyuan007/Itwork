package com.work.serviceImpl;

import com.work.Entity.JobApply;
import org.springframework.beans.factory.annotation.Autowired;
import com.work.Repository.ApplyRepository;
import org.springframework.stereotype.Service;
import com.work.service.ApplyService;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyRepository applyRepository;
    @Override
    public int addApply(JobApply apply){
        int flag=1;
        try {
            applyRepository.save(apply);
        }
        catch(Exception e){
            e.printStackTrace();
            flag=0;
        }
        return flag;
    }
    public JobApply FindOne(String id){
        return applyRepository.findById(id).get();
    }
    public List<JobApply> FindAll(){
        return applyRepository.findAll();
    }
    @Transactional
    public int deleteApply(String empId,String jobId){
        int flag=1;
        try {
            applyRepository.delete(empId,jobId);
        }
        catch(Exception e){
            e.printStackTrace();
            flag=0;
        }
        return flag;
    }
    public JobApply UpdateApply(JobApply apply){
        return applyRepository.save(apply);
    }
    @Transactional
    public JobApply FindByJobId(String id){
        return applyRepository.findByJobId(id);
    }
}
