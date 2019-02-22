package com.work.Entity;
import javax.persistence.*;

//@GeneratedValue( strategy = GenerationType.IDENTITY )
@Entity
public class JobConserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empId;
    private String jobId;
    private String conserveDate;
    private String conserveStatus;

    public String getConserveStatus() {
        return conserveStatus;
    }

    public void setConserveStatus(String conserveStatus) {
        this.conserveStatus = conserveStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
