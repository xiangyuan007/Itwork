package com.work.Repository;
import com.work.Entity.EmployeeInf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeInf,String>{
    @Query(value="select e.* from employee_inf e where e.emp_status=?1",nativeQuery = true)
    List<EmployeeInf> findEmployeeByStatus(@RequestParam("status") Integer status);
}
