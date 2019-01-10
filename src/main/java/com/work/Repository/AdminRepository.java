package com.work.Repository;
import com.work.Entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminRepository extends JpaRepository<Administrator,String>{
    @Query(value="select a.* from Administrator a where a.admin_name=?1",nativeQuery = true)
    Administrator findAdmin(@RequestParam("name") String name);
    /*@Modifying
    @Query(value = "update Administrator set adminPassword=?2 where adminName=?1 ", nativeQuery = true)
    void updateAdmin(@RequestParam("name") String name,@RequestParam("password") String password);*/
}
