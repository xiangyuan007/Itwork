package com.work.Repository;
import com.work.Entity.JobConserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConserveRepository extends JpaRepository<JobConserve,String> {
}
