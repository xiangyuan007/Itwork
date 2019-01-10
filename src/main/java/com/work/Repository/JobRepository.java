package com.work.Repository;
import com.work.Entity.JobInf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface JobRepository extends JpaRepository<JobInf,String>{
    //SQL
    // @Query(value="select e.* from employee_inf e", nativeQuery = true)
    //public List<EmployeeInf> findAllEmployee();
}
