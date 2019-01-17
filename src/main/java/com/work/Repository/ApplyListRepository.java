package com.work.Repository;

import com.work.Entity.JobApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import com.work.service.ApplyList;
import java.util.List;

public interface ApplyListRepository extends JpaRepository<JobApply,String> {
    @Query(value="select apply.job_id,job.job_title,job.job_type,job.job_place from " +
            "JobApply apply,job_inf job where apply.emp_id=?1 and apply.job_id=job.job_id",nativeQuery = true)
    List<ApplyList> findApplyList(@RequestParam("id") String id);
}