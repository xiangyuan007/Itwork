package com.work.serviceImpl;

import com.work.Entity.ApplyDetail;
import com.work.Entity.ApplyList;
import com.work.Entity.JobApply;
import com.work.Repository.ApplyInfRepository;
import com.work.Repository.ApplyListRepository;
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
    @Autowired
    private ApplyInfRepository applyInfRepository;
    @Autowired
    private ApplyListRepository applyListRepository;
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
    public JobApply FindOne(Integer id){
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

    @Transactional
    public List<ApplyDetail> findApplyInf(String id){
        return applyInfRepository.findApplyInf(id);
    }
    @Transactional
    public List<ApplyList> findApplyList(String id){
        return applyListRepository.findApplyList(id);
    }
    @Transactional
    public JobApply findApply(String emp_id,String job_id){
        return applyRepository.findApply(emp_id,job_id);
    }

    @Transactional
    public int updateStatus(String emp_id,String job_id,String applyStatus){
        return applyRepository.updateStatus(emp_id,job_id,applyStatus);
    }
}
