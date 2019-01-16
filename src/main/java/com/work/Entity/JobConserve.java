package com.work.Entity;
import javax.persistence.*;

@Entity
public class JobConserve {

    @Id
    private String empId;
    private String jobId;
    private String conserveDate;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getConserveDate() {
        return conserveDate;
    }

    public void setConserveDate(String conserveDate) {
        this.conserveDate = conserveDate;
    }
}
