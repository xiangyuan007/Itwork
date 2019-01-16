package com.work.serviceImpl;

import com.work.Entity.JobApply;
import org.springframework.beans.factory.annotation.Autowired;
import com.work.Repository.ApplyRepository;
import org.springframework.stereotype.Service;
import com.work.service.ApplyService;
import java.util.List;
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyRepository applyRepository;
    @Override
    public JobApply addApply(JobApply apply){
        return applyRepository.save(apply);
    }
    public JobApply FindOne(String id){
        return applyRepository.findById(id).get();
    }
    public List<JobApply> FindAll(){
        return applyRepository.findAll();
    }
    public void deleteApply(String id){
        applyRepository.deleteById(id);
    }
    public JobApply UpdateApply(JobApply apply){
        return applyRepository.save(apply);
    }
}
