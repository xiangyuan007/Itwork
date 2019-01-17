package com.work.Repository;
import com.work.Entity.JobInf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import com.work.service.ApplyDetail;
import java.util.List;

public interface ApplyInfRepository extends JpaRepository<JobInf,String> {
    @Query(value="select job.job_id,emp.emp_id,emp.emp_name,emp.emp_sex,emp.emp_degree,emp.emp_address," +
            "job.job_title,apply.apply_date from job_inf job,employee_inf emp,job_apply apply " +
            "where job.bus_id=?1 and job.job_id=apply.job_id and apply.emp_id=emp.emp_id",nativeQuery = true)
    List<ApplyDetail> findApplyInf(@RequestParam("id") String id);
}
