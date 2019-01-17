package com.work.Repository;
import com.work.Entity.JobApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ApplyRepository extends JpaRepository<JobApply,String> {
    @Modifying
    @Query(value="delete from job_apply where emp_id=?1 and job_id=?2",nativeQuery = true)
    void delete(@RequestParam("emp_id") String emp_id, @RequestParam("job_id") String job_id);
    @Query(value="select * from job_apply where job_id=?1",nativeQuery = true)
    JobApply findByJobId(@RequestParam("id") String id);
}
