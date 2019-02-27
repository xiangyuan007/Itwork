package com.work.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobInf {
    @Id
    private String jobId;
    private String busId;
    private String jobTitle;
    private String jobType;
    private String jobPlace;
    private String jobPhone;
    private String jobPNum;
    private String jobIntroduce;
    private String jobStatus;
    private String jobDate;
    private String wxNickname;

    public String getWxNickname() {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname;
    }

    public String getJobDate() {
        return jobDate;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate;
    }

    public String getBusId() {
        return busId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public String getJobPhone() {
        return jobPhone;
    }

    public void setJobPhone(String jobPhone) {
        this.jobPhone = jobPhone;
    }

    public String getJobPNum() {
        return jobPNum;
    }

    public void setJobPNum(String jobPNum) {
        this.jobPNum = jobPNum;
    }

    public String getJobIntroduce() {
        return jobIntroduce;
    }

    public void setJobIntroduce(String jobIntroduce) {
        this.jobIntroduce = jobIntroduce;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
}