package com.work.Repository;
import com.work.Entity.JobInf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface JobRepository extends JpaRepository<JobInf,String>{
    @Query(value="select bus_id,job_id,job_title,job_type,job_place from job_inf",nativeQuery = true)
    List<Map<String,String>> findPart();
    @Query(value="select bus_id,job_id,job_title,job_type,job_place from job_inf where job_type=?1",nativeQuery = true)
    List<Map<String,String>> findPartByType(@RequestParam("type") String type);
    @Query(value="select bus_id,job_id,job_title,job_type,job_place from job_inf where job_place=?1",nativeQuery = true)
    List<Map<String,String>> findPartByPlace(@RequestParam("place") String place);
    @Query(value="select bus_id,job_id,job_title,job_type,job_place from job_inf where job_type=?1 and job_place=?2",nativeQuery = true)
    List<Map<String,String>> findPartByKey(@RequestParam("type") String type,@RequestParam("place") String place);
    @Query(value="select * from job_inf where bus_id=?1",nativeQuery = true)
    List<JobInf> findByBusId(@RequestParam("id") String id);
}
