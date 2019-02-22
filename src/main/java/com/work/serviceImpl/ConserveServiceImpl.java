package com.work.serviceImpl;

import com.work.Entity.ConserveList;
import com.work.Entity.JobConserve;
import com.work.Repository.ConserveListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.work.Repository.ConserveRepository;
import org.springframework.stereotype.Service;
import com.work.service.ConserveService;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ConserveServiceImpl implements ConserveService {
    @Autowired
    private ConserveRepository conserveRepository;
    @Autowired
    private ConserveListRepository conserveListRepository;
    @Override
    public int addConserve(JobConserve conserve){
        int flag=1;
        try {
            conserveRepository.save(conserve);
        }
        catch(Exception e){
            e.printStackTrace();
            flag=0;
        }
        return flag;
    }
    public JobConserve FindOne(Integer id){
        return conserveRepository.findById(id).get();
    }
    public List<JobConserve> FindAll(){
        return conserveRepository.findAll();
    }
    @Transactional
    public int deleteConserve(String empId,String jobId){
        int flag=1;
        try {
            conserveRepository.delete(empId,jobId);
        }
        catch(Exception e){
            e.printStackTrace();
            flag=0;
        }
        return flag;
    }

    public JobConserve UpdateConserve(JobConserve conserve){
        return conserveRepository.save(conserve);
    }

    @Transactional
    public List<ConserveList> findConserveList(String id){
        return conserveListRepository.findConserveList(id);
    }

    @Transactional
    public JobConserve findConserve(String emp_id,String job_id){
        return conserveRepository.findConserve(emp_id,job_id);
    }
}
