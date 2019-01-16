package com.work.service;
import com.work.Entity.JobInf;
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
}
