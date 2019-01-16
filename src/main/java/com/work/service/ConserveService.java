package com.work.service;
import com.work.Entity.JobConserve;

import java.util.List;

public interface ConserveService {
    JobConserve addConserve(JobConserve conserve);
    JobConserve FindOne(String id);
    List<JobConserve> FindAll();
    void deleteConserve(String id);
    JobConserve UpdateConserve(JobConserve conserve);
}
