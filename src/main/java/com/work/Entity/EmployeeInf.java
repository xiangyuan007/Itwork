package com.work.Entity;
import javax.persistence.*;
@Entity
public class EmployeeInf {
        /*兼职人员信息
        兼职人员信息Id
        姓名
        性别
        电话号码
        地址
        学历
        简介
        审核状态*/
        @Id
        private String empId;
        private String empName;
        private String empSex;
        private String empPhone;
        private String empAddress;
        private String empDegree;
        private String empIntroduce;
        private Integer empStatus;

        public String getEmpId() {
                return empId;
        }

        public void setEmpId(String empId) {
                this.empId = empId;
        }

        public String getEmpName() {
                return empName;
        }

        public void setEmpName(String empName) {
                this.empName = empName;
        }

        public String getEmpSex() {
                return empSex;
        }

        public void setEmpSex(String empSex) {
                this.empSex = empSex;
        }

        public String getEmpPhone() {
                return empPhone;
        }

        public void setEmpPhone(String empPhone) {
                this.empPhone = empPhone;
        }

        public String getEmpAddress() {
                return empAddress;
        }

        public void setEmpAddress(String empAddress) {
                this.empAddress = empAddress;
        }

        public String getEmpDegree() {
                return empDegree;
        }

        public void setEmpDegree(String empDegree) {
                this.empDegree = empDegree;
        }

        public String getEmpIntroduce() {
                return empIntroduce;
        }

        public void setEmpIntroduce(String empIntroduce) {
                this.empIntroduce = empIntroduce;
        }

        public Integer getEmpStatus() {
                return empStatus;
        }

        public void setEmpStatus(Integer empStatus) {
                this.empStatus = empStatus;
        }
        }
