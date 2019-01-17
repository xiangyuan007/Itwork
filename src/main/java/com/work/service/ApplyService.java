package com.work.service;
import com.work.Entity.JobApply;

import java.util.List;

public interface ApplyService {
    int addApply(JobApply apply);
    JobApply FindOne(String id);
    List<JobApply> FindAll();
    int deleteApply(String empId,String jobId);
    JobApply UpdateApply(JobApply apply);
    JobApply FindByJobId(String id);
}