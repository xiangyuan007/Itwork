package com.work.Repository;
import com.work.Entity.EmployeeJudge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EJudgeRepository extends JpaRepository<EmployeeJudge,String> {
}
