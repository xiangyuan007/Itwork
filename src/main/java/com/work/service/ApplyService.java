package com.work.service;
import com.work.Entity.ApplyDetail;
import com.work.Entity.ApplyList;
import com.work.Entity.JobApply;

import java.util.List;

public interface ApplyService {
    int addApply(JobApply apply);
    JobApply FindOne(Integer id);
    List<JobApply> FindAll();
    int deleteApply(String empId,String jobId);
    JobApply UpdateApply(JobApply apply);
    JobApply FindByJobId(String id);
    List<ApplyDetail> findApplyInf(String id);
    List<ApplyList> findApplyList(String id);
    JobApply findApply(String emp_id,String job_id);
    int updateStatus(String emp_id,String job_id,String applyStatus);
}