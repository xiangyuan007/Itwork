package com.work.serviceImpl;

import com.work.Entity.JobConserve;
import org.springframework.beans.factory.annotation.Autowired;
import com.work.Repository.ConserveRepository;
import org.springframework.stereotype.Service;
import com.work.service.ConserveService;
import java.util.List;
@Service
public class ConserveServiceImpl implements ConserveService {
    @Autowired
    private ConserveRepository conserveRepository;
    @Override
    public JobConserve addConserve(JobConserve conserve){
        return conserveRepository.save(conserve);
    }
    public JobConserve FindOne(String id){
        return conserveRepository.findById(id).get();
    }
    public List<JobConserve> FindAll(){
        return conserveRepository.findAll();
    }
    public void deleteConserve(String id){
        conserveRepository.deleteById(id);
    }
    public JobConserve UpdateConserve(JobConserve conserve){
        return conserveRepository.save(conserve);
    }
}
