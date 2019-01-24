package com.work.Repository;

import com.work.Entity.JobConserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import com.work.Entity.ConserveList;
import java.util.List;

public interface ConserveListRepository extends JpaRepository<ConserveList,String> {
    @Query(value="select conserve.job_id,job.job_title,job.job_type,job.job_place from " +
            "job_conserve conserve,job_inf job where conserve.emp_id=?1 and conserve.job_id=job.job_id",nativeQuery = true)
    List<ConserveList> findConserveList(@RequestParam("id") String id);
}
