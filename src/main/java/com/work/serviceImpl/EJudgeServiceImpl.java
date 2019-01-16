package com.work.serviceImpl;

import com.work.Entity.EmployeeJudge;
import org.springframework.beans.factory.annotation.Autowired;
import com.work.Repository.EJudgeRepository;
import org.springframework.stereotype.Service;
import com.work.service.EJudgeService;
import java.util.List;
@Service
public class EJudgeServiceImpl implements EJudgeService {
    @Autowired
    private EJudgeRepository eJudgeRepository;
    @Override
    public EmployeeJudge addJudge(EmployeeJudge judge){
        return eJudgeRepository.save(judge);
    }
    public EmployeeJudge FindOne(String id){
        return eJudgeRepository.findById(id).get();
    }
    public List<EmployeeJudge> FindAll(){
        return eJudgeRepository.findAll();
    }
    public void deleteJudge(String id){
        eJudgeRepository.deleteById(id);
    }
    public EmployeeJudge UpdateJudge(EmployeeJudge judge){
        return eJudgeRepository.save(judge);
    }
}