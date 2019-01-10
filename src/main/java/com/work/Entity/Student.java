package com.work.Entity;
import javax.persistence.*;
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer stuID;
    private String stuName;
    private String stuPhone;
    private String stuAddress;

    public Integer getStuId(){
        return stuID;
    }
    public void setStuID(Integer stuID){
        this.stuID =stuID;
    }

    public String getStuName(){
        return stuName;
    }
    public void setStuName(String stuName){
        this.stuName =stuName;
    }

    public String getStuPhone(){
        return stuPhone;
    }
    public void setStuPhone(String stuPhone){
        this.stuPhone =stuPhone;
    }

    public String getStuAddress(){
        return stuAddress;
    }
    public void setStuAddress(String stuAddress){
        this.stuAddress =stuAddress;
    }
}
