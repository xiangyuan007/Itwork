package com.work.service;
import com.work.Entity.EmployeeJudge;

import java.util.List;

public interface EJudgeService {
    EmployeeJudge addJudge(EmployeeJudge judge);
    EmployeeJudge FindOne(Integer id);
    List<EmployeeJudge> FindAll();
    void deleteJudge(Integer id);
    EmployeeJudge UpdateJudge(EmployeeJudge judge);
    List<EmployeeJudge> findJudge(String id);
}
