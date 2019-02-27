package com.work.Repository;
import com.work.Entity.EmployeeJudge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EJudgeRepository extends JpaRepository<EmployeeJudge,Integer> {
    @Query(value="select * from employee_judge where emp_id=?1",nativeQuery = true)
    List<EmployeeJudge> findJudge(@RequestParam("id") String id);
}
