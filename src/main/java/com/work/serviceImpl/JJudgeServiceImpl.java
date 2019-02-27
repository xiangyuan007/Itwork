package com.work.serviceImpl;

import com.work.Entity.JobJudge;
import org.springframework.beans.factory.annotation.Autowired;
import com.work.Repository.JJudgeRepository;
import org.springframework.stereotype.Service;
import com.work.service.JJudgeService;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class JJudgeServiceImpl implements JJudgeService {
    @Autowired
    private JJudgeRepository jJudgeRepository;
    @Override
    public JobJudge addJudge(JobJudge judge){
        return jJudgeRepository.save(judge);
    }
    public JobJudge FindOne(Integer id){
        return jJudgeRepository.findById(id).get();
    }
    public List<JobJudge> FindAll(){
        return jJudgeRepository.findAll();
    }
    public void deleteJudge(Integer id){
        jJudgeRepository.deleteById(id);
    }
    public JobJudge UpdateJudge(JobJudge judge){
        return jJudgeRepository.save(judge);
    }
    @Transactional
    public List<JobJudge> findJudge(String id){
        return jJudgeRepository.findJudge(id);
    }
}
