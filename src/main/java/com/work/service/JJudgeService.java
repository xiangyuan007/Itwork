package com.work.service;
import com.work.Entity.JobJudge;
import java.util.List;

public interface JJudgeService {
    JobJudge addJudge(JobJudge judge);
    JobJudge FindOne(Integer id);
    List<JobJudge> FindAll();
    void deleteJudge(Integer id);
    JobJudge UpdateJudge(JobJudge judge);
    List<JobJudge> findJudge(String id);
}