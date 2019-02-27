package com.work.Repository;
import com.work.Entity.JobJudge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface JJudgeRepository extends JpaRepository<JobJudge,Integer> {
    @Query(value="select * from job_judge where bus_id=?1",nativeQuery = true)
    List<JobJudge> findJudge(@RequestParam("id") String id);
}