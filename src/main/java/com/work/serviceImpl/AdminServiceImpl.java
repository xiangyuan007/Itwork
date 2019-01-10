package com.work.serviceImpl;
import com.work.Repository.AdminRepository;
import com.work.service.AdminService;
import com.work.Entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;
    @Override
    @Transactional
    public int hasAdmin(String name,String password){
        Administrator admin = adminRepository.findAdmin(name);
        if (admin!=null){
            if (admin.getAdminPassword().equals(password))
                return  1;
            else return 0;
        }
        return 2;
    }
    public Administrator UpdateAdmin(Administrator admin){
        return adminRepository.save(admin);
    }
    /*public void updateAdmin(String name,String password){
        adminRepository.updateAdmin(name,password);
    }*/
}
