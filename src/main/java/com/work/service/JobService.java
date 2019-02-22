package com.work.service;
import com.work.Entity.JobInf;
import com.work.Entity.JobConserve;

import java.util.List;
import java.util.Map;

public interface JobService {
    JobInf addJob(JobInf Job);
    JobInf FindOne(String id);
    List<JobInf> FindAll();
    void deleteJob(String id);
    JobInf UpdateJob(JobInf Job);
    List<Map<String,String>> findPart();
    List<Map<String,String>> findPartByKey(String type,String place);
    List<JobInf> FindByBusId(String id);
    //根据审核状态搜索兼职人员信息
    List<JobInf> findByStatus(Integer status);

    //查看本岗位收藏情况
    JobConserve findSituByEmpId(String id);
}
