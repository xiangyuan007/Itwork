package com.work.Repository;
import com.work.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
public interface UserRepository extends JpaRepository<User,String>{

    List< User > findAllByUserName( String username );
}
