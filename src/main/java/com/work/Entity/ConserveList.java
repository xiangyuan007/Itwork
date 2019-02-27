package com.work.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConserveList {
    @Id
    private String jobId;
    private String jobTitle;
    private String jobType;
    private String jobPlace;
    private String conserveDate;
    private String busId;
    private String wxNickname;

    public String getWxNickname() {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname;
    }

    public String getConserveDate() {
        return conserveDate;
    }

    public void setConserveDate(String conserveDate) {
        this.conserveDate = conserveDate;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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
}
