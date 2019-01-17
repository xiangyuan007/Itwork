package com.work.service;
import com.work.Entity.JobConserve;

import java.util.List;

public interface ConserveService {
    int addConserve(JobConserve conserve);
    JobConserve FindOne(String id);
    List<JobConserve> FindAll();
    int deleteConserve(String empId,String jobId);
    JobConserve UpdateConserve(JobConserve conserve);
}
