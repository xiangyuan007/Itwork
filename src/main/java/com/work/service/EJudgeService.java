package com.work.service;
import com.work.Entity.EmployeeJudge;

import java.util.List;

public interface EJudgeService {
    EmployeeJudge addJudge(EmployeeJudge judge);
    EmployeeJudge FindOne(String id);
    List<EmployeeJudge> FindAll();
    void deleteJudge(String id);
    EmployeeJudge UpdateJudge(EmployeeJudge judge);
}
