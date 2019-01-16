package com.work.Repository;
import com.work.Entity.JobApply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<JobApply,String> {
}
