package com.work.service;
import com.work.Entity.Administrator;
public interface AdminService {
    int hasAdmin(String name,String password);
    Administrator UpdateAdmin(Administrator admin);
    //void updateAdmin(String name,String password);
}
