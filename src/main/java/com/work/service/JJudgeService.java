package com.work.service;
import com.work.Entity.JobJudge;
import java.util.List;

public interface JJudgeService {
    JobJudge addJudge(JobJudge judge);
    JobJudge FindOne(String id);
    List<JobJudge> FindAll();
    void deleteJudge(String id);
    JobJudge UpdateJudge(JobJudge judge);
}