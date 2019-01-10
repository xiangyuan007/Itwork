package com.work.Controller;
import com.work.Entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.work.service.AdminService;
import java.util.List;
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PutMapping(value = "/update")
    private Administrator UpdateAdmin(Administrator admin){
        return adminService.UpdateAdmin(admin);
    }
}
