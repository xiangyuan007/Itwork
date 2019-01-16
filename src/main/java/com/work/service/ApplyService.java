package com.work.service;
import com.work.Entity.JobApply;

import java.util.List;

public interface ApplyService {
    JobApply addApply(JobApply apply);
    JobApply FindOne(String id);
    List<JobApply> FindAll();
    void deleteApply(String id);
    JobApply UpdateApply(JobApply apply);
}