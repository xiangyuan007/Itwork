package com.work.Repository;
import com.work.Entity.JobConserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ConserveRepository extends JpaRepository<JobConserve,String> {
    @Modifying
    @Query(value="delete from job_conserve where emp_id=?1 and job_id=?2",nativeQuery = true)
    void delete(@RequestParam("emp_id") String emp_id,@RequestParam("job_id") String job_id);
}
