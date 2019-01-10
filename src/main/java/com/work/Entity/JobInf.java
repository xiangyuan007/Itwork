package com.work.Entity;
import javax.persistence.*;
@Entity
public class JobInf {
    /*岗位信息id
    兼职标题
    兼职类型
    工作地点
    联系方式
    招聘人数
    简介
    审核状态*/
    @Id
    private String JobId;
    private String JobTitle;
    private String JobType;
    private String JobPlace;
    private String JobPhone;
    private String JobPNum;
    private String JobIntroduce;
    private String JobStatus;

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
    }

    public String getJobPlace() {
        return JobPlace;
    }

    public void setJobPlace(String jobPlace) {
        JobPlace = jobPlace;
    }

    public String getJobPhone() {
        return JobPhone;
    }

    public void setJobPhone(String jobPhone) {
        JobPhone = jobPhone;
    }

    public String getJobPNum() {
        return JobPNum;
    }

    public void setJobPNum(String jobPNum) {
        JobPNum = jobPNum;
    }

    public String getJobIntroduce() {
        return JobIntroduce;
    }

    public void setJobIntroduce(String jobIntroduce) {
        JobIntroduce = jobIntroduce;
    }

    public String getJobStatus() {
        return JobStatus;
    }

    public void setJobStatus(String jobStatus) {
        JobStatus = jobStatus;
    }
}
