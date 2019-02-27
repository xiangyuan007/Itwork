package com.work.Repository;
import com.work.Entity.JobInf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface JobRepository extends JpaRepository<JobInf,String>{
    @Query(value="select bus_id,job_id,job_title,job_type,job_place,job_date,job_status,wx_nickname from job_inf",nativeQuery = true)
    List<Map<String,String>> findPart();
    @Query(value="select bus_id,job_id,job_title,job_type,job_place,job_date,job_status,wx_nickname from job_inf where job_type=?1",nativeQuery = true)
    List<Map<String,String>> findPartByType(@RequestParam("type") String type);
    @Query(value="select bus_id,job_id,job_title,job_type,job_place,job_date,job_status,wx_nickname from job_inf where job_place=?1",nativeQuery = true)
    List<Map<String,String>> findPartByPlace(@RequestParam("place") String place);
    @Query(value="select bus_id,job_id,job_title,job_type,job_place,job_date,job_status,wx_nickname from job_inf where job_type=?1 and job_place=?2",nativeQuery = true)
    List<Map<String,String>> findPartByKey(@RequestParam("type") String type,@RequestParam("place") String place);
    @Query(value="select * from job_inf where bus_id=?1",nativeQuery = true)
    List<JobInf> findByBusId(@RequestParam("id") String id);
    @Query(value="select j.* from job_inf j where j.job_status=?1",nativeQuery = true)
    List<JobInf> findJobByStatus(@RequestParam("status") Integer status);
//    @Modifying
//    @Query(value="insert into job_inf (jobId, busId, jobTitle, jobType, jobPlace, jobPhone, jobPNum, jobIntroduce, jobStatus, jobDate) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)",nativeQuery = true)
//    int addJob(@RequestParam("jobId") String jobId,@RequestParam("busId") String busId,@RequestParam("jobTitle") String jobTitle,@RequestParam("jobType") String jobType,@RequestParam("jobPlace") String jobPlace,@RequestParam("jobPhone") String jobPhone,@RequestParam("jobPNum") String jobPNum,@RequestParam("jobIntroduce") String jobIntroduce,@RequestParam("jobStatus") String jobStatus,@RequestParam("jobDate") String jobDate);
}
